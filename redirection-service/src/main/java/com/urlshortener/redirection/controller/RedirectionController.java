package com.urlshortener.redirection.controller;

import com.urlshortener.redirection.service.RedirectionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/redirection")
public class RedirectionController {
    private RedirectionService redirectionService;

    public RedirectionController(RedirectionService redirectionService) {
        this.redirectionService = redirectionService;
    }

    @GetMapping("/to/{shortUrl}")
    public ResponseEntity<Void> redirect(@PathVariable String shortUrl) {
        var longUrl = redirectionService.getLongUrl(shortUrl);
        if(longUrl.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(longUrl));
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
} 