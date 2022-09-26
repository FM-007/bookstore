package com.felipemoreira.bookstore.services;

import com.felipemoreira.bookstore.domain.mappper.PublisherMapper;
import com.felipemoreira.bookstore.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private PublisherMapper publisherMapper;
}
