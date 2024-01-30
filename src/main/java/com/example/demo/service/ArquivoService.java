/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.config.ArquivoStorageProperties;
import org.springframework.stereotype.Service;

/**
 *
 * @author romar
 */
@Service
public class ArquivoService {
    
    public ArquivoService(ArquivoStorageProperties arquivoStorageProperties){
        arquivoStorageProperties.getUploadDir();
    }
}
