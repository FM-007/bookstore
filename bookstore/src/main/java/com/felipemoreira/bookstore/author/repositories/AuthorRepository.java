package com.felipemoreira.bookstore.author.repositories;

import com.felipemoreira.bookstore.author.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
