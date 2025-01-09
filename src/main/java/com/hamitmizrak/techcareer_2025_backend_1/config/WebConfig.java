package com.hamitmizrak.techcareer_2025_backend_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

//@Configuration: Bean tanımlarımını ve uygulamada yapılandırmalarını sağlamak içindir
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // CORS (Cross Origin Resource Sharing)
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry
                .addMapping("/**") //Tüm pointeler için CORS geçerli olsun
                //.allowedOrigins("*") // Bütün Kaynaklara izin ver
                .allowedOrigins("http://localhost:3000") // Sadece Belirli Kaynaklara izin ver
                .allowedMethods("GET", "POST", "PUT", "DELETE") // İzin verilen Http Metotları
                .allowedHeaders("*") //  izin verilen başlılar => Tüm başlıkları kabul et,
                .allowCredentials(true); // Kimlik doğrulama bilgilerinde izin ver(Cookie, header, authorization vs)
    }

    // Statik Kaynaklara İzin vermem (Spring MVC içindir)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry
                .addResourceHandler("/resources/**")// Statik kod kaynakların URL deseni
                .addResourceLocations("/public/", "classpath:/static/") //Kaynakların Yeri
                .setCachePeriod(3600); // Cache Süresi Saniye cinsinden: 1=60 saniye 60*60=3600 =1 saat boyunca statik kod kaynaklarını cache belleğinde sakla
    }

    // Eğer Spring MVC uygulamanızda JSP, Thymeleaf gibi görünümler kullanıyorsanız,
    // bir View Resolver yapılandırabilirsiniz.
    // Bu, HTML dosyalarının veya JSP sayfalarının nerede bulunduğunu belirtir.
    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
        viewResolverRegistry.jsp("/WEB-INF/views/", ".jsp");  // JSP dosyalarının yeri ve uzantısı
    }

    // Tarihler veya sayılar gibi verilerin formatlanması gerekiyorsa, özel formatlayıcılar ekleyebilirsiniz.
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));  // Tarih biçimlendirici ekler
    }

    // 1.YOL Varsayılan dil olarak Türkçe  ayarlanır
    // Varsayılan dil olarak Türkçe ayarlanır
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("tr", "TR"));  // Varsayılan dil Türkçe
        return localeResolver;
    }

    // 2.YOL Varsayılan dil olarak İngilizce ayarlanır
    /*
    @Bean
    public LocaleResolver localeResolver() {
        // Varsayılan dil olarak İngilizce ayarlanır
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(Locale.US);
        return resolver;
    }
    */

    //////////////////////////////////////////////////////////////////////////////////
    // Interceptor
    // Dili değiştirmek için LocaleChangeInterceptor eklenir
    // http://localhost:4444?lang=ge
     /*
    Açıklamalar:
    CookieLocaleResolver: Kullanıcının seçtiği dili bir cookie'de saklar. Bu sayede kullanıcı uygulamaya tekrar girdiğinde aynı dili kullanabilir.
    localeResolver.setDefaultLocale(new Locale("tr", "TR")): Bu satır, varsayılan dil olarak Türkçe'yi (Türkiye) ayarlar.
    Bu, uygulama ilk açıldığında Türkçe'nin kullanılacağı anlamına gelir.
    LocaleChangeInterceptor: Bu interceptor, URL parametresine göre dili değiştirmeye olanak tanır.
    Örneğin, ?lang=en parametresi ile dili İngilizce yapabilirsiniz.
    Örnek Kullanım:
    Uygulama varsayılan olarak Türkçe başlayacaktır.
    URL'de ?lang=en gibi bir parametre ile dili İngilizce veya başka dillerle değiştirebilirsiniz.
     */
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        localeInterceptor.setParamName("lang");  // URL parametresi ile dil değiştirme
        interceptorRegistry.addInterceptor(localeInterceptor);
    }

} //end WebConfig
