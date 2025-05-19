package com.urlshortener.shortener.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShortenUrlResponse {
    public String shortUrl;
}
