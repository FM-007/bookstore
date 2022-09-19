package com.felipemoreira.bookstore.services;

import com.felipemoreira.bookstore.builder.AuthorDtoBuilder;
import com.felipemoreira.bookstore.domain.dto.AuthorDto;
import com.felipemoreira.bookstore.domain.mappper.AuthorMapper;
import com.felipemoreira.bookstore.repositories.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    private final AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    @InjectMocks
    private AuthorService authorService;

    @Mock
    private AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        AuthorDtoBuilder authorDtoBuilder = AuthorDtoBuilder.builder().build();
        AuthorDto authorDto = authorDtoBuilder.buildAuthorDto();
    }
}
