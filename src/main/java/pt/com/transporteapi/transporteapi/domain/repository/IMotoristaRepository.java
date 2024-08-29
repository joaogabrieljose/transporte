package pt.com.transporteapi.transporteapi.domain.repository;

import org.springframework.data.repository.CrudRepository;
import pt.com.transporteapi.transporteapi.domain.Entity.Motorista;

import java.util.Optional;

public interface IMotoristaRepository extends CrudRepository<Motorista, Long> {
    Optional<Motorista> findMotoristaById(long id);
}
