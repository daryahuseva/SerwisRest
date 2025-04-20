package com.example.SerwisRest.store.repositories;

import com.example.SerwisRest.store.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

}
