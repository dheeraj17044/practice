package com.example.caching.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CachingConfig {

    /*

    Defining the custom CacheConfig class for configuration
    which uses Simple

     */

    /*
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        ConcurrentMapCache cache1 = new ConcurrentMapCache("student");
        ConcurrentMapCache cache2 = new ConcurrentMapCache("course");
        cacheManager.setCaches(Arrays.asList(cache1,cache2));
        return cacheManager;
    }

     */


    /*
    Defining the caffeine cache object
    */

//    @Bean
//    public Caffeine caffeineConfig() {
//        return Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES);
//    }
//
//    @Bean
//    public CacheManager cacheManager(Caffeine caffeine) {
//        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
//        caffeineCacheManager.setCaffeine(caffeine);
//        return caffeineCacheManager;
//    }

    /*
        handling Multiple cache with cache manager
    */

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();

        // Configure "student_cache" with a TTL of 1 minutes
        Caffeine<Object, Object> studentCacheBuilder = Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES);
        CaffeineCache studentCache = new CaffeineCache("student_cache", studentCacheBuilder.build());

        // Configure "course_cache" with a TTL of 1 minutes
        Caffeine<Object, Object> courseCacheBuilder = Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES);
        CaffeineCache courseCache = new CaffeineCache("course_cache", courseCacheBuilder.build());

        // Manually add the configured caches to the CacheManager
        cacheManager.registerCustomCache("student_cache", studentCache.getNativeCache());
        cacheManager.registerCustomCache("course_cache", courseCache.getNativeCache());

        return cacheManager;
    }

}
