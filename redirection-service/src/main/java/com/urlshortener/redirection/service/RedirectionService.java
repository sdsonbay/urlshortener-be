package com.urlshortener.redirection.service;

import com.urlshortener.redirection.repository.UrlMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedirectionService {
    private final UrlMappingRepository urlMappingRepository;

    public String getLongUrl(String shortUrl) {
        var existingUrlMapping = urlMappingRepository.findByShortUrl(shortUrl);
        if(existingUrlMapping.isEmpty()){
            return null;
        }

        var a = existingUrlMapping.get().getLongUrl();
        return a;
    }
}