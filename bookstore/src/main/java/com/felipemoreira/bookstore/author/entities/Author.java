package com.felipemoreira.bookstore.author.entities;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import com.felipemoreira.bookstore.books.entities.Books;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "AUTHOR_NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "AUTHOR_AGE", columnDefinition = "INTEGER DEFAULT 0")
    private Integer age;

    @OneToMany(mappedBy = "author", fetch = LAZY)
    private List<Books> books;
}
