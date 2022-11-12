package com.felipemoreira.bookstore.services;

import static java.util.stream.Collectors.toList;

import com.felipemoreira.bookstore.domain.dto.PublisherDto;
import com.felipemoreira.bookstore.domain.exception.PublisherAlreadyExistsException;
import com.felipemoreira.bookstore.domain.exception.PublisherNotFoundException;
import com.felipemoreira.bookstore.domain.mappper.PublisherMapper;
import com.felipemoreira.bookstore.entities.Publisher;
import com.felipemoreira.bookstore.repositories.PublisherRepository;
import java.util.List;
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

    public List<PublisherDto> findAll() {
        return publisherRepository.findAll()
            .stream()
            .map(publisherMapper::toDto)
            .collect(toList());
    }

    public void delete(Long id) {
        verifyIfExists(id);
        publisherRepository.deleteById(id);
    }

    private void verifyIfExistsPublisherByNameOrCode(String name, String code) {
        Optional<Publisher> duplicatedPublisher = publisherRepository.findByNameOrCode(name, code);
        if (duplicatedPublisher.isPresent()) {
            throw new PublisherAlreadyExistsException(name, code);
        }
    }

    private void verifyIfExists(Long id) {
        publisherRepository.findById(id)
            .orElseThrow(() -> new PublisherNotFoundException(id));
    }
}
