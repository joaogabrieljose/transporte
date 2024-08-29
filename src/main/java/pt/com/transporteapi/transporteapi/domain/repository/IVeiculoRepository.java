package pt.com.transporteapi.transporteapi.domain.repository;

import org.springframework.data.repository.CrudRepository;
import pt.com.transporteapi.transporteapi.domain.Entity.Veiculo;

import java.util.Optional;

public interface IVeiculoRepository extends CrudRepository<Veiculo,Long> {
    Optional<Veiculo> findVeiculoById(long id);
}
