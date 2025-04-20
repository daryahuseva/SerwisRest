package com.example.SerwisRest.store.entities;

import jakarta.persistence.*;
import lombok.*;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Obowiazkowe")
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<NoteEntity> notes;


    public AuthorEntity() {

    }
}

