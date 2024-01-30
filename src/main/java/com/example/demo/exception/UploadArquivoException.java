/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.exception;

/**
 *
 * @author romar
 */
public class UploadArquivoException extends RuntimeException{
    
    public UploadArquivoException(String mensagem) {
        super(mensagem);
    }
    
    public UploadArquivoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
