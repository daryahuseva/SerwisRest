package com.example.SerwisRest.store.entities;

import jakarta.persistence.*;
import lombok.*;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity@NoArgsConstructor
@AllArgsConstructor
@Table(name = "note")
public class NoteEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //sequence
    private Long id;

    @NotBlank(message = "Obowiazkowe")
    private String title;

    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private AuthorEntity author;
}


