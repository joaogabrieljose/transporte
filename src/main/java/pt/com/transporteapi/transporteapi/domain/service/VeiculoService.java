package pt.com.transporteapi.transporteapi.domain.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.transporteapi.transporteapi.application.mapper.VeiculoMapper;
import pt.com.transporteapi.transporteapi.application.request.VeiculoRequest;
import pt.com.transporteapi.transporteapi.application.response.VeiculoResponse;
import pt.com.transporteapi.transporteapi.domain.Entity.Veiculo;
import pt.com.transporteapi.transporteapi.domain.repository.IVeiculoRepository;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private IVeiculoRepository serviceVeiculo;


    public VeiculoResponse createVeiculo(VeiculoRequest request) {
        var create = VeiculoMapper.toVeiculo(request);
        var novo = serviceVeiculo.save(create);
        VeiculoResponse novoVeiculo = VeiculoMapper.toVeiculoResponse(novo);
        return novoVeiculo;
    }

    public VeiculoResponse updateVeiculo(long id, VeiculoRequest veiculo) {
        var novoVeiculo = VeiculoMapper.toVeiculo(veiculo);

        var veiculoId = serviceVeiculo.findVeiculoById(id)
                .orElseThrow(() -> new EntityNotFoundException("veiculo não encontrado com id" + id));

        veiculoId.setMotorista(novoVeiculo.getMotorista());
        veiculoId.setModelo(novoVeiculo.getModelo());
        veiculoId.setCapacidade(novoVeiculo.getCapacidade());
        veiculoId.setPlaca(novoVeiculo.getPlaca());
        veiculoId.setDisponivel(novoVeiculo.isDisponivel());

        var veiculoUpdate = serviceVeiculo.save(veiculoId);
        return VeiculoMapper.toVeiculoResponse(veiculoUpdate);
    }

    public List<VeiculoResponse> findaVeiculoAll() {
        List<Veiculo> novo = (List<Veiculo>) serviceVeiculo.findAll();
        List<VeiculoResponse> lista = novo.stream().map(VeiculoMapper::toVeiculoResponse).toList();
        return lista;
    }

    public VeiculoResponse getVeiculoById(long id) {
        Veiculo veiculo = serviceVeiculo.findVeiculoById(id)
                .orElseThrow(() -> new EntityNotFoundException("veiculo não encontrado com id" + id));
        return VeiculoMapper.toVeiculoResponse(veiculo);
    }


    public boolean deleteById(long id) {
        serviceVeiculo.deleteById(id);
        return true;
    }
}
