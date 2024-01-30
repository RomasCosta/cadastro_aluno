/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author romar
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArquivoNaoEncontradoException extends RuntimeException{
    
    public ArquivoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
    
    public ArquivoNaoEncontradoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
