package com.hamitmizrak.techcareer_2025_backend_1.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// LOMBOK
@Log4j2

@Configuration
public class PasswordEncoderBean {

    // Constructor
    public PasswordEncoderBean() {
        System.out.println("PasswordEncoderBean: Constructor Bean Başlatıldı");
        log.info("PasswordEncoderBean: Constructor Bean Başlatıldı");
    }

    // init metodu bean(Injection) oluşturulduktan hemen sonra çalışır.
    // Bunu Loglama, sistem hazırlığı gibi başlatma işlemlerinde kullanırız.
    @PostConstruct
    public void init() {
        System.out.println("PasswordEncoderBean: @PostConstruct Bean Başlatıldı");
        log.info("PasswordEncoderBean: @PostConstruct Bean Başlatıldı");
    }

    // destroy metodu bean yok edilmeden hemen önce çalışır.
    // Bunu sistem içindeki temizlik, nesneyi serbest bırakmak için kullanıyoruz.
    @PreDestroy
    public void destroy() {
        System.out.println("PasswordEncoderBean: @PreDestroy Bean Öldü");
        log.info("PasswordEncoderBean: @PreDestroy Bean Öldü");
    }

    // Bean Oluşturma (Singleton Scope)
    @Bean
    @Scope("singleton")
    // singleton: Varsayılan Scope türüdür. Tüm uygulama boyunca tek bir örnek üzerinden devam edilir.
    public PasswordEncoder getPasswordEncoderSingleton() {
        System.out.println("PasswordEncoderBean: Singleton Bean oluşturuldu");
        log.info("PasswordEncoderBean: Singleton Bean oluşturuldu");
        return new BCryptPasswordEncoder();
    }

    // Prototype Scope
    @Bean
    @Scope("prototype")
    // prototype: Her talepte yeni bir örnek oluştur.
    public PasswordEncoder getPasswordEncoderPrototype() {
        System.out.println("PasswordEncoderBean: Prototype Bean oluşturuldu");
        log.info("PasswordEncoderBean: Prototype Bean oluşturuldu");
        return new BCryptPasswordEncoder();
    }

    // Request Scope
    @Bean
    @Scope("request")
    // request: Her bir Http isteği için yeni bir örnek oluştur.
    public PasswordEncoder getPasswordEncoderRequest() {
        System.out.println("PasswordEncoderBean: Request Bean oluşturuldu");
        log.info("PasswordEncoderBean: Request Bean oluşturuldu");
        return new BCryptPasswordEncoder();
    }

    // Session Scope
    @Bean
    @Scope("session")
    // session: Her bir Http oturumu için yeni bir örnek oluştur.
    public PasswordEncoder getPasswordEncoderSession() {
        System.out.println("PasswordEncoderBean: Session Bean oluşturuldu");
        log.info("PasswordEncoderBean: Session Bean oluşturuldu");
        return new BCryptPasswordEncoder();
    }

} // end class PasswordEncoderBean
