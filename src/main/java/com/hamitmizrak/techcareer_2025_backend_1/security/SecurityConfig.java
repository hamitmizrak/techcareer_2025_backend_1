package com.hamitmizrak.techcareer_2025_backend_1.security;

import com.hamitmizrak.techcareer_2025_backend_1.bean.PasswordEncoderBean;
import com.hamitmizrak.techcareer_2025_backend_1.jwt._7_JwtUtils;
import com.hamitmizrak.techcareer_2025_backend_1.jwt._9_JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

// LOMBOK
@RequiredArgsConstructor

// NOT: Spring Security için Spring boot semantic version: 3.3.4 kullandım
// Dikkat: Spring Security ile çalışırken Sürekli Browserınızın Cache Belleğini siliniz.
@EnableWebSecurity // Security Aktif et
@Configuration     // Bean olmasını ağla
public class SecurityConfig {

    // Injection
    private final PasswordEncoderBean passwordEncoderBean;

    //// JWT INJECTION ///////////////////////////////////////////////////////////////////////////
    // For JWT
    private final _7_JwtUtils jwtUtils;

    // For JWT
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    ///////////////////////////////////////////////////////////////////////////////
    // Dikkat: application.properties özelliğinden alıyorum.
    /*
    # WebSecurity icin kullanacagim
    spring.security.superadmin.email=hamitmizrak@gmail.com
    spring.security.superadmin.password=root
    spring.security.superadmin.roles=SUPERADMIN
    spring.security.superadmin.nickname=HamitM
    spring.security.superadmin.name=Hamit
    spring.security.superadmin.surname=Mizrak
     */
    // ADMIN
    /*
    username: hamitmizrak@gmail.com
    password: root
     */

    // WRITER
    /*
    username: writer
    password: root
     */

    // USER
    /*
    username: user
    password: root
     */

    // application.properties'ten verileri almak
    // import org.springframework.beans.factory.annotation.Value;
    @Value("${spring.security.superadmin.email}")
    private String superAdminEmail;

    @Value("${spring.security.superadmin.password}")
    private String superAdminPassword;

    @Value("${spring.security.superadmin.roles}")
    private String superAdminRoles;

    ///////////////////////////////////////////////////////////////////////////////
    // Static WEB dosyaları
    // Static WEB dosyalarına Spring Security tarafıdnan izin verelim yoksa UI Web iyi görünmez
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/favicon.ico"))
                .requestMatchers(new AntPathRequestMatcher("/favicon.ico"))
                .requestMatchers(new AntPathRequestMatcher("/html/**"))
                .requestMatchers(new AntPathRequestMatcher("/css/**"))
                .requestMatchers(new AntPathRequestMatcher("/js/**"))
                .requestMatchers(new AntPathRequestMatcher("/img/**"))
                .requestMatchers(new AntPathRequestMatcher("/lib/**"));
    } //end WebSecurityCustomizer

    ///////////////////////////////////////////////////////////////////////////////
    // Database üzerinden olmadan Spring cache üzerinden In-Memory olarak Role Management System
    //@Primary //varsayılan Bean olmasını istiyorsak @Primary eklememiz gerekiyor
    // Varsayılan Bean seçiminden eğer birden fazla UserDetailsService bean varsa bu beanlerden
    // hangisi varsayılan Bean olmasını istiyorsak @Primary eklememiz gerekiyor
    // import org.springframework.security.core.userdetails.UserDetails; => UserDetails
    /*
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoderBean passwordEncoder) {

        // ADMIN
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username(superAdminEmail)
                .password(superAdminPassword)
                .roles(superAdminRoles)
                .build();

        // WRITER
        UserDetails writer = User.withDefaultPasswordEncoder()
                .username("writer")
                .password("root")
                .roles("WRITER")
                .build();

        // USER
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("username")
                .password("root")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, writer, user);
    } //end InMemoryUserDetailsManager
    */

    ///////////////////////////////////////////////////////////////////////////////
    // http://localhost:4444
    // http://localhost:4444/h2-console
    // http://localhost:4444/swagger-ui/index.html
    // http://localhost:4444/api/customer/v1.0.0/find/1

    // NOT: Spring Security için Spring boot semantic version: 3.3.4 kullandım
    // Dikkat: Spring Security ile çalışırken Sürekli Browserınızın Cache Belleğini siliniz.

    // Filter: SecurityFilterChain
    // İzin verilmesi gerekn Path
    @Bean
    // protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, HandlerMappingIntrospector introspector) throws Exception {
    // For Jwt
    protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, HandlerMappingIntrospector introspector, _9_JwtFilter customizeMyJwtFilter) throws Exception {

        // CSRF(Cross-Site Request Forgery) korumasını devre dışı bıraktık,
        // Kötü niyetli kişiler tarafından kullanıcı bilgileri çalarak sistemeye girmesi
        // Bu genellikle API'larda kullanmaktayız
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        // Web sayfalarında Yetkilendirme ayarlarını yapıyoruz.
        httpSecurity.authorizeHttpRequests(
                        authorize -> authorize
                                // Anasayfaya izin ver
                                .requestMatchers(new MvcRequestMatcher(introspector, "/")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/index")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/index.html")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/index.htm")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/index.jsp")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/index.jsp")).permitAll()

                                // Genel public'lere izin ver
                                //.requestMatchers(new MvcRequestMatcher(introspector, "/public/**")).permitAll()
                                // Login, Register
                                .requestMatchers(new MvcRequestMatcher(introspector, "/login")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/register")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/logout")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/admin")).permitAll()

                                // Third part Libraries
                                .requestMatchers(new MvcRequestMatcher(introspector, "/swagger-ui/**")).permitAll()
                                //.requestMatchers(new AntPathRequestMatcher("/h2-console/**", "GET"))
                                .requestMatchers(new MvcRequestMatcher(introspector, "/h2-console/**")).permitAll()

                                // Jwt Url yani login, register izin vermek
                                .requestMatchers(new MvcRequestMatcher(introspector, "/api/auth/**")).permitAll()

                                // Yukarıki url'lerin hariçinde bütün url izin verilmedikçe(Authorization) erişilmesin
                                // 401: Yerkisiz giriş
                                .anyRequest().authenticated()) // end httpSecurity.authorizeHttpRequests

                // For Jwt
                .addFilterBefore(customizeMyJwtFilter, UsernamePasswordAuthenticationFilter.class)

                // POSTMAN AUTHENTICATION
                // Http Temel Kimlik doğrulaması (Basic Auth) kullanılır.
                // Bu yapı Postman gibi client uygulamalarda mutlaka açmalıyız.
                .httpBasic(Customizer.withDefaults())

                // WEB SAYFA AUTHENTICATION
                // Form tabanlı girişler içindir(Spring MVC)
                // .formLogin(Customizer.withDefaults())

                // Logout işlemler için bu ayarları kullanıyoruz.
                //Ancak Çıkış yaptığımızda oturum(session) geçersiz olur
                .logout().logoutUrl("/logout").invalidateHttpSession(true);

        return httpSecurity.build();
    }

}
