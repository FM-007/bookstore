package com.felipemoreira.bookstore.controller;

import static com.felipemoreira.bookstore.utils.constants.BookstoreConstants.PUBLISHER_URL;
import static org.springframework.http.HttpStatus.CREATED;

import com.felipemoreira.bookstore.controller.docs.PublisherControllerDocs;
import com.felipemoreira.bookstore.domain.dto.PublisherDto;
import com.felipemoreira.bookstore.services.PublisherService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PUBLISHER_URL)
public class PublisherController implements PublisherControllerDocs {

    @Autowired
    private PublisherService publisherService;

    @PostMapping
    @ResponseStatus(CREATED)
    public PublisherDto create(@RequestBody @Valid PublisherDto publisherDto) {
        return publisherService.create(publisherDto);
    }
}
