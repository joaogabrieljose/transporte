package pt.com.transporteapi.transporteapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.transporteapi.transporteapi.application.request.MotoristaRequest;
import pt.com.transporteapi.transporteapi.application.response.MotoristaResponse;
import pt.com.transporteapi.transporteapi.domain.service.MotoristaService;

import java.util.List;

@RestController
public class MotoristaController {

    @Autowired
    private MotoristaService service;

    @PostMapping("/motorista/")
    public ResponseEntity<MotoristaResponse> create(@RequestBody MotoristaRequest request) {
        var create = service.create(request);
        return new ResponseEntity(create, HttpStatus.CREATED);
    }

    @GetMapping("/motorista/")
    public ResponseEntity<List<MotoristaResponse>> findAll(@RequestBody MotoristaRequest request) {
        List<MotoristaResponse> novo = service.findMotoristaAll();
        return ResponseEntity.ok( novo);
    }

    @GetMapping("/motorista/{id}")
    public ResponseEntity<MotoristaResponse> getMotoristaById(@PathVariable long id, MotoristaRequest request){
        var listaById = service.getMotoristaById(id);
        return  ResponseEntity.ok(listaById);
    }

    @PutMapping("/motorista/{id}")
    public ResponseEntity<MotoristaResponse> updateMotorista(@PathVariable long id, @RequestBody MotoristaRequest request){
        var novoUpdate = service.updateMotorista(id, request);
        return ResponseEntity.ok(novoUpdate);
    }


    @DeleteMapping("/motorista/{id}")
    public boolean deleteById(@PathVariable long id){
        service.deleteById(id);
        return true;
    }

    /*
    @PutMapping("/{veiculoId}/motorista/{motoristaId}")
    public ResponseEntity<MotoristaResponse> atribuir(@PathVariable long veiculoId, @PathVariable long motoristaId,
                                                      @RequestBody MotoristaRequest request) {
        boolean sucesso = service.atribuirMotoristaAoVeiculo(motoristaId, veiculoId);

        if (sucesso) {
            Optional<Motorista> motoristaAtualizado = service.atribuirMotoristaAoVeiculo();
            if (motoristaAtualizado.isPresent()) {
                MotoristaResponse response = MotoristaMapper.toMotoristaResponse(motoristaAtualizado.get());
                return ResponseEntity.ok(response);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }*/

}
