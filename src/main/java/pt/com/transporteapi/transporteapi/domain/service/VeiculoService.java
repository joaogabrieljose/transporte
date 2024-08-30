package pt.com.transporteapi.transporteapi.domain.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.transporteapi.transporteapi.domain.Entity.Motorista;
import pt.com.transporteapi.transporteapi.domain.Entity.Veiculo;
import pt.com.transporteapi.transporteapi.domain.repository.IMotoristaRepository;
import pt.com.transporteapi.transporteapi.domain.repository.IVeiculoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private IVeiculoRepository serviceVeiculo;

    @Autowired
    private IMotoristaRepository motorista;

    public Veiculo createVeiculo(Veiculo veiculo) {
        return serviceVeiculo.save(veiculo);
    }

    public Veiculo updateVeiculo(long id, Veiculo veiculo) {
        Veiculo veiculoId = serviceVeiculo.findVeiculoById(id)
                .orElseThrow(() -> new EntityNotFoundException("veiculo não encontrado com id" + id));
        veiculoId.setMotorista(veiculo.getMotorista());
        veiculoId.setModelo(veiculo.getModelo());
        veiculoId.setCapacidade(veiculo.getCapacidade());
        veiculoId.setPlaca(veiculo.getPlaca());
        veiculoId.setDisponivel(veiculo.isDisponivel());
        return serviceVeiculo.save(veiculoId);
    }

    public List<Veiculo> findVeiculoAll() {
        return (List<Veiculo>) serviceVeiculo.findAll();
    }

    public Veiculo getVeiculoById(long id) {
        Optional<Veiculo> veiculo = serviceVeiculo.findVeiculoById(id);
        return veiculo.orElseThrow(() -> new EntityNotFoundException("veiculo não encontrado com id" + id));
    }


    // Atribuir um motorista a um veículo.
    public boolean atribuirMotoristaAoVeiculo(long motoristaId, long veiculoId) {
        Optional<Motorista> novoMotorista = motorista.findMotoristaById(motoristaId);
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

    public boolean deleteById(long id){
        serviceVeiculo.deleteById(id);
        return true;
    }
}
