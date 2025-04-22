package com.example.SerwisRest.store.entities;

import jakarta.persistence.*;
import lombok.*;

//import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@Table(name = "author")
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

  //  @NotBlank(message = "Obowiazkowe")
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<NoteEntity> notes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<NoteEntity> getNotes() {
        return notes;
    }

}

