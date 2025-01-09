package com.hamitmizrak.techcareer_2025_backend_1.aspect;

import com.hamitmizrak.techcareer_2025_backend_1.users.AuthenticationName;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

// AOP
@Aspect
@Component //Bu Classın Spring Framework tarafından takip edilmesi tanınmasını istiyoruz.
public class _3_AuditingAspect {

    @Autowired
    private _2_IAuditLogRepository iAuditLogRepository;

    // AuditingAspect'e ek olarak bir toplu kayıt yöntemi ekleyin:
    public void logBatchAudit(List<_1_AuditLogEntity> auditLogs) {
        iAuditLogRepository.saveAll(auditLogs);
    }

    /*
    Açıklamalar
    Aspect Tanımı: AuditingAspect sınıfı, tüm servis katmanındaki metot çağrılarını @AfterReturning ile dinler ve işlem sonrası log kaydı oluşturur.
    Dinleme Noktaları: execution(* com.example.auditing.service.*.*(..)) ifadesi, servis katmanındaki tüm sınıfların tüm metotlarını kapsar.
    Audit Log: AuditLog sınıfı ile loglama işlemleri H2 veritabanında saklanır.
    Performans Etkisi: AOP'nin loglama amacıyla kullanımı sistem performansına minimum etki yapar,
    çünkü işlemler yalnızca metodun sonunda tetiklenir.
    Bu örnek, Spring AOP kullanarak audit işlemleri için temel bir yapı sağlar.
    Sistemi genişletmek için loglama detaylarını artırabilir, kullanıcı kimlik doğrulama bilgilerini dinamik olarak ekleyebilir ve farklı olaylar için özelleştirilmiş loglama gerçekleştirebilirsiniz.
 */
    @AfterReturning("execution(* com.hamitmizrak.techcareer_2025_backend_1.business.services.impl.*.*(..))")
    public void logAudit(JoinPoint joinPoint) {

        // İşlem yapılan sınıf adı
        String className = joinPoint.getTarget().getClass().getSimpleName();

        // Metod adı
        String methodName = joinPoint.getSignature().getName();

        // Sisteme Login olmuş kullanıcı veya Varsayılan kullanıcı (Ternary)
        String performedBy = AuthenticationName.isAuthenticationName()!=null
                ? AuthenticationName.isAuthenticationName()
                : "Hamit Mızrak";

        // Yeni bir AuditLog kaydı oluştur
        _1_AuditLogEntity log = new _1_AuditLogEntity(
                className,
                methodName,
                performedBy,
                new Date()
        );

        // Veritabanına kaydet
        iAuditLogRepository.save(log);

        System.out.println("AOP with Audit Log Created: " + log);
    }
}


