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
//        author.setBooks(bookList());
//        LocalDateTime date = LocalDateTime.now();
//        author.setCreatedDate(date);
//        author.setLastModifiedDate(date);

        return author;
    }

    public static AuthorDto authorCreated() {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(1L);
        authorDto.setName("Felipe Moreira");
        authorDto.setAge(32);

        return authorDto;
    }

    public static List<Books> bookList() {
        Author author = new Author();
        Publisher publisher = new Publisher();
        User user = new User();

        List<Books> books = new ArrayList<>();
        Books book = new Books();
        book.setId(1L);
        book.setBookName("Teste");
        book.setIsbn("123456");
        book.setPages(360);
        book.setChapters(36);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setUser(user);

        books.add(book);

        return books;
    }
}
