package com.felipemoreira.bookstore.books.repositories;

import com.felipemoreira.bookstore.books.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {

}
