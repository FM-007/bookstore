package com.felipemoreira.bookstore.user.entities;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import com.felipemoreira.bookstore.books.entities.Books;
import com.felipemoreira.bookstore.user.domain.enums.Gender;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "USER_NAME", nullable = false)
    private String name;

    @Column(name = "USER_AGE", nullable = false)
    private Integer age;

    @Enumerated(STRING)
    @Column(name = "GENDER", nullable = false, length = 20)
    private Gender gender;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String userName;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "BIRTHDATE", columnDefinition = "TIMESTAMP")
    private LocalDate birthdate;

    @OneToMany(mappedBy = "user", fetch = LAZY)
    private List<Books> books;
}