package com.felipemoreira.bookstore.services;

import static java.util.stream.Collectors.toList;

import com.felipemoreira.bookstore.domain.dto.AuthorDto;
import com.felipemoreira.bookstore.domain.exception.AuthorAlreadyExistsException;
import com.felipemoreira.bookstore.domain.exception.AuthorNotFoundException;
import com.felipemoreira.bookstore.domain.mappper.AuthorMapper;
import com.felipemoreira.bookstore.entities.Author;
import com.felipemoreira.bookstore.repositories.AuthorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired(required=true)
    private AuthorMapper authorMapper;

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorDto create(AuthorDto authorDto) {
        verifyIfExists(authorDto.getName());

        Author authorToCreate = authorMapper.toEntity(authorDto);
        Author createdAuthor = authorRepository.save(authorToCreate);

        return authorMapper.toDto(createdAuthor);
    }

    public AuthorDto findById(Long id) {
        Author foundAuthor = authorRepository.findById(id)
            .orElseThrow(() -> new AuthorNotFoundException(id));

        return authorMapper.toDto(foundAuthor);
    }

    public List<AuthorDto> findAll() {
        return authorRepository.findAll()
            .stream()
            .map(authorMapper::toDto)
            .collect(toList());
    }

    private void verifyIfExists(String authorName) {
        authorRepository.findByName(authorName)
            .ifPresent(author -> {
                throw new AuthorAlreadyExistsException(author.getName());
            });
    }
}
