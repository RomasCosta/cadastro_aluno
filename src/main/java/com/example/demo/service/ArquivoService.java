/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.config.ArquivoStorageProperties;
import com.example.demo.exception.ArquivoNaoEncontradoException;
import com.example.demo.exception.UploadArquivoException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;


import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author romar
 */
@Service
@Slf4j//cria variavel para logar erros - var log
public class ArquivoService {
    
    private final Path fileStorageLocation;
    
    //cria a pasta upload do path descrita no properties caso não exista
    public ArquivoService(ArquivoStorageProperties arquivoStorageProperties){
        this.fileStorageLocation = Paths.get(arquivoStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception e) {
            throw new UploadArquivoException("Algo deu errado ao criar a pasta", e);
        }
    }
    
    //upload do arquivo
    public String SalvarArquivo(MultipartFile file) {
        String nomeArquivo = StringUtils.cleanPath(file.getOriginalFilename());
        
        try {
            if(nomeArquivo.contains("..")) {
                throw new UploadArquivoException("Arquivo invalido");
            }
            Path targetLocation = this.fileStorageLocation.resolve(nomeArquivo);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            
            return nomeArquivo;
        } catch (IOException e) {
            throw new UploadArquivoException("Erro ao tentar salvar o arquivo", e);
        }
    }
    
    //download de arquivo
    public Resource carregarArquivo(String nomeArquivo) {
        try {
            Path filePath = this.fileStorageLocation.resolve(nomeArquivo).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new ArquivoNaoEncontradoException("Arquivo não encontrado");
            }
        } catch (Exception e) {
            throw new ArquivoNaoEncontradoException("Arquivo não encontrado");
        }
    }
    
    //método para pegar a extensão do arquivo
    public String getContentType(HttpServletRequest request, Resource resource) {
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (Exception e) {
            log.error("Não foi possível determinar o tipo de arquivo");
        }
        
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return contentType;
    }
}
