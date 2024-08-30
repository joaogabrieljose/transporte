package pt.com.transporteapi.transporteapi.application.response;

public class MotoristaResponse {

    public long id;
    public String name;
    public String licenca;
    public boolean disponivel;
    public long veiculoId;

    public MotoristaResponse(){}

    public MotoristaResponse(long id, String name, String licenca, boolean disponivel, long veiculoId) {
        this.id = id;
        this.name = name;
        this.licenca = licenca;
        this.disponivel = disponivel;
        this.veiculoId = veiculoId;
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

    public long getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(long veiculoId) {
        this.veiculoId = veiculoId;
    }
}
