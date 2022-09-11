package com.felipemoreira.bookstore.books.entities;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.GenerationType.IDENTITY;

import com.felipemoreira.bookstore.author.entities.Author;
import com.felipemoreira.bookstore.publisher.entities.Publisher;
import com.felipemoreira.bookstore.user.entities.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "BOOKS")
public class Books {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "BOOK_NAME", nullable = false, length = 100)
    private String bookName;

    @Column(name = "ISBN", nullable = false)
    private String isbn;

    @Column(name = "PAGES", columnDefinition = "INTEGER DEFAULT 0")
    private Integer pages;

    @Column(name = "CHAPTERS", columnDefinition = "INTEGER DEFAULT 0")
    private Integer chapters;

    @ManyToOne(cascade = {MERGE})
    private Author author;

    @ManyToOne(cascade = {MERGE})
    private Publisher publisher;

    @ManyToOne(cascade = {MERGE})
    private User user;
}
