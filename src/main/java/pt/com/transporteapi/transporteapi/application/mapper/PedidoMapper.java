package pt.com.transporteapi.transporteapi.application.mapper;

import pt.com.transporteapi.transporteapi.application.request.PedidoRequest;
import pt.com.transporteapi.transporteapi.application.response.PedidoResponse;
import pt.com.transporteapi.transporteapi.domain.Entity.Motorista;
import pt.com.transporteapi.transporteapi.domain.Entity.Pedido;
import pt.com.transporteapi.transporteapi.domain.Entity.Veiculo;

public class PedidoMapper {

    public static Pedido toPedido(PedidoRequest request) {
        Pedido pedido = new Pedido();
        if (request.getVeiculoId() != 0) {
            Veiculo veiculo = new Veiculo();
            veiculo.setId(request.getVeiculoId());
            pedido.setVeiculo(veiculo);
        }
        if(request.getMotoristaId() != 0){
            Motorista motorista = new Motorista();
            motorista.setId(request.getMotoristaId());
            pedido.setMotorista(motorista);
        }
        pedido.setEndercoOrigem(request.getEndercoOrigem());
        pedido.setEnderecoDestino(request.getEnderecoDestino());
        pedido.setPeso(request.getPeso());
        pedido.setDataCriacao(request.getDataCriacao());
        pedido.setDataEntregaPrevista(request.getDataEntregaPrevista());
        return pedido;
    }

    public static PedidoResponse toPedidoRespponse(Pedido pedido) {
        PedidoResponse response = new PedidoResponse();

        if(pedido.getVeiculo() != null){
            response.setVeiculoId(pedido.getVeiculo().getId());
        }
        if(pedido.getMotorista() != null){
            response.setMotoristaId(pedido.getMotorista().getId());
        }
        response.setId(pedido.getId());
        response.setEndercoOrigem(pedido.getEndercoOrigem());
        response.setEnderecoDestino(pedido.getEnderecoDestino());
        response.setDataCriacao(pedido.getDataCriacao());
        response.setDataEntregaPrevista(pedido.getDataEntregaPrevista());
        return response;
    }
}
