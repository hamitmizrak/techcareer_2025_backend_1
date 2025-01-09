package com.hamitmizrak.techcareer_2025_backend_1.jwt;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

// JWT (JSON Web Token) oluşturma, doğrulama ve ayrıştırma işlemleri için gerekli kütüphaneler.
// Bu sınıfı bir Spring bileşeni olarak işaretler.
// Spring IOC konteyneri tarafından yönetilir ve diğer sınıflar tarafından enjekte edilebilir.
@Component
public class _7_JwtUtils {

    // JWT 3 kısımdan oluşur
    // 1-) Header(Başlık)  : alg, type
    // 2-) Payload(Yük)    : admin, name,
    // 3-) Signature(İmza) : header+payload

    //1-) Header(Başlık)
    // JWT işlemleri için kullanılacak gizli bir anahtar. HS512 algoritması ile oluşturuluyor.
    private final SecretKey jwtSecret = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    // JWT'nin geçerlilik süresi. Burada 1 gün (86400000 milisaniye) olarak ayarlanmış.
    // 1000(ms)*60(sn)*60(dk)*24(gün)
    private final long jwtExpirationMs = 86400000;

    // Kullanıcı adı (username) bilgisine dayalı olarak JWT oluşturur.
    public String generateJwtToken(String username) {
        return Jwts.builder()
                .setSubject(username) // JWT'nin konusu, genellikle kullanıcı adı burada ayarlanır.
                .setIssuedAt(new Date()) // Token oluşturulma tarihi.
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)) // Tokenin geçerlilik süresi.
                .signWith(jwtSecret) // Tokeni oluşturmak için gizli anahtarla imzalama.
                .compact(); // JWT'yi oluşturur ve String olarak döner.
    }

    // JWT'den kullanıcı adını ayrıştırır.
    public String getUsernameFromJwtToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtSecret) // Doğrulama için gizli anahtarı kullanır.
                .build()
                .parseClaimsJws(token) // Tokeni ayrıştırır ve doğrular.
                .getBody() // Tokenin gövdesini (claims) alır.
                .getSubject(); // Gövdedeki kullanıcı adı bilgisini döner.
    }

    // JWT'nin geçerli olup olmadığını kontrol eder.
    public boolean validateJwtToken(String authToken) {
        try {
            // Tokeni ayrıştırır ve imzasını doğrular.
            Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(authToken);
            return true; // Token geçerliyse true döner.
        } catch (JwtException e) {
            // Token geçersizse bir hata yakalanır ve mesaj konsola yazdırılır.
            System.err.println("JWT Hatası: " + e.getMessage());
        }
        return false; // Token geçersizse false döner.
    }
}