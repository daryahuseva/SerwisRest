package com.example.SerwisRest.store.repositories;


import com.example.SerwisRest.store.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Long>{

}
