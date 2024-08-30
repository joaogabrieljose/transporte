package pt.com.transporteapi.transporteapi.application.mapper;

import pt.com.transporteapi.transporteapi.application.request.MotoristaRequest;
import pt.com.transporteapi.transporteapi.application.response.MotoristaResponse;
import pt.com.transporteapi.transporteapi.domain.Entity.Motorista;
import pt.com.transporteapi.transporteapi.domain.Entity.Veiculo;

public class MotoristaMapper {

    public static Motorista toMotorista(MotoristaRequest request){
        Veiculo veiculo = new Veiculo();
        veiculo.setId(request.getId());

        Motorista motorista = new Motorista();
        motorista.setId(request.getId());
        motorista.setName(request.getName());
        motorista.setLicenca(request.getLicenca());
        return  motorista;
    }

    public static MotoristaResponse toMotoristaResponse(Motorista motorista){
        MotoristaResponse response = new MotoristaResponse();
        response.setId(motorista.getId());
        response.setName(motorista.getName());
        response.setVeiculoId(motorista.getVeiculo().getId());
        response.setLicenca(motorista.getLicenca());
        return  response;
    }
}
