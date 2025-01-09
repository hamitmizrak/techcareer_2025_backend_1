package com.hamitmizrak.techcareer_2025_backend_1.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/*
    Eklenmiş Özellikler:
    redisTemplate:
    Key ve Value için StringRedisSerializer ve GenericJackson2JsonRedisSerializer kullanır.
    Genellikle standart CRUD işlemleri için kullanılır.

    customCacheConfiguration:
    Cache isimleri için bir customPrefix ekler.
    1 saatlik bir geçerlilik süresi tanımlar.
    Null değerlerin cache yapılmasını engeller.

    loggingRedisTemplate:
    Redis işlemleri için loglama desteği eklenmiştir.
    Transaction desteği aktif hale getirilmiştir.

    transactionalRedisTemplate:
    RedisTemplate üzerinde transaction desteği sağlanmıştır.
    Bu, aynı işlem içindeki birçok Redis komutunun atomik olarak çalıştırılmasını sağlar.

    cacheConfiguration:
    Daha kısa süreli cache işlemleri için 1 dakikalık TTL belirler.
    Null değerlerin cache yapılmasını önler.
    Bu yapılandırma, Redis'i hem cache hem de transaction bazlı işlemler için esnek bir şekilde kullanmanıza olanak sağlar.
    Ayrıca, farklı kullanım senaryoları için ayrı RedisTemplate tanımları sağlanmıştır.
*/

// REDIS : için aşağıdaki linktten çalışıp çalışmadığını bu linkten anlayabiliriz
// http://localhost:4444/api/address/v1.0.0/find/1

@Configuration
@EnableCaching
public class RedisConfig {

    /**
     * Standart bir RedisTemplate yapılandırması.
     * Key ve Value için sırasıyla StringRedisSerializer ve GenericJackson2JsonRedisSerializer kullanılır.
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

    /**
     * Default Cache Configuration - Özellikle kısa süreli cache kullanımları için.
     */
    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(1)) // 1 dakikalık geçerlilik süresi
                .disableCachingNullValues() // Null değerlerini cache’lemez
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

    /*
    Test İçin: AddressService yazdığım Redis için
    // FIND BY ID (Address)
    // REDIS : için aşağıdaki linktten çalışıp çalışmadığını bu linkten anlayabiliriz
    // http://localhost:4444/api/address/v1.0.0/find/1
    * */

    /**
     * Cache Configuration - Cache prefix ekleme ve TTL (Time To Live) belirleme.
     */
   /* @Bean
    public RedisCacheConfiguration customCacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .prefixCacheNameWith("customPrefix::") // Cache isimlerine özel bir prefix ekler
                .entryTtl(Duration.ofHours(1)) // Cache geçerlilik süresini 1 saat olarak belirler
                .disableCachingNullValues() // Null değerleri cache’lemez
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }*/



    /**
     * RedisTemplate ile özel loglama ve transaction desteği.
     */
    @Bean
    public RedisTemplate<String, Object> loggingRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setEnableTransactionSupport(true); // Transaction desteği
        return template;
    }

    /**
     * Transaction destekli RedisTemplate yapılandırması.
     */
    @Bean
    public RedisTemplate<String, Object> transactionalRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setEnableTransactionSupport(true); // Transaction desteği
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

} //end RedisConfig


