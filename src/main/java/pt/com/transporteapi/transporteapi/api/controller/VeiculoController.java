package pt.com.transporteapi.transporteapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.transporteapi.transporteapi.application.request.VeiculoRequest;
import pt.com.transporteapi.transporteapi.application.response.VeiculoResponse;
import pt.com.transporteapi.transporteapi.domain.service.VeiculoService;

import java.util.List;

@RestController
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @PostMapping("/veiculo/")
    public ResponseEntity<VeiculoResponse> create(@RequestBody VeiculoRequest request){
        var toNovo = service.createVeiculo(request);
        return new  ResponseEntity(toNovo, HttpStatus.CREATED);
    }

    @GetMapping("/veiculo/")
    public ResponseEntity<List<VeiculoResponse>> listaVeiculos(@RequestBody VeiculoRequest request) {
        List<VeiculoResponse> listar = service.findaVeiculoAll();
        return ResponseEntity.ok(listar);
    }


    @GetMapping("/veiculo/{id}")
    public ResponseEntity<VeiculoResponse> veiculoById(@PathVariable long id){
        VeiculoResponse get = service.getVeiculoById(id);
        return ResponseEntity.ok(get);
    }

    @PutMapping("/veiculo/{id}")
    public ResponseEntity<VeiculoResponse> updateVeiculo(@PathVariable long id, @RequestBody VeiculoRequest request) {
        VeiculoResponse novo = service.updateVeiculo(id,request);
        return ResponseEntity.ok(novo);
    }

    @DeleteMapping("/veiculo/{id}")
    public boolean deleteById(@PathVariable long id){
        service.deleteById(id);
        return true;
    }


}
