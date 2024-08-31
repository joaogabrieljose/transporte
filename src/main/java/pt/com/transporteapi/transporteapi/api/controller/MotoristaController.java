package pt.com.transporteapi.transporteapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.transporteapi.transporteapi.application.mapper.MotoristaMapper;
import pt.com.transporteapi.transporteapi.application.request.MotoristaRequest;
import pt.com.transporteapi.transporteapi.application.response.MotoristaResponse;
import pt.com.transporteapi.transporteapi.domain.Entity.Motorista;
import pt.com.transporteapi.transporteapi.domain.service.MotoristaService;

import java.util.List;

@RestController
public class MotoristaController {

    @Autowired
    private MotoristaService service;

    @PostMapping("/motorista/")
    public ResponseEntity<MotoristaResponse> create(@RequestBody MotoristaRequest request) {
        var novo = MotoristaMapper.toMotorista(request);
        var create = service.create(novo);
        return new ResponseEntity(novo, HttpStatus.CREATED);
    }

    @GetMapping("/motorista/")
    public ResponseEntity<List<MotoristaResponse>> findAll(@RequestBody MotoristaRequest request) {
        List<Motorista> novo = service.findMotoristaAll();
        List<MotoristaResponse> create = novo.stream().map(MotoristaMapper::toMotoristaResponse).toList();
        return ResponseEntity.ok(create);
    }

    @GetMapping("/motorista/{id}")
    public ResponseEntity<MotoristaResponse> getMotoristaById(@PathVariable long id, MotoristaRequest request){
        var novo = MotoristaMapper.toMotorista(request);
        var listaById = service.getMotoristaById(id);
        MotoristaResponse create = MotoristaMapper.toMotoristaResponse(listaById);
        return  ResponseEntity.ok(create);
    }

    @PutMapping("/motorista/{id}")
    public ResponseEntity<MotoristaResponse> updateMotorista(@PathVariable long id, @RequestBody MotoristaRequest request){
        var novo = MotoristaMapper.toMotorista(request);
        var novoUpdate = service.updateMotorista(id,novo);
        MotoristaResponse atual = MotoristaMapper.toMotoristaResponse(novoUpdate);
        return ResponseEntity.ok(atual);
    }
}
