package com.example.caching.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableCaching
public class CachingConfig {

    /*

    Defining the custom CacheConfig class for configuration
    which uses Simple

     */

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        ConcurrentMapCache cache1 = new ConcurrentMapCache("student");
        ConcurrentMapCache cache2 = new ConcurrentMapCache("course");
        cacheManager.setCaches(Arrays.asList(cache1,cache2));
        return cacheManager;
    }
}
