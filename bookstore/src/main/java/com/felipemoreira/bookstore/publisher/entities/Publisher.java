package com.felipemoreira.bookstore.publisher.entities;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import com.felipemoreira.bookstore.books.entities.Books;
import com.felipemoreira.bookstore.entities.Auditable;
import java.time.LocalDate;
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
@Table(name = "PUBLISHER")
public class Publisher extends Auditable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "PUBLISHER_NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "PUBLISHER_CODE", nullable = false, unique = true, length = 100)
    private String code;

    @Column(name = "FUNDATION_DATE", columnDefinition = "TIMESTAMP")
    private LocalDate foudationDate;

    @OneToMany(mappedBy = "publisher", fetch = LAZY)
    private List<Books> books;
}
