package com.example.SerwisRest.api.factories;

import com.example.SerwisRest.api.dto.NoteDto;
import com.example.SerwisRest.store.entities.NoteEntity;
import org.springframework.stereotype.Component;

@Component
public class NoteDtoFactory {
    public NoteDto makeNoteDto(NoteEntity note) {
        return NoteDto.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .createdAt(note.getCreatedAt())
                .build();
    }
}
