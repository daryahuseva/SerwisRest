package com.example.SerwisRest.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {
    private Long id;

    private String title;

    private String content;

    @JsonProperty("created_at")
    private Instant createdAt;
}


