package com.example.SerwisRest.api.factories;

import com.example.SerwisRest.api.dto.AuthorDto;
import com.example.SerwisRest.store.entities.AuthorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AuthorDtoFactory {
    private final NoteDtoFactory noteDtoFactory;


    public AuthorDto makeAuthorDto(AuthorEntity author) {
        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .notes(
                        author.getNotes()
                                .stream()
                                .map(noteDtoFactory::makeNoteDto)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
