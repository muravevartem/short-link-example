package com.example.shortlink.controller;

import com.example.shortlink.dto.LinkCreationRequest;
import com.example.shortlink.dto.LinkResponse;
import com.example.shortlink.service.Linker;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/linker")
@RequiredArgsConstructor
public class LinkController {
    private final Linker linker;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LinkResponse create(@RequestBody @Valid LinkCreationRequest linkRequest) {
        return linker.create(linkRequest);
    }

    @GetMapping("/{hash}")
    public void get(@PathVariable String hash, HttpServletResponse response) throws IOException {
        String originalLink = linker.getOriginalLink(hash);
        response.sendRedirect(originalLink);
    }
}
