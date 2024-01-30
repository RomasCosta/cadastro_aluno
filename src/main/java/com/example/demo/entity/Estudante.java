/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author romar
 */

//lombok permite usar anotações para construtor, getters, setters...
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estudante {
    
    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
}
