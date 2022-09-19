package com.felipemoreira.bookstore.builder;

import com.felipemoreira.bookstore.domain.dto.AuthorDto;
import lombok.Builder;

@Builder
public class AuthorDtoBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String name = "Felipe Moreira";

    @Builder.Default
    private final Integer age = 31;

    public AuthorDto buildAuthorDto() {
        return new AuthorDto(id, name, age);
    }
}
