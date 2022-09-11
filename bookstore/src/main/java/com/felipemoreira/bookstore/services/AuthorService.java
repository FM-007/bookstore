package com.felipemoreira.bookstore.services;

import com.felipemoreira.bookstore.domain.mappper.AuthorMapper;
import com.felipemoreira.bookstore.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private static final AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    @Autowired
    private AuthorRepository authorRepository;


}
