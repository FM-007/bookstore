package com.felipemoreira.bookstore.domain.mappper;

import com.felipemoreira.bookstore.domain.dto.AuthorDto;
import com.felipemoreira.bookstore.entities.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toEntity(AuthorDto authorDto);

    AuthorDto toDto(Author author);
}
