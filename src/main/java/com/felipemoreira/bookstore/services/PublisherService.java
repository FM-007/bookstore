package com.felipemoreira.bookstore.services;

import com.felipemoreira.bookstore.domain.dto.PublisherDto;
import com.felipemoreira.bookstore.domain.exception.PublisherAlreadyExistsException;
import com.felipemoreira.bookstore.domain.exception.PublisherNotFoundException;
import com.felipemoreira.bookstore.domain.mappper.PublisherMapper;
import com.felipemoreira.bookstore.entities.Publisher;
import com.felipemoreira.bookstore.repositories.PublisherRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private PublisherMapper publisherMapper;

    public PublisherDto create(PublisherDto publisherDto) {
        verifyIfExistsPublisherByNameOrCode(publisherDto.getName(), publisherDto.getCode());

        Publisher publisherToCreate = publisherMapper.toEntity(publisherDto);
        Publisher publisher = publisherRepository.save(publisherToCreate);

        return publisherMapper.toDto(publisher);
    }

    public PublisherDto findById(Long id) {
        return publisherRepository.findById(id)
            .map(publisherMapper::toDto)
            .orElseThrow(() -> new PublisherNotFoundException(id));
    }

    private void verifyIfExistsPublisherByNameOrCode(String name, String code) {
        Optional<Publisher> duplicatedPublisher = publisherRepository.findByNameOrCode(name, code);
        if (duplicatedPublisher.isPresent()) {
            throw new PublisherAlreadyExistsException(name, code);
        }
    }
}
