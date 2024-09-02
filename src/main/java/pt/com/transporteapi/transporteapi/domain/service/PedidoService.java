package pt.com.transporteapi.transporteapi.domain.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.transporteapi.transporteapi.application.mapper.PedidoMapper;
import pt.com.transporteapi.transporteapi.application.request.PedidoRequest;
import pt.com.transporteapi.transporteapi.application.response.PedidoResponse;
import pt.com.transporteapi.transporteapi.domain.Entity.Pedido;
import pt.com.transporteapi.transporteapi.domain.Entity.StatusPedido;
import pt.com.transporteapi.transporteapi.domain.repository.IPedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private IPedidoRepository repository;

    public PedidoResponse create(PedidoRequest request) {
        var create = PedidoMapper.toPedido(request);
        var pedido = repository.save(create);
        PedidoResponse novo = PedidoMapper.toPedidoRespponse(pedido);
        return novo;
    }

    public Pedido updateStatusPedido(long id, StatusPedido novoStatus) {
        Optional<Pedido> pedidoNovo = repository.findPedidoById(id);
        if (pedidoNovo.isPresent()) {
            Pedido novo = pedidoNovo.get();

            if (novo.getStatus() == null || novoStatus == null) {
                throw new IllegalStateException("Transição de status inválida: de "
                        + novo.getStatus() + " para " + novoStatus);
            }
            if (isValidStatusTransition(novo.getStatus(), novoStatus)) {
                novo.setStatus(novoStatus);
                return repository.save(novo);
            } else {
                throw new IllegalStateException("Transição de status inválida: de "
                        + novo.getStatus() + " para " + novoStatus);
            }
        } else {
            throw new EntityNotFoundException("Pedido com ID " + id + " não encontrado.");
        }
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


    public List<PedidoResponse> findPedidoAll() {
        List<Pedido> novo = (List<Pedido>) repository.findAll();
        List<PedidoResponse> findPedido = novo.stream().map(PedidoMapper::toPedidoRespponse).toList();
        return findPedido;
    }

    public PedidoResponse getPedidoById(long id) {
        Pedido pedido = repository.findPedidoById(id)
                .orElseThrow(() -> new EntityNotFoundException("edido não encontrado com id"));
        return PedidoMapper.toPedidoRespponse(pedido);
    }

    public PedidoResponse update(long id, PedidoRequest pedido) {
        var updatePedido = PedidoMapper.toPedido(pedido);
        var update = repository.findPedidoById(id).orElseThrow(() -> new
                EntityNotFoundException("pedido não encontrado com id" + id));

        update.setEndercoOrigem(updatePedido.getEndercoOrigem());
        update.setEnderecoDestino(updatePedido.getEnderecoDestino());
        update.setDataEntregaPrevista(updatePedido.getDataEntregaPrevista());
        update.setStatus(updatePedido.getStatus());
        update.setDataCriacao(updatePedido.getDataCriacao());
        update.setVeiculo(updatePedido.getVeiculo());
        update.setMotorista(updatePedido.getMotorista());
        var novo = repository.save(update);
        return PedidoMapper.toPedidoRespponse(novo);
    }

    public boolean deleteById(long id) {
        Optional<Pedido> pedido = repository.findPedidoById(id);
        if (pedido.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
