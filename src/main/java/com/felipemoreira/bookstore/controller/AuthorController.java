package com.felipemoreira.bookstore.controller;

import static org.springframework.http.HttpStatus.CREATED;

import com.felipemoreira.bookstore.domain.dto.AuthorDto;
import com.felipemoreira.bookstore.services.AuthorService;
import com.felipemoreira.bookstore.utils.AuthorsControllerDocs;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController implements AuthorsControllerDocs {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    @ResponseStatus(CREATED)
    public AuthorDto create(@RequestBody @Valid AuthorDto authorDto) {
        return authorService.create(authorDto);
    }

    @GetMapping("/{id}")
    public AuthorDto findById(@PathVariable Long id) {
        return authorService.findById(id);
    }
}
