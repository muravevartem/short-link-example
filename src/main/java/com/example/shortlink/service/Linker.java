package com.example.shortlink.service;

import com.example.shortlink.dto.LinkCreationRequest;
import com.example.shortlink.dto.LinkResponse;

public interface Linker {
    LinkResponse create(LinkCreationRequest request);

    String getOriginalLink(String hash);
}
