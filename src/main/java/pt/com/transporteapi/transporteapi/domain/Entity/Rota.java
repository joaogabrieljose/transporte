package pt.com.transporteapi.transporteapi.domain.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;

    @OneToMany(mappedBy = "rota", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;
    private double distanciaTotal;
    private LocalDate datRota;

    public Rota(){}

    public Rota(long id, Veiculo veiculo, Motorista motorista, List<Pedido> pedidos,
                double distanciaTotal, LocalDate datRota) {
        this.id = id;
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.pedidos = pedidos;
        this.distanciaTotal = distanciaTotal;
        this.datRota = datRota;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public double getDistanciaTotal() {
        return distanciaTotal;
    }

    public void setDistanciaTotal(double distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }

    public LocalDate getDatRota() {
        return datRota;
    }

    public void setDatRota(LocalDate datRota) {
        this.datRota = datRota;
    }
}
