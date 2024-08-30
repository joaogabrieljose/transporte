package pt.com.transporteapi.transporteapi.domain.Entity;

import jakarta.persistence.*;

@Entity
public class Motorista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String licenca;
    private boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Veiculo veiculo;

    public Motorista(){}
    public Motorista(long id, String name, String licenca, boolean disponivel, Veiculo veiculo) {
        this.id = id;
        this.name = name;
        this.licenca = licenca;
        this.disponivel = disponivel;
        this.veiculo = veiculo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenca() {
        return licenca;
    }

    public void setLicenca(String licenca) {
        this.licenca = licenca;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
