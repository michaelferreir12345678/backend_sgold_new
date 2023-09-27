package com.br.sgprev.controller;

import com.br.sgprev.entity.MetaAtuarial;
import com.br.sgprev.service.MetaAtuarialService;
//import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servico")
public class MetaAtuarialController {

    @Autowired
    private MetaAtuarialService metaAtuarialService;


    @CrossOrigin
    @GetMapping("/")
    public List<MetaAtuarial> buscarTodos(){
        return metaAtuarialService.buscarTodos();
    }
    @CrossOrigin
    @PostMapping("/")
    public MetaAtuarial inserir(@RequestBody MetaAtuarial metaAtuarial){
        return metaAtuarialService.inserir(metaAtuarial);
    }

    @CrossOrigin
    @PutMapping("/")
    public MetaAtuarial alterar(@RequestBody MetaAtuarial metaAtuarial){
        return metaAtuarialService.alterar(metaAtuarial);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        metaAtuarialService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
