package pt.com.transporteapi.transporteapi.application.request;

public class MotoristaRequest {

    private String name;
    private String licenca;
    private boolean disponivel;
    private long veiculoId;

    public MotoristaRequest(){}

    public MotoristaRequest(String name, String licenca, boolean disponivel,long veiculoId) {
        this.name = name;
        this.licenca = licenca;
        this.disponivel = disponivel;
        this.veiculoId = veiculoId;
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
