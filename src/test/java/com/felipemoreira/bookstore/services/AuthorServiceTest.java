package com.felipemoreira.bookstore.services;

import static com.felipemoreira.bookstore.helper.AuthorHelper.authorCreated;
import static com.felipemoreira.bookstore.helper.AuthorHelper.authorCreatedEntity;
import static java.util.Collections.EMPTY_LIST;
import static java.util.Collections.singletonList;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.felipemoreira.bookstore.domain.dto.AuthorDto;
import com.felipemoreira.bookstore.domain.exception.AuthorAlreadyExistsException;
import com.felipemoreira.bookstore.domain.exception.AuthorNotFoundException;
import com.felipemoreira.bookstore.domain.mappper.AuthorMapper;
import com.felipemoreira.bookstore.entities.Author;
import com.felipemoreira.bookstore.repositories.AuthorRepository;
import java.util.List;
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

        when(authorRepository.findByName(expectedCreatedAuthor.getName())).thenReturn(empty());
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

        when(authorRepository.findByName(expectedCreatedAuthor.getName())).thenReturn(of(expectedCreatedAuthor));

        assertThrows(AuthorAlreadyExistsException.class, () -> authorService.create(expectedAuthorToCreateDto));
    }

    @Test
    void testFindById() {
        AuthorDto expectedFoundAuthorDto = authorCreated();
        Author expectedFoundAuthor = authorCreatedEntity();

        when(authorRepository.findById(expectedFoundAuthorDto.getId())).thenReturn(of(expectedFoundAuthor));
        when(authorMapper.toDto(expectedFoundAuthor)).thenReturn(expectedFoundAuthorDto);

        AuthorDto foundAuthorDto = authorService.findById(expectedFoundAuthorDto.getId());

        assertThat(foundAuthorDto, is(equalTo(expectedFoundAuthorDto)));
    }

    @Test
    void testFindById_NotFound() {
        AuthorDto expectedFoundAuthorDto = authorCreated();

        when(authorRepository.findById(expectedFoundAuthorDto.getId())).thenReturn(empty());

        assertThrows(AuthorNotFoundException.class, () -> authorService.findById(expectedFoundAuthorDto.getId()));
    }

    @Test
    void testFindAll() {
        AuthorDto expectedFoundAuthorDto = authorCreated();
        Author expectedFoundAuthor = authorCreatedEntity();

        when(authorRepository.findAll()).thenReturn(singletonList(expectedFoundAuthor));
        when(authorMapper.toDto(expectedFoundAuthor)).thenReturn(expectedFoundAuthorDto);

        List<AuthorDto> foundAuthorsDto = authorService.findAll();

        assertThat(foundAuthorsDto.size(), is(1));
        assertThat(foundAuthorsDto.get(0), is(equalTo(expectedFoundAuthorDto)));
    }

    @Test
    void testFindAll_EmptyList() {

        when(authorRepository.findAll()).thenReturn(EMPTY_LIST);

        List<AuthorDto> foundAuthorsDto = authorService.findAll();

        assertThat(foundAuthorsDto.size(), is(0));
    }

    @Test
    void testDelete() {
        AuthorDto authorDto = authorCreated();
        Author author = authorCreatedEntity();

        Long authorId = authorDto.getId();
        doNothing().when(authorRepository).deleteById(authorId);
        when(authorRepository.findById(authorId)).thenReturn(of(author));

        authorService.delete(authorId);

        verify(authorRepository, times(1)).deleteById(authorId);
        verify(authorRepository, times(1)).findById(authorId);
    }

    @Test
    void testDelete_ExceptionInvalidID() {
        var innvalidAuthorId = 2L;

        when(authorRepository.findById(innvalidAuthorId)).thenReturn(empty());

        assertThrows(AuthorNotFoundException.class, () -> authorService.delete(innvalidAuthorId));
    }
}
