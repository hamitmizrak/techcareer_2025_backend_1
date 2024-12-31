package com.hamitmizrak.techcareer_2025_backend_1.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// LOMBOK
@Log4j2

@Configuration
public class ModelMapperBean {

    // Constructor
    public ModelMapperBean() {
        System.out.println("ModelMapperBean: Constructor Bean Başlatıldı");
        log.info("ModelMapperBean: Constructor Bean Başlatıldı");
    }

    // Bean Oluşturma(instance)
    @Bean
    @Scope("singleton")
    // singleton: Varsayılan Scope türüdür. Tüm uygulama boyunca tek bir örnek üzerinden devam edilir.
    public ModelMapper getModelMapperSingleton(){
        return new ModelMapper();
    }

} //end ModelMapperBean
