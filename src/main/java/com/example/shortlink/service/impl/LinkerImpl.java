package com.example.shortlink.service.impl;

import com.example.shortlink.configuration.LinkConfigurationProperties;
import com.example.shortlink.dto.LinkCreationRequest;
import com.example.shortlink.dto.LinkResponse;
import com.example.shortlink.entity.Link;
import com.example.shortlink.exception.LinkNotFoundException;
import com.example.shortlink.repository.LinkRepository;
import com.example.shortlink.service.Linker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class LinkerImpl implements Linker {
    private final LinkRepository linkRepository;
    private final LinkConfigurationProperties properties;

    @Override
    public LinkResponse create(LinkCreationRequest request) {
        String originalLink = request.originalLink();
        String hashedLink = UUID.randomUUID().toString().replace("-", "");
        Link link = new Link(originalLink, hashedLink);
        Link savedLink = linkRepository.save(link);
        return new LinkResponse(savedLink.getOriginal(), createHashedLink(savedLink.getHash()));
    }

    private String createHashedLink(String hash) {
        return properties.getBaseUrl() + "/" + hash;
    }

    @Override
    public String getOriginalLink(String hash) {
        Link link = linkRepository.findByHash(hash)
                .orElseThrow(LinkNotFoundException::new);
        return link.getOriginal();
    }
}
