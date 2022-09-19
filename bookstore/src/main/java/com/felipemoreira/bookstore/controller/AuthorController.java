package com.felipemoreira.bookstore.controller;

import com.felipemoreira.bookstore.services.AuthorService;
import com.felipemoreira.bookstore.utils.AuthorsControllerDocs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController implements AuthorsControllerDocs {

    @Autowired
    private AuthorService authorService;


}
