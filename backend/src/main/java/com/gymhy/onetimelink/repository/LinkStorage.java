package com.gymhy.onetimelink.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author gongyiming
 */
@Repository
public class LinkStorage {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public boolean storeLinkAndContent(String link, String content) {
        if (containsUrl(link)) {
            return false;
        }
        redisTemplate.opsForValue().set(link, content, 60, TimeUnit.MINUTES);
        return true;
    }

    public boolean containsUrl(String link) {
        Boolean test = redisTemplate.opsForValue().getOperations().hasKey(link);
        return test != null && test;
    }

    public String searchByLink(String link) {
        String content = redisTemplate.opsForValue().get(link);
        redisTemplate.unlink(link);
        return content;
    }

}
