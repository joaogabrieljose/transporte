package pt.com.transporteapi.transporteapi.domain.repository;

import org.springframework.data.repository.CrudRepository;
import pt.com.transporteapi.transporteapi.domain.Entity.Pedido;

import java.util.Optional;

public interface IPedidoRepository extends CrudRepository<Pedido,Long> {
    Optional<Pedido> findPedidoById(long id);
}
