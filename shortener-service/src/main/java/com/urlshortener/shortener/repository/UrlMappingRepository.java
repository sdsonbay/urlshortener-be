package com.urlshortener.shortener.repository;

import com.urlshortener.shortener.entity.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
    Optional<UrlMapping> findByShortUrl(String shortUrl);
    Optional<UrlMapping> findByLongUrl(String longUrl);
} 