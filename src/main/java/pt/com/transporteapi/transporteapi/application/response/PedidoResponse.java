package pt.com.transporteapi.transporteapi.application.response;

import pt.com.transporteapi.transporteapi.domain.Entity.StatusPedido;

import java.time.LocalDateTime;

public class PedidoResponse {

    public long id;
    public String endercoOrigem;
    public String enderecoDestino;
    public StatusPedido status;
    public LocalDateTime dataCriacao;
    public LocalDateTime dataEntregaPrevista;
    public long veiculoId;
    public long motoristaId;

    public PedidoResponse(){}

    public PedidoResponse(long id, String endercoOrigem, String enderecoDestino, StatusPedido status,
                         LocalDateTime dataCriacao, LocalDateTime dataEntregaPrevista, long veiculoId, long motoristaId) {
        this.id = id;
        this.endercoOrigem = endercoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.dataEntregaPrevista = dataEntregaPrevista;
        this.veiculoId = veiculoId;
        this.motoristaId = motoristaId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEndercoOrigem() {
        return endercoOrigem;
    }

    public void setEndercoOrigem(String endercoOrigem) {
        this.endercoOrigem = endercoOrigem;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(String enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataEntregaPrevista() {
        return dataEntregaPrevista;
    }

    public void setDataEntregaPrevista(LocalDateTime dataEntregaPrevista) {
        this.dataEntregaPrevista = dataEntregaPrevista;
    }

    public long getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(long veiculoId) {
        this.veiculoId = veiculoId;
    }

    public long getMotoristaId() {
        return motoristaId;
    }

    public void setMotoristaId(long motoristaId) {
        this.motoristaId = motoristaId;
    }
}
