package com.felipemoreira.bookstore.repositories;

import com.felipemoreira.bookstore.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {

}
