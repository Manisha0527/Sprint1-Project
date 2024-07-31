package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Librarian;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer>{

}
