/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.entity.Estudante;
import com.example.demo.service.EstudanteService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author romar
 */

@RestController
@RequestMapping("/estudantes")
@AllArgsConstructor
public class EstudanteController {
    
    private EstudanteService estudanteService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable Long id) {
        return estudanteService.buscarEstudantePorId(id);
    }
    
    @GetMapping
    public Page<Estudante> buscarTodosEstudantes(
            @RequestParam(defaultValue = "0") Integer pagina,
            @RequestParam(defaultValue = "5") Integer ItensPorPagina) {
        return estudanteService.buscarTodosEstudantes(PageRequest.of(pagina, ItensPorPagina));
    }
    
    @PostMapping
    public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody Estudante estudante) {
        return estudanteService.cadastrarEstudante(estudante);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Estudante> atualizarEstudante(@PathVariable Long id, @RequestBody Estudante estudante) {
        return estudanteService.atualizarEstudante(id, estudante);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarEstudante(@PathVariable Long id) {
       return estudanteService.deletarEstudante(id);
    }
}
