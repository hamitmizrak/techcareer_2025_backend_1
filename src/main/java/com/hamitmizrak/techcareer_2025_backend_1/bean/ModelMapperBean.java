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

    // init metodu bean(Injection) oluşturulduktan hemen sonra çalışır.
    // Bunu Loglama, sistem hazırlığı gibi başlatma işlemlerinde kullanırız.
    @PostConstruct
    public void init(){
        System.out.println("ModelMapperBean: @PostConstruct Bean Başlatıldı");
        log.info("ModelMapperBean: @PostConstruct Bean Başlatıldı");
    }

    // destroy metodu bean(dead) yok edilmeden hemen önce çalışır.
    // Bunu sistem içindeki temizlik, nesneyi serbest bırakmak için kullanıyoruz.
    @PreDestroy
    public void destroy(){
        System.out.println("ModelMapperBean: @PreDestroy Bean Öldü");
        log.info("ModelMapperBean: @PreDestroy Bean Öldü");
    }

    // Bean Oluşturma(instance)
    @Bean
    @Scope("singleton")
    public ModelMapper getModelMapperMethod(){
        return new ModelMapper();
    }
}
