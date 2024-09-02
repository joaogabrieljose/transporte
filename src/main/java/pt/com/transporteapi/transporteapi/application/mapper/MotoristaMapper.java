package pt.com.transporteapi.transporteapi.application.mapper;

import pt.com.transporteapi.transporteapi.application.request.MotoristaRequest;
import pt.com.transporteapi.transporteapi.application.response.MotoristaResponse;
import pt.com.transporteapi.transporteapi.domain.Entity.Motorista;
import pt.com.transporteapi.transporteapi.domain.Entity.Veiculo;

public class MotoristaMapper {

    public static Motorista toMotorista(MotoristaRequest request) {
        Motorista motorista = new Motorista();

        if (request.getVeiculoId() != 0 ) {
            Veiculo veiculo = new Veiculo();
            veiculo.setId(request.getVeiculoId());
            motorista.setVeiculo(veiculo);
        }

        motorista.setName(request.getName());
        motorista.setLicenca(request.getLicenca());
        motorista.setDisponivel(request.isDisponivel());
        return motorista;
    }

    public static MotoristaResponse toMotoristaResponse(Motorista motorista) {
        MotoristaResponse response = new MotoristaResponse();

        if (motorista.getVeiculo() != null) {
            response.setVeiculoId(motorista.getVeiculo().getId());
        }

        response.setId(motorista.getId());
        response.setName(motorista.getName());
        response.setLicenca(motorista.getLicenca());
        response.setDisponivel(motorista.isDisponivel());

        return response;
    }
}
