package com.example.shortlink.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LinkResponse(
        @JsonProperty("originalLink")
        String originalLink,

        @JsonProperty("hashedLink")
        String hashedLink
) {
}
