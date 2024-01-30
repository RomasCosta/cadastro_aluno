/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author romar
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arquivo {
    
    private String nomeArquivo;
    private String linkDownload;
    private String extensaoArquivo;
    private long size;
}
