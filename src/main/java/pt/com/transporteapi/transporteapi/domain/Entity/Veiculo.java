package pt.com.transporteapi.transporteapi.domain.Entity;

import jakarta.persistence.*;


@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String modelo;
    private String placa;
    private double capacidade;
    private boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;

    public Veiculo (){}

    public Veiculo(long id, String modelo, String placa, double capacidade, boolean disponivel, Motorista motorista) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.capacidade = capacidade;
        this.disponivel = disponivel;
        this.motorista = motorista;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
}
