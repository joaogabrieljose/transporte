package pt.com.transporteapi.transporteapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.transporteapi.transporteapi.application.mapper.VeiculoMapper;
import pt.com.transporteapi.transporteapi.application.request.VeiculoRequest;
import pt.com.transporteapi.transporteapi.application.response.VeiculoResponse;
import pt.com.transporteapi.transporteapi.domain.Entity.Veiculo;
import pt.com.transporteapi.transporteapi.domain.service.VeiculoService;

import java.util.List;
import java.util.Optional;

@RestController
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @PostMapping("/veiculo/")
    public ResponseEntity<VeiculoResponse> create(@RequestBody VeiculoRequest request){
        var novo = VeiculoMapper.toVeiculo(request);
        var toNovo = service.createVeiculo(novo);
        VeiculoResponse create = VeiculoMapper.toVeiculoResponse(toNovo);
        return new  ResponseEntity(create, HttpStatus.CREATED);
    }

    @GetMapping("/veiculo/")
    public ResponseEntity<List<VeiculoResponse>> listaVeiculos(@RequestBody VeiculoRequest request){
     List<Veiculo> novo = service.findVeiculoAll();
     List<VeiculoResponse> create = novo.stream().map(VeiculoMapper::toVeiculoResponse).toList();
     return ResponseEntity.ok(create);
    }

    @GetMapping("/veiculo/{id}")
    public ResponseEntity<VeiculoResponse> veiculoById(@PathVariable long id, VeiculoRequest request){
        var novo = VeiculoMapper.toVeiculo(request);
        var novoVeiculo = service.getVeiculoById(id);
        VeiculoResponse get = VeiculoMapper.toVeiculoResponse(novoVeiculo);
        return ResponseEntity.ok(get);
    }

    @PutMapping("/veiculo/{id}")
    public ResponseEntity<VeiculoResponse> updateVeiculo(@PathVariable long id, @RequestBody VeiculoRequest request) {
        var novoVeiculo = VeiculoMapper.toVeiculo(request);
        var veiculoAtualizado = service.updateVeiculo(id, novoVeiculo);
        VeiculoResponse resposta = VeiculoMapper.toVeiculoResponse(veiculoAtualizado);
        return ResponseEntity.ok(resposta);
    }

    @PutMapping("/{veiculoId}/atribuir-motorista/{motoristaId}")
    public ResponseEntity<VeiculoResponse> atribuir(@PathVariable long veiculoId, long motoristaId,@RequestBody VeiculoRequest request){
        boolean sucesso = service.atribuirMotoristaAoVeiculo(motoristaId, veiculoId);
        if (sucesso) {
            Optional<Veiculo> veiculoAtualizado = Optional.ofNullable(service.getVeiculoById(veiculoId));
            if (veiculoAtualizado.isPresent()) {
                VeiculoResponse response = VeiculoMapper.toVeiculoResponse(veiculoAtualizado.get());
                return ResponseEntity.ok(response);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @DeleteMapping("/veiculo/{id}")
    public boolean deleteById(@PathVariable long id){
        service.deleteById(id);
        return true;
    }


}
