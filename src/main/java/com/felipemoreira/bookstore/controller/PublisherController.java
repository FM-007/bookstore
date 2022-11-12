package com.felipemoreira.bookstore.controller;

import static com.felipemoreira.bookstore.utils.constants.BookstoreConstants.PUBLISHER_URL;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.felipemoreira.bookstore.controller.docs.PublisherControllerDocs;
import com.felipemoreira.bookstore.domain.dto.PublisherDto;
import com.felipemoreira.bookstore.services.PublisherService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public PublisherDto findById(@PathVariable Long id) {
        return publisherService.findById(id);
    }

    @GetMapping
    public List<PublisherDto> findAll() {
        return publisherService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id) {
        publisherService.delete(id);
    }
}
