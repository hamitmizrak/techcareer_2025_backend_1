package com.hamitmizrak.techcareer_2025_backend_1.bean;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// LOMBOK
@Log4j2

@Configuration
public class ModelMapperBean {

    // Bean Oluşturma(instance)
    @Bean
    // singleton: Varsayılan Scope türüdür. Tüm uygulama boyunca tek bir örnek üzerinden devam edilir.
    public ModelMapper getModelMapperSingleton(){
        return new ModelMapper();
    }

} //end ModelMapperBean
