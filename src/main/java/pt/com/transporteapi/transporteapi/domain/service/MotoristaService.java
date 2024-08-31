package pt.com.transporteapi.transporteapi.domain.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.transporteapi.transporteapi.domain.Entity.Motorista;
import pt.com.transporteapi.transporteapi.domain.repository.IMotoristaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {
    @Autowired
    private IMotoristaRepository motoristaService;

    public Motorista create(Motorista motorista) {  // criar motorista
        return motoristaService.save(motorista);
    }

    public Motorista updateMotorista(long id, Motorista motorista) {  // atualizar motorista
       Motorista novoMotorista  = motoristaService.findMotoristaById(id)
               .orElseThrow(()-> new EntityNotFoundException("motorista não encontrado com id"+id));
        novoMotorista.setName(motorista.getName());
       novoMotorista.setDisponivel(motorista.isDisponivel());
       novoMotorista.setLicenca(motorista.getLicenca());
       novoMotorista.setVeiculo(motorista.getVeiculo());
       return motoristaService.save(novoMotorista);
    }

    public boolean deleteById(long id) {   // apaga motorista por id
        Optional<Motorista> motorista = motoristaService.findMotoristaById(id);
        if (motorista.isPresent()) {
            motoristaService.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Motorista> findMotoristaAll() {  // salva motorista
        return (List<Motorista>) motoristaService.findAll();
    }

    public Motorista getMotoristaById(long id) {   // busca motorista por id
        Optional<Motorista> motorista = motoristaService.findMotoristaById(id);
        return motorista.orElseThrow(() -> new RuntimeException("motorista não encontrado com id" + id));
    }

}
