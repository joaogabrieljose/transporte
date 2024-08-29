package pt.com.transporteapi.transporteapi.domain.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String endercoOrigem;
    private String enderecoDestino;
    private double peso;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEntregaPrevista;
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;

    public Pedido(){}

    public Pedido(long id, String endercoOrigem, String enderecoDestino, double peso, LocalDateTime dataCriacao,
                  LocalDateTime dataEntregaPrevista, Veiculo veiculo, Motorista motorista) {
        this.id = id;
        this.endercoOrigem = endercoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.peso = peso;
        this.dataCriacao = dataCriacao;
        this.dataEntregaPrevista = dataEntregaPrevista;
        this.veiculo = veiculo;
        this.motorista = motorista;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
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

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
}
