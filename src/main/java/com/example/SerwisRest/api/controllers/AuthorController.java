package com.example.SerwisRest.api.controllers;

import com.example.SerwisRest.api.dto.AuthorDto;
import com.example.SerwisRest.api.factories.AuthorDtoFactory;
import com.example.SerwisRest.store.entities.AuthorEntity;
import com.example.SerwisRest.api.exceptions.NotFoundException;
import com.example.SerwisRest.store.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final AuthorDtoFactory authorDtoFactory;

    @GetMapping
    public List<AuthorDto> getAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(authorDtoFactory::makeAuthorDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/api/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        AuthorEntity author = AuthorEntity.builder()
                .name(authorDto.getName())
                .build();

        AuthorEntity savedAuthor = authorRepository.save(author);
        return ResponseEntity
                .created(URI.create("/api/authors/" + savedAuthor.getId()))
                .body(authorDtoFactory.makeAuthorDto(savedAuthor));
    }
   @GetMapping("/{id}")
   public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long id) {
       AuthorEntity author = authorRepository.findById(id)
               .orElseThrow(() -> new NotFoundException("Author with id " + id + " not found"));

       return ResponseEntity.ok(authorDtoFactory.makeAuthorDto(author));
   }

}
