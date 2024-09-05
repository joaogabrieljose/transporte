package pt.com.transporteapi.transporteapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.transporteapi.transporteapi.domain.Entity.Motorista;
import pt.com.transporteapi.transporteapi.domain.Entity.Pedido;
import pt.com.transporteapi.transporteapi.domain.Entity.Rota;
import pt.com.transporteapi.transporteapi.domain.Entity.Veiculo;
import pt.com.transporteapi.transporteapi.domain.repository.RotaRepository;

import java.time.LocalDate;
import java.util.Collections;

@Service
public class RotaService {
    @Autowired
    private RotaRepository repository;


    public Rota create (Pedido pedido, Motorista motorista, Veiculo veiculo, double distanciaTotal, LocalDate datarota  ){

        Rota rota = new Rota();
        rota.setPedidos(Collections.singletonList(pedido));
        rota.setVeiculo(veiculo);
        rota.setMotorista(motorista);
        rota.setDistanciaTotal(distanciaTotal);
        rota.setDatRota(datarota);
        return repository.save(rota);
        }

}
