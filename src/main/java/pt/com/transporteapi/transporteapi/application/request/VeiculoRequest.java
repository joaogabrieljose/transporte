package pt.com.transporteapi.transporteapi.application.request;

public class VeiculoRequest {

    private long id;
    private String modelo;
    private String placa;
    private double capacidade;
    private boolean disponivel;

    private long motoristaId;

    public VeiculoRequest(){}

    public VeiculoRequest(long id, String modelo, String placa, double capacidade,
                          boolean disponivel, long motoristaId) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.capacidade = capacidade;
        this.disponivel = disponivel;
        this.motoristaId = motoristaId;
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

    public long getMotoristaId() {
        return motoristaId;
    }

    public void setMotoristaId(long motoristaId) {
        this.motoristaId = motoristaId;
    }
}
