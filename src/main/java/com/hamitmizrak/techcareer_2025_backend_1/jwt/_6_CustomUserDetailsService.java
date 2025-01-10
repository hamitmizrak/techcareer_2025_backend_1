package com.hamitmizrak.techcareer_2025_backend_1.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor

// Service
@Service
public class _6_CustomUserDetailsService implements UserDetailsService {

    // Injection
    private final _5_IUserRepository iUserRepository;

    // Kullanıcı var mı Yok mu ?  Eğer yoksa: `User not found`
    // Kulalnıcı varsa UserDetail'in içine buludğum veriyi set et
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Entity'de kullanıcıcı Bulmak
        _4_UserEntity userEntity =iUserRepository
                .findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found: " +username));

        // User kütüphanesinden şimdiki buluduğumuz _4_UserEntity verileri set et
        // import org.springframework.security.core.userdetails.User;
        // Kullanıcının rolünü GrantedAuthority'ye dönüştürmek
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(userEntity.getRole().toString()));

        // 1.YOL
        UserDetails userDetails= new User(userEntity.getUsername(),"{noop}" + userEntity.getPassword(),authorities);

        // 2.YOL
        /*
        UserDetails userDetails=User.builder()
                .username(userEntity.getUsername())
                .password("{noop}" + userEntity.getPassword()) // Şifreye {noop} öneki eklendi
                .password(userEntity.getPassword())
                .password("{noop}"+userEntity.getPassword())
                .password("{noop}root")
                .roles(userEntity.getRole().toString())
                .build();
                */

        return userDetails;
    } //end loadUserByUsername
}
