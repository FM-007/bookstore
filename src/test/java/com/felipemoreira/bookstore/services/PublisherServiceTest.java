package com.felipemoreira.bookstore.services;

import com.felipemoreira.bookstore.domain.mappper.PublisherMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PublisherServiceTest {

    @InjectMocks
    private PublisherService publisherService;

    @Mock
    private PublisherMapper publisherMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}
