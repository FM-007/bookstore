package com.felipemoreira.bookstore.helper;

import com.felipemoreira.bookstore.domain.dto.PublisherDto;
import com.felipemoreira.bookstore.entities.Publisher;
import java.time.LocalDate;

public class PublisherHelper {

    public static Publisher createPublisher() {
        Publisher publisher = new Publisher();
        publisher.setId(1L);
        publisher.setName("Editora FM");
        publisher.setCode("FM1234");
        LocalDate date = LocalDate.of(2020, 6, 16);
        publisher.setFoundationDate(date);

        return publisher;
    }

    public static PublisherDto createPublisherDto() {
        PublisherDto publisherDto = new PublisherDto();
        publisherDto.setId(1L);
        publisherDto.setName("Editora FM");
        publisherDto.setCode("FM1234");
        LocalDate date = LocalDate.of(2020, 6, 16);
        publisherDto.setFoundationDate(date);

        return publisherDto;
    }
}
