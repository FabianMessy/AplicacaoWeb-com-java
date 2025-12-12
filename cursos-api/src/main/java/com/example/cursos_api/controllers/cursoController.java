package com.example.cursos_api.controllers;

import com.example.cursos_api.models.cursoModel;
import com.example.cursos_api.services.cursoService;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;






@RestController
@RequestMapping("/cursos")
public class cursoController{

    private final cursoService service;

    public cursoController(cursoService service){
        this.service=service;
    }
    @GetMapping
        public List<cursoModel> listar() {
        return service.listarall();
    }

    @GetMapping("/{id}")//é Optional
    public ResponseEntity<cursoModel> buscar(@PathVariable Long id){
        return service.searchporID(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/criar")
    public cursoModel criar(@RequestBody cursoModel curso) {        
        return service.salvar(curso);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<cursoModel> atualizar(@PathVariable Long id, @RequestBody cursoModel dados) {
        Optional<cursoModel> cursoAtualizado = service.atualizar(id, dados);
        if (cursoAtualizado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cursoAtualizado.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return service.deletar(id) //"?" é uma forma compactada de if else se conseguir deletar com o service vai dar a primeira resposta .nocontent caso nao consiga vai dar a segunda .notfound
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}