package pt.com.transporteapi.transporteapi.application.mapper;

import pt.com.transporteapi.transporteapi.application.request.VeiculoRequest;
import pt.com.transporteapi.transporteapi.application.response.VeiculoResponse;
import pt.com.transporteapi.transporteapi.domain.Entity.Motorista;
import pt.com.transporteapi.transporteapi.domain.Entity.Veiculo;

public class VeiculoMapper {

    public static Veiculo toVeiculo(VeiculoRequest request) {
        Veiculo veiculo = new Veiculo();

        if (request.getMotoristaId() != 0) {
            Motorista motorista = new Motorista();
            motorista.setId(request.getMotoristaId());
            veiculo.setMotorista(motorista);
        }


        veiculo.setModelo(request.getModelo());
        veiculo.setPlaca(request.getPlaca());
        veiculo.setCapacidade(request.getCapacidade());
        veiculo.setDisponivel(request.isDisponivel());
        return veiculo;
    }

    public static VeiculoResponse toVeiculoResponse(Veiculo veiculo) {
        VeiculoResponse response = new VeiculoResponse();

        if (veiculo.getMotorista() != null) {
            response.setMotoristaId(veiculo.getMotorista().getId());
        }
        response.setId(veiculo.getId());
        response.setModelo(veiculo.getModelo());
        response.setPlaca(veiculo.getPlaca());
        response.setCapacidade(veiculo.getCapacidade());
        response.setDisponivel(veiculo.isDisponivel());
        return response;
    }
}
