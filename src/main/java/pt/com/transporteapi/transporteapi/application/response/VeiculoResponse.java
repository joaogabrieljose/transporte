package pt.com.transporteapi.transporteapi.application.response;

public class VeiculoResponse {
    public String modelo;
    public String placa;
    public double capacidade;
    public boolean disponivel;

    public long motoristaId;

    public VeiculoResponse(){}

    public VeiculoResponse(String modelo, String placa, double capacidade,
                          boolean disponivel, long motoristaId) {
        this.modelo = modelo;
        this.placa = placa;
        this.capacidade = capacidade;
        this.disponivel = disponivel;
        this.motoristaId = motoristaId;
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

    public long getMotoristaId() {
        return motoristaId;
    }

    public void setMotoristaId(long motoristaId) {
        this.motoristaId = motoristaId;
    }
}
