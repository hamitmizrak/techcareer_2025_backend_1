package com.hamitmizrak.techcareer_2025_backend_1;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.TimeZone;

// Mongo aktif etmek ici
// @EnableMongoRepositories

// Aspect aktif etmek icin
// @EnableAspectJAutoProxy(proxyTargetClass = true)

// Asenkron açmak icin
// @EnableAsync

// SCAN
//@EntityScan(basePackages = "com.hamitmizrak.techcareer_2025_backend_1.data.entity") //Entity bulamadığı zaman
//@EnableJpaRepositories(basePackages = "com.hamitmizrak.techcareer_2025_backend_1.data.repository") //Repository bulamadığı zaman
//@ComponentScan("com")

// Spring Cache aktif etmek gerekiyor.
// @EnableCaching

// Auditing Aktif etmek
// Dikkat: auditorAwareBeanMethod bu isimlendirme Auditing Bean ismidir.
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBeanMethod")

// Spring Security: Şimdilik dahil etme, çünkü Bcrypted kullancağım ancak Spring security için gerekli kütüphaneleri dahil
// Buradaki exclude ne zaman kapatmam gerekiyor ? cevap: Spring Security ile çalıştığımız zaman kapat
@SpringBootApplication(exclude = {
		//SecurityAutoConfiguration.class,
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class,

		// Eğer Redis bağımlılığını kaldırmak istemiyorsanız ancak Redis yapılandırmasını devre dışı bırakmak istiyorsanız
		//RedisAutoConfiguration.class,
}
)
//@SpringBootApplication
public class Techcareer2025Backend1Application {

	// Normal Constructor
	public Techcareer2025Backend1Application() {
		System.out.println("@SpringBootApplication => Constrcutor");
	}

	// PostConstruct
	// Örneğin, veri hazırlığı, bağlantı oluşturma, bir değişkenin başlatılması gibi işlemler burada yapılabilir.
	// Bu metod, sınıfın constructor'ından sonra, ancak herhangi bir metodun çağrılmasından önce çalışır.
	@PostConstruct
	public void examplePostConstruct() {
		System.out.println("@SpringBootApplication => PostConstruct");
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
	}

	public static void main(String[] args) {

		// devtools active isActive
		//System.setProperty("spring.devtools.restart.enabled","true");

		// PORT Ayarlamak
        /*
        SpringApplication app = new SpringApplication(ThySpringbootRedisApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "4444"));
        app.run(args);
         */

		// JOptional pane aktif etmek
		System.setProperty("java.awt.headless", "false");

		// Main
		SpringApplication.run(Techcareer2025Backend1Application.class, args);
	} //end psvm

} //end class
