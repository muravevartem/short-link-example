package com.example.shortlink.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record LinkCreationRequest(
        @NotBlank
        @URL
        @JsonProperty("originalLink")
        String originalLink
) {
}
