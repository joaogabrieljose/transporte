package pt.com.transporteapi.transporteapi.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.com.transporteapi.transporteapi.domain.Entity.Rota;

import java.util.Optional;
@Repository
public interface RotaRepository extends CrudRepository<Rota, Long> {
    Optional<Rota> findRitaById(long id);
}
