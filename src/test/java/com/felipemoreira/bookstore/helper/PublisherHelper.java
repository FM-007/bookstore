package com.felipemoreira.bookstore.helper;

import com.felipemoreira.bookstore.domain.dto.PublisherDto;
import java.time.LocalDate;

public class PublisherHelper {

    public static PublisherDto createPublisher() {
        PublisherDto publisherDto = new PublisherDto();
        publisherDto.setId(1L);
        publisherDto.setName("Editora FM");
        publisherDto.setCode("FM1234");
        LocalDate date = LocalDate.of(2020, 6, 16);
        publisherDto.setFoundationDate(date);

        return publisherDto;
    }
}
