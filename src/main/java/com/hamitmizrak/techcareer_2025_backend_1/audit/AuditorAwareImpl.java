package com.hamitmizrak.techcareer_2025_backend_1.audit;


import com.hamitmizrak.techcareer_2025_backend_1.users.AuthenticationName;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

// LOMBOK
@Log4j2

// StereoType
@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        // Sistemde kullanıcı varsa
        if(AuthenticationName.isAuthenticationName()!=null){
            return Optional.of(AuthenticationName.isAuthenticationName());
        }
        // Eğer sistemde aktif kullanıcı yoksa, default kullanıcı ekle
        return Optional.of(AuthenticationName.isAuthenticationName());
    }
}
