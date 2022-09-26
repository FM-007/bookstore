package com.felipemoreira.bookstore.domain.dto;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PublisherDto {

    private Long id;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String name;

    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String code;

    @NotNull
    @JsonFormat(shape = STRING, pattern = "dd/mm/yyyy")
    private LocalDate foundationDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PublisherDto)) {
            return false;
        }

        PublisherDto that = (PublisherDto) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) {
            return false;
        }
        if (!getName().equals(that.getName())) {
            return false;
        }
        if (!getCode().equals(that.getCode())) {
            return false;
        }
        return getFoundationDate().equals(that.getFoundationDate());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getName().hashCode();
        result = 31 * result + getCode().hashCode();
        result = 31 * result + getFoundationDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PublisherDto{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", code='" + code + '\'' +
            ", foundationDate=" + foundationDate +
            '}';
    }
}
