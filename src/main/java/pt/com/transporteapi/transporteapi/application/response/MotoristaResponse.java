package pt.com.transporteapi.transporteapi.application.response;

import pt.com.transporteapi.transporteapi.domain.Entity.Veiculo;

import java.util.List;

public class MotoristaResponse {

    public long id;
    public String name;
    public String licenca;
    public boolean disponivel;
    public List<Veiculo> veiculo;

    public MotoristaResponse(){}

    public MotoristaResponse(long id, String name, String licenca, boolean disponivel, List<Veiculo> veiculo) {
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

    public List<Veiculo> getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }
}
