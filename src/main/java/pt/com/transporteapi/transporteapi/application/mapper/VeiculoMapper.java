package pt.com.transporteapi.transporteapi.application.mapper;

import pt.com.transporteapi.transporteapi.application.request.VeiculoRequest;
import pt.com.transporteapi.transporteapi.application.response.VeiculoResponse;
import pt.com.transporteapi.transporteapi.domain.Entity.Motorista;
import pt.com.transporteapi.transporteapi.domain.Entity.Veiculo;

public class VeiculoMapper {

    public static Veiculo toVeiculo(VeiculoRequest request) {
        Motorista motorista = new Motorista();
        motorista.setId(request.getMotoristaId());

        Veiculo veiculo = new Veiculo();
        veiculo.setId(request.getId());
        veiculo.setModelo(request.getModelo());
        veiculo.setPlaca(request.getPlaca());
        veiculo.setModelo(request.getModelo());
        veiculo.setCapacidade(request.getCapacidade());
        return veiculo;
    }

    public static VeiculoResponse toVeiculoResponse(Veiculo veiculo) {
        VeiculoResponse response = new VeiculoResponse();

        response.setMotoristaId(veiculo.getMotorista().getId());
        response.setId(veiculo.getId());
        response.setModelo(veiculo.getModelo());
        response.setPlaca(veiculo.getPlaca());
        response.setModelo(veiculo.getModelo());
        response.setCapacidade(veiculo.getCapacidade());
        return response;
    }
}
