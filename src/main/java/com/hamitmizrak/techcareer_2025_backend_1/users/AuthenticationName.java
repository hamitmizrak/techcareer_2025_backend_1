package com.hamitmizrak.techcareer_2025_backend_1.users;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

// LOMBOK
@Log4j2

public class AuthenticationName {

    // Eğer Sisteme Girmiş Kullanıcı varsa
    public static String isAuthenticationName(){

        // Authentication
        // import org.springframework.security.core.Authentication;
        // Login Olmuş Kullanıcı Bilgisini Almak
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        // Sisteme Login Olmuş Kullanıcı Varmı ?
        if(authentication!=null && authentication.isAuthenticated()){
            log.warn( "Sistemdeki Kullanıcı Bilgileri: "+ authentication.getPrincipal());
            log.warn( "Sistemdeki Kullanıcı Adı: "+ authentication.getName());
            return authentication.getName();
        }
        return "Hamit Mızrak";
    }
}
