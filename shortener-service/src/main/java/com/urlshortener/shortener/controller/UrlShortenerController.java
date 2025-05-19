package com.urlshortener.shortener.controller;

import com.urlshortener.shortener.requests.ShortenUrlRequest;
import com.urlshortener.shortener.responses.ShortenUrlResponse;
import com.urlshortener.shortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/shortener")
public class UrlShortenerController {
    private UrlShortenerService urlShortenerService;

    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping(value = "/shorten", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ShortenUrlResponse> shortenUrl(@RequestBody ShortenUrlRequest request) {
        var shortUrl = urlShortenerService.shortenUrl(request.url);
        var response = ShortenUrlResponse.builder()
                .shortUrl("http://localhost:8082/api/v1/redirection/to/" + shortUrl)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> getLongUrl(@PathVariable String shortUrl) {
        var longUrl = urlShortenerService.getLongUrl(shortUrl);
        if(longUrl.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(longUrl);
    }
} 