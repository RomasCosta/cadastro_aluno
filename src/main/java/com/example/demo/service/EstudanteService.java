/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Estudante;
import com.example.demo.repository.EstudanteRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/**
 *
 * @author romar
 */
@Service
@AllArgsConstructor
public class EstudanteService {
    
    //private static Map<Long, Estudante> listaEstudantes = new HashMap<>();
    private EstudanteRepository estudanteRepository;
    
    public ResponseEntity<Estudante> buscarEstudantePorId(Long id) {
        if (estudanteRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(estudanteRepository.findById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    
    public List<Estudante> buscarTodosEstudantes() {
        return estudanteRepository.findAll();
    }
    
    public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante) {
        Estudante estudanteSalvo = estudanteRepository.save(estudante);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudanteSalvo);
    }
    
    public ResponseEntity<Estudante> atualizarEstudante(Long id, Estudante estudante) {
        if (estudanteRepository.existsById(id)) {
            Estudante estudanteSalvo = estudanteRepository.save(estudante);
            return ResponseEntity.status(HttpStatus.OK).body(estudanteSalvo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    
    public ResponseEntity<String> deletarEstudante(Long id) {
        if (estudanteRepository.existsById(id)) {
            estudanteRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Estudante deletado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado.");
    }
}
