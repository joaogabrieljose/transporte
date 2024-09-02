package pt.com.transporteapi.transporteapi.domain.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.transporteapi.transporteapi.application.mapper.MotoristaMapper;
import pt.com.transporteapi.transporteapi.application.request.MotoristaRequest;
import pt.com.transporteapi.transporteapi.application.response.MotoristaResponse;
import pt.com.transporteapi.transporteapi.domain.Entity.Motorista;
import pt.com.transporteapi.transporteapi.domain.Entity.Veiculo;
import pt.com.transporteapi.transporteapi.domain.repository.IMotoristaRepository;
import pt.com.transporteapi.transporteapi.domain.repository.IVeiculoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {
    @Autowired
    private IMotoristaRepository motoristaService;

    @Autowired
    private IVeiculoRepository serviceVeiculo;

    public MotoristaResponse create(MotoristaRequest request) {  // criar motorista
        var novo = MotoristaMapper.toMotorista(request);
        var create = motoristaService.save(novo);
        MotoristaResponse motoristaResponse = MotoristaMapper.toMotoristaResponse(create);
        return motoristaResponse;
    }


    public MotoristaResponse updateMotorista(long id, MotoristaRequest request) {  // atualizar motorista

        var motorista = MotoristaMapper.toMotorista(request);

        var novoMotorista = motoristaService.findMotoristaById(id)
                .orElseThrow(() -> new EntityNotFoundException("motorista não encontrado com id" + id));

        novoMotorista.setName(motorista.getName());
        novoMotorista.setDisponivel(motorista.isDisponivel());
        novoMotorista.setLicenca(motorista.getLicenca());
        novoMotorista.setVeiculo(motorista.getVeiculo());

        var response = motoristaService.save(novoMotorista);
        return MotoristaMapper.toMotoristaResponse(response);
    }

    public boolean deleteById(long id) {   // apaga motorista por id
        Optional<Motorista> motorista = motoristaService.findMotoristaById(id);
        if (motorista.isPresent()) {
            motoristaService.deleteById(id);
            return true;
        }
        return false;
    }

    public List<MotoristaResponse> findMotoristaAll() {  // salva motorista
        List<Motorista> novoMotorista = (List<Motorista>) motoristaService.findAll();
        List<MotoristaResponse> create = novoMotorista.stream().map(MotoristaMapper::toMotoristaResponse).toList();
        return create;
    }

    public MotoristaResponse getMotoristaById(long id) {   // busca motorista por id
        Optional<Motorista> motorista = motoristaService.findMotoristaById(id);
        Motorista novoMotorista = motorista.orElseThrow(() -> new EntityNotFoundException("motorista não encontrado com id" + id));
        return MotoristaMapper.toMotoristaResponse(novoMotorista);
    }

    // Atribuir um motorista a um veículo.
    public boolean atribuirMotoristaAoVeiculo(long motoristaId, long veiculoId) {
        Optional<Motorista> novoMotorista = motoristaService.findMotoristaById(motoristaId);

        Optional<Veiculo> veiculo = serviceVeiculo.findVeiculoById(veiculoId);

        if (novoMotorista.isPresent() && veiculo.isPresent()) {
            Veiculo novo = veiculo.get();
            Motorista motoristaAtribuir = novoMotorista.get();

            novo.setMotorista(motoristaAtribuir);
            serviceVeiculo.save(novo);
            return true;
        }
        return false;
    }


}
