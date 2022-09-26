package com.felipemoreira.bookstore.helper;

import com.felipemoreira.bookstore.domain.dto.AuthorDto;
import com.felipemoreira.bookstore.entities.Author;
import com.felipemoreira.bookstore.entities.Books;
import com.felipemoreira.bookstore.entities.Publisher;
import com.felipemoreira.bookstore.entities.User;
import java.util.ArrayList;
import java.util.List;

public class AuthorHelper {

    public static Author authorCreatedEntity() {
        Author author = new Author();
        author.setId(1L);
        author.setName("Felipe Moreira");
        author.setAge(32);

        return author;
    }

    public static AuthorDto authorCreated() {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(1L);
        authorDto.setName("Felipe Moreira");
        authorDto.setAge(32);

        return authorDto;
    }
}
