package com.felipemoreira.bookstore.domain.dto;

import static javax.persistence.EnumType.STRING;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.felipemoreira.bookstore.domain.enums.Gender;
import java.time.LocalDate;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {

    private Long id;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String name;

    @NotNull
    @Max(120)
    private Integer age;

    @Enumerated(STRING)
    @NotNull
    private Gender gender;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthdate;

    public UserDto() {
    }

    public UserDto(Long id, String name, Integer age,
        Gender gender, String email, String userName, String password, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.birthdate = birthdate;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserDto)) {
            return false;
        }

        UserDto userDto = (UserDto) o;

        if (!getId().equals(userDto.getId())) {
            return false;
        }
        if (!getName().equals(userDto.getName())) {
            return false;
        }
        if (!getAge().equals(userDto.getAge())) {
            return false;
        }
        if (getGender() != userDto.getGender()) {
            return false;
        }
        if (!getEmail().equals(userDto.getEmail())) {
            return false;
        }
        if (!getUserName().equals(userDto.getUserName())) {
            return false;
        }
        if (!getPassword().equals(userDto.getPassword())) {
            return false;
        }
        return getBirthdate().equals(userDto.getBirthdate());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getAge().hashCode();
        result = 31 * result + getGender().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getUserName().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getBirthdate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserDto{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", gender=" + gender +
            ", email='" + email + '\'' +
            ", userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", birthdate=" + birthdate +
            '}';
    }
}
