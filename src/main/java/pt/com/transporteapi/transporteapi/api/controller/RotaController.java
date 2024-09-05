package pt.com.transporteapi.transporteapi.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pt.com.transporteapi.transporteapi.domain.Entity.Motorista;
import pt.com.transporteapi.transporteapi.domain.Entity.Pedido;
import pt.com.transporteapi.transporteapi.domain.Entity.Rota;
import pt.com.transporteapi.transporteapi.domain.Entity.Veiculo;
import pt.com.transporteapi.transporteapi.domain.service.RotaService;

import java.time.LocalDate;

@RestController
public class RotaController {

    private RotaService service;


    @PostMapping("/rota/")
    public Rota create(@RequestBody Pedido pedido, @RequestBody Veiculo veiculo, @RequestBody Motorista motorista,
                       @RequestBody double distanciaTota, @RequestBody LocalDate datarota) {

        return service.create(pedido, motorista, veiculo, distanciaTota, datarota);
    }


}
