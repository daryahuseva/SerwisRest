package com.example.SerwisRest.api.controllers;

import com.example.SerwisRest.api.dto.NoteDto;
import com.example.SerwisRest.api.factories.NoteDtoFactory;
import com.example.SerwisRest.store.entities.AuthorEntity;
import com.example.SerwisRest.store.entities.NoteEntity;
import com.example.SerwisRest.api.exceptions.BadRequestException;
import com.example.SerwisRest.api.exceptions.NotFoundException;
import com.example.SerwisRest.store.repositories.AuthorRepository;
import com.example.SerwisRest.store.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteRepository noteRepository;
    private final AuthorRepository authorRepository;
    private final NoteDtoFactory noteDtoFactory;

    @GetMapping
    public List<NoteDto> getNotes() {
        return noteRepository.findAll()
                .stream()
                .map(noteDtoFactory::makeNoteDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<NoteDto> createNote(@RequestBody NoteDto noteDTO, @RequestParam Long authorId) {
        AuthorEntity author = authorRepository.findById(authorId)
                .orElseThrow(() -> new BadRequestException("Author with id " + authorId + " not found"));

        NoteEntity note = NoteEntity.builder()
                .title(noteDTO.getTitle())
                .content(noteDTO.getContent())
                .author(author)
                .build();

        NoteEntity savedNote = noteRepository.save(note);

        return ResponseEntity
                .created(URI.create("/api/notes/" + savedNote.getId()))
                .body(noteDtoFactory.makeNoteDto(savedNote));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDto> getNoteById(@PathVariable Long id) {
        NoteEntity note = noteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Note with id " + id + " not found"));

        return ResponseEntity.ok(noteDtoFactory.makeNoteDto(note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNoteById(@PathVariable Long id) {
        if (!noteRepository.existsById(id)) {
            throw new NotFoundException("Note with id " + id + " not found");
        }

        noteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
