package com.example.SerwisRest.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data Transfer Object for Author")
public class AuthorDto {

    @Schema(description = "Unique identifier of the author", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Name of the author", example = "Darya Huseva")
    private String name;

    @Schema(description = "List of notes created by the author")
    private List<NoteDto> notes;


}
