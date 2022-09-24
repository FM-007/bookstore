package com.felipemoreira.bookstore.services;

import static com.felipemoreira.bookstore.helper.AuthorHelper.authorCreated;
import static com.felipemoreira.bookstore.helper.AuthorHelper.authorCreatedEntity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.felipemoreira.bookstore.domain.dto.AuthorDto;
import com.felipemoreira.bookstore.domain.exception.AuthorAlreadyExistsException;
import com.felipemoreira.bookstore.domain.mappper.AuthorMapper;
import com.felipemoreira.bookstore.entities.Author;
import com.felipemoreira.bookstore.repositories.AuthorRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {


    @InjectMocks
    private AuthorService authorService;

    @Mock
    private AuthorMapper authorMapper;

    @Mock
    private AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatedAuthor() {
        AuthorDto expectedAuthorToCreateDto = authorCreated();
        Author expectedCreatedAuthor = authorCreatedEntity();

        when(authorRepository.findByName(expectedCreatedAuthor.getName())).thenReturn(Optional.empty());
        when(authorMapper.toEntity(expectedAuthorToCreateDto)).thenReturn(expectedCreatedAuthor);
        when(authorRepository.save(expectedCreatedAuthor)).thenReturn(expectedCreatedAuthor);
        when(authorMapper.toDto(expectedCreatedAuthor)).thenReturn(expectedAuthorToCreateDto);

        AuthorDto createdAuthorDto = authorService.create(expectedAuthorToCreateDto);

        assertThat(createdAuthorDto, is(equalTo(expectedAuthorToCreateDto)));
        assertNotNull(createdAuthorDto);
    }

    @Test
    void testCreatedAuthor_AuthorAlreadyExists() {
        AuthorDto expectedAuthorToCreateDto = authorCreated();
        Author expectedCreatedAuthor = authorCreatedEntity();

        when(authorRepository.findByName(expectedCreatedAuthor.getName())).thenReturn(Optional.of(expectedCreatedAuthor));

        assertThrows(AuthorAlreadyExistsException.class, () -> authorService.create(expectedAuthorToCreateDto));
    }
}
