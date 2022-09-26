package com.felipemoreira.bookstore.controller;

import static com.felipemoreira.bookstore.utils.constants.BookstoreConstants.PUBLISHER_URL;

import com.felipemoreira.bookstore.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PUBLISHER_URL)
public class PublisherController {

    @Autowired
    private PublisherService publisherService;
}
