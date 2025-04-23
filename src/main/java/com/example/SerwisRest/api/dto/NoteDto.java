package com.example.SerwisRest.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data Transfer Object representing a Note")
public class NoteDto {

    @Schema(description = "Unique identifier of the note", example = "100", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Title of the note", example = "My First Note")
    private String title;

    @Schema(description = "Content of the note", example = "This is a sample note content.")
    private String content;

    @JsonProperty("created_at")
    @Schema(description = "Timestamp when the note was created", example = "2025-04-22T19:16:56.059907", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime createdAt;

}


