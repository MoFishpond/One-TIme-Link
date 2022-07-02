package com.gymhy.redistemplate.domain;

import com.gymhy.redistemplate.entity.QueryRequest;
import com.gymhy.redistemplate.repository.LinkStorage;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * @author gongyiming
 */
@Service
public class LinkService {

    @Autowired
    private LinkStorage linkStorage;

    private String generateOneTimeWithoutCheck() {
        return RandomStringUtils.randomAlphanumeric(6);
    }

    public String generateLinkAndStoreContent(String content) {
        boolean test;
        String url;
        do {
            url = generateOneTimeWithoutCheck();
            test = linkStorage.containsUrl(url);
        } while (test);
        boolean result = linkStorage.storeLinkAndContent(url, content);
        return result ? url : null;
    }

    public String fetchContent(String url) {
        if (!linkStorage.containsUrl(url)) {
            return null;
        }
        return linkStorage.searchByLink(url);
    }
}
