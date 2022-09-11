package com.felipemoreira.bookstore.entities;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import com.felipemoreira.bookstore.domain.enums.Gender;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.Hibernate;

@Entity
@Table(name = "USER_BOOKSTORE")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User extends Auditable {

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
    @Exclude
    private List<Books> books;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(
            o)) {
            return false;
        }
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
