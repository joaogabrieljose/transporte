package pt.com.transporteapi.transporteapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.com.transporteapi.transporteapi.application.mapper.PedidoMapper;
import pt.com.transporteapi.transporteapi.application.request.PedidoRequest;
import pt.com.transporteapi.transporteapi.application.response.PedidoResponse;
import pt.com.transporteapi.transporteapi.domain.service.PedidoService;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping("/pedido/")
    public ResponseEntity<PedidoResponse> create(@RequestBody PedidoRequest request) {
        PedidoResponse novoCreate = service.create(request);
        return ResponseEntity.ok(novoCreate);
    }

    @GetMapping("/pedido/")
    public ResponseEntity<List<PedidoResponse>> findAll(PedidoRequest request) {
        List<PedidoResponse> findAllPedido = service.findPedidoAll();
        return ResponseEntity.ok(findAllPedido);
    }

    @GetMapping("/pedido/{id}")
    public ResponseEntity<PedidoResponse> getPedidoById(@PathVariable long id, PedidoRequest request) {
        PedidoResponse getPedidoById = service.getPedidoById(id);
        return ResponseEntity.ok(getPedidoById);
    }

    @PutMapping("/pedido/status/{id}")
    public ResponseEntity<PedidoResponse> updateStatus(@PathVariable long id, @RequestBody PedidoRequest request) {
        var novo = PedidoMapper.toPedido(request);
        var update = service.updateStatusPedido(id, novo.getStatus());
        PedidoResponse novoPedido = PedidoMapper.toPedidoRespponse(update);
        return ResponseEntity.ok(novoPedido);
    }

    @PutMapping("/pedido/{id}")
    public ResponseEntity<PedidoResponse> updateById(@PathVariable long id, @RequestBody PedidoRequest request) {
        PedidoResponse novoUpdate = service.update(id, request);
        return ResponseEntity.ok(novoUpdate);
    }

    @DeleteMapping("/pedido/{id}")
    public boolean deleteById(@PathVariable long id) {
        service.deleteById(id);
        return true;
    }


}
