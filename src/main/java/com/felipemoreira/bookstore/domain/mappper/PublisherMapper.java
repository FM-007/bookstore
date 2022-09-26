package com.felipemoreira.bookstore.domain.mappper;

import com.felipemoreira.bookstore.domain.dto.PublisherDto;
import com.felipemoreira.bookstore.entities.Publisher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    Publisher toEntity(PublisherDto publisherDto);

    PublisherDto toDto(Publisher publisher);
}
