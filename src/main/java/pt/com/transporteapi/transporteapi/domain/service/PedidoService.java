package pt.com.transporteapi.transporteapi.domain.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.transporteapi.transporteapi.domain.Entity.Pedido;
import pt.com.transporteapi.transporteapi.domain.Entity.StatusPedido;
import pt.com.transporteapi.transporteapi.domain.repository.IPedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private IPedidoRepository repository;

    public Pedido create(Pedido pedido) {
        return repository.save(pedido);
    }


    public Pedido updateStatusPedido(long id, StatusPedido novoStatus) {
        Optional<Pedido> pedidoNovo = repository.findPedidoById(id);
        if (pedidoNovo.isPresent()) {
            Pedido novo = pedidoNovo.get();
            if (isValidStatusTransition(novo.getStatus(), novoStatus)) { // Verifica a transição de status é válida
                novo.setStatus(StatusPedido.valueOf(String.valueOf(novoStatus)));
                return repository.save(novo);
            } else {
                throw new IllegalStateException("Transição de status inválida: de "
                        + novo.getStatus() + " para " + novoStatus);
            }
        }
        throw new EntityNotFoundException("Pedido com ID " + id + " não encontrado.");
    }

    private boolean isValidStatusTransition(StatusPedido statusAtual, StatusPedido novoStatus) {
        if (statusAtual == StatusPedido.PEDNDENTE && novoStatus == StatusPedido.EM_TRANSITO) {
            return true;
        } else if (statusAtual == StatusPedido.EM_TRANSITO && novoStatus == StatusPedido.ENTREGUE) {
            return true;
        } else if (statusAtual == StatusPedido.PEDNDENTE && novoStatus == StatusPedido.ENTREGUE) {
            return true;
        } else {
            return false;
        }
    }


    public List<Pedido> findPedidoAll(){
        return (List<Pedido>) repository.findAll();
    }

    public Pedido getPedidoById(long id){
        Optional<Pedido> pedido = repository.findPedidoById(id);
        return pedido.orElseThrow(()-> new EntityNotFoundException("pedido não encontrado com id"+id));
    }

    public boolean deleteById(long id){
        Optional<Pedido> pedido = repository.findPedidoById(id);
        if (pedido.isPresent()){
            repository.deleteById(id);
            return  true;
        }
        return  false;
    }
}
