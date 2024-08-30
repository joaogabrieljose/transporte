package pt.com.transporteapi.transporteapi.application.mapper;

import pt.com.transporteapi.transporteapi.application.request.PedidoRequest;
import pt.com.transporteapi.transporteapi.application.response.PedidoResponse;
import pt.com.transporteapi.transporteapi.domain.Entity.Pedido;
import pt.com.transporteapi.transporteapi.domain.Entity.Veiculo;

public class PedidoMapper {

    public static Pedido toPedido(PedidoRequest request){
        Pedido pedido = new Pedido();
        pedido.setId(request.getId());
        pedido.setEndercoOrigem(request.getEndercoOrigem());
        pedido.setEnderecoDestino(request.getEnderecoDestino());
       pedido.setPeso(request.getPeso());
        pedido.setDataCriacao(request.getDataCriacao());
        pedido.setDataEntregaPrevista(request.getDataEntregaPrevista());

        Veiculo veiculo = new Veiculo();
        veiculo.setId(request.getId());
        return  pedido;
    }

    public static PedidoResponse toPedidoRespponse(Pedido pedido){
        PedidoResponse response = new PedidoResponse();
        response.setId(pedido.getId());
        response.setEndercoOrigem(pedido.getEndercoOrigem());
        response.setEnderecoDestino(pedido.getEnderecoDestino());
        response.setDataCriacao(pedido.getDataCriacao());
        response.setDataEntregaPrevista(pedido.getDataEntregaPrevista());
        response.setVeiculoId(pedido.getVeiculo().getId());
        return response;
    }
}
