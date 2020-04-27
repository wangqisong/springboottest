package com.example.springboottest.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangqisong
 * @date: 2020/4/9
 * @Description:
 */
@Configuration
@EnableCaching
public class CacheConfig {

    /**
     * 使用内存作为缓存
     * @return
     */
    @Bean
    public CacheManager getCacheManager() {
        CacheManager cacheManager = new SimpleCacheManager();
        ConcurrentMapCache userCache = new ConcurrentMapCache("user");
        List<Cache> names = new ArrayList<>();
        names.add(userCache);
        ((SimpleCacheManager) cacheManager).setCaches(names);
        return cacheManager;
    }
}
