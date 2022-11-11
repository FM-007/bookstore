package com.felipemoreira.bookstore.entities;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import com.felipemoreira.bookstore.entities.Books;
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
    private LocalDate foundationDate;

    @OneToMany(mappedBy = "publisher", fetch = LAZY)
    private List<Books> books;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Publisher)) {
            return false;
        }

        Publisher publisher = (Publisher) o;

        if (getId() != null ? !getId().equals(publisher.getId()) : publisher.getId() != null) {
            return false;
        }
        if (!getName().equals(publisher.getName())) {
            return false;
        }
        if (!getCode().equals(publisher.getCode())) {
            return false;
        }
        if (getFoundationDate() != null ? !getFoundationDate().equals(publisher.getFoundationDate())
            : publisher.getFoundationDate() != null) {
            return false;
        }
        return getBooks() != null ? getBooks().equals(publisher.getBooks())
            : publisher.getBooks() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getName().hashCode();
        result = 31 * result + getCode().hashCode();
        result = 31 * result + (getFoundationDate() != null ? getFoundationDate().hashCode() : 0);
        result = 31 * result + (getBooks() != null ? getBooks().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Publisher{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", code='" + code + '\'' +
            ", foundationDate=" + foundationDate +
            ", books=" + books +
            '}';
    }
}
