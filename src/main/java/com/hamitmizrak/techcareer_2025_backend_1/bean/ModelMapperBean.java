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
    // singleton: Varsayılan Scope türüdür. Tüm uygulama boyunca tek bir örnek üzerinden devam edilir.
    public ModelMapper getModelMapperSingleton(){
        return new ModelMapper();
    }

    // prototype
    @Bean
    @Scope("prototype")
    // prototype: Her talepte yeni bir örnek oluştur.
    public ModelMapper getModelMapperPrototype(){
        return new ModelMapper();
    }

    // request
    @Bean
    @Scope("request")
    // request: Her bir Http isteği için yeni bir örnek oluştur.
    public ModelMapper getModelMappeRequest(){
        return new ModelMapper();
    }

    // session
    @Bean
    @Scope("session")
    // session: Her bir Http oturumu için yeni bir örnek oluştur.
    public ModelMapper getModelMappeSession(){
        return new ModelMapper();
    }

} //end ModelMapperBean
