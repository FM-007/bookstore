package com.felipemoreira.bookstore.entities;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHOR")
public class Author extends Auditable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "AUTHOR_NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "AUTHOR_AGE", columnDefinition = "INTEGER DEFAULT 0")
    private Integer age;

    @OneToMany(mappedBy = "author", fetch = LAZY)
    private List<Books> books;

    public Author() {
    }

    public Author(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Author(Long id, String name, Integer age,
        List<Books> books) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
            "id = " + id + ", " +
            "createdDate = " + createdDate + ", " +
            "lastModifiedDate = " + lastModifiedDate + ", " +
            "name = " + name + ", " +
            "age = " + age + ")";
    }
}
