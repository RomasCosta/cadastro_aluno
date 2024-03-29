/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Entity
public class Estudante {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
    
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, orphanRemoval = true)//orphanRemoval vai removar livros cadastrados junto com o estudante que  tiver likado a ele
    private Set<Livro> livros;
}
