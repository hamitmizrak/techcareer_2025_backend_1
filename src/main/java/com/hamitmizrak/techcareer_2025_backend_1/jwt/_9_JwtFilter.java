// Bu sınıfın com.hamitmizrak.innova_springboot.security.jwt paketi altında yer aldığını belirtir.
package com.hamitmizrak.techcareer_2025_backend_1.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// Lombok kütüphanesinden @RequiredArgsConstructor, final değişkenler için otomatik olarak constructor oluşturur.

// LOMBOK
// Lombok tarafından sağlanan bu notasyon, final olarak tanımlanmış değişkenler için bir constructor oluşturur.
@RequiredArgsConstructor

@Component
// Bu sınıfı bir Spring bileşeni olarak işaretler.
// IOC konteynerine dahil edilir ve diğer bileşenlerde kullanılabilir.
public class _9_JwtFilter extends OncePerRequestFilter {

    // Injection
    // JWT işlemleri için kullanılan yardımcı sınıf.
    // Token oluşturma ve doğrulama işlevlerini sağlar.
    private final _7_JwtUtils jwtUtils;

    // Kullanıcı bilgilerini yüklemek için kullanılan Spring Security bileşeni.
    private final UserDetailsService userDetailsService;

    // doFilterInternal
    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
        // HTTP istekleri için özel filtre mantığını uygular.

        // HTTP isteğinin "Authorization" başlığını alır.
        String header = request.getHeader("Authorization");

        // token ve username
        String token = null;
        String username = null;

        // Eğer "Authorization" başlığı mevcutsa ve "Bearer " ile başlıyorsa:
        if (header != null && header.startsWith("Bearer ")) {

            // "Bearer " ifadesinden sonraki token kısmını alır.
            token = header.substring(7);

            // Token içerisinden kullanıcı adını ayrıştırır.
            username = jwtUtils.getUsernameFromJwtToken(token);
        }

        // Eğer username varsa ve mevcut oturumda kimlik doğrulama bilgisi yoksa:
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Kullanıcı detaylarını yükler.
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            // Eğer token geçerliyse:
            if (jwtUtils.validateJwtToken(token)) {
                // Kullanıcı kimlik doğrulama bilgilerini Spring Security'ye ayarlar.
                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities()));

            }
        }

        // İsteği bir sonraki filtreye veya hedefe iletir.
        filterChain.doFilter(request, response);
    } //end doFilterInternal
} //end _9_JwtFilter
