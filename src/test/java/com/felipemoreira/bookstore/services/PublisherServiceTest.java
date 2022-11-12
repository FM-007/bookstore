package com.felipemoreira.bookstore.services;

import static com.felipemoreira.bookstore.helper.PublisherHelper.createPublisher;
import static com.felipemoreira.bookstore.helper.PublisherHelper.createPublisherDto;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.felipemoreira.bookstore.domain.dto.PublisherDto;
import com.felipemoreira.bookstore.domain.exception.PublisherAlreadyExistsException;
import com.felipemoreira.bookstore.domain.exception.PublisherNotFoundException;
import com.felipemoreira.bookstore.domain.mappper.PublisherMapper;
import com.felipemoreira.bookstore.entities.Publisher;
import com.felipemoreira.bookstore.repositories.PublisherRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    private PublisherRepository publisherRepository;

    @Mock
    private PublisherMapper publisherMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPublisherCreated_Successfully() {
        PublisherDto publisherDto = createPublisherDto();
        Publisher publisher = createPublisher();

        when(publisherRepository.findByNameOrCode(publisherDto.getName(), publisherDto.getCode()))
            .thenReturn(Optional.empty());
        when(publisherMapper.toEntity(publisherDto)).thenReturn(publisher);
        when(publisherRepository.save(publisher)).thenReturn(publisher);
        when(publisherMapper.toDto(publisher)).thenReturn(publisherDto);

        PublisherDto createPublisher = publisherService.create(publisherDto);

        assertThat(createPublisher, is(equalTo(publisherDto)));
    }

    @Test
    void testPublisherCreated_AlreadyExistsException() {
        PublisherDto publisherDto = createPublisherDto();
        Publisher publisher = createPublisher();

        when(publisherRepository.findByNameOrCode(publisherDto.getName(), publisherDto.getCode()))
            .thenReturn(of(publisher));

        assertThrows(PublisherAlreadyExistsException.class, () -> publisherService.create(publisherDto));
    }

    @Test
    void testPublisherFindById_Successfully() {
        Publisher publisher = createPublisher();
        PublisherDto publisherDto = createPublisherDto();

        when(publisherRepository.findById(publisherDto.getId())).thenReturn(of(publisher));
        when(publisherMapper.toDto(publisher)).thenReturn(publisherDto);

        PublisherDto findPublisherDto = publisherService.findById(publisherDto.getId());

        assertThat(findPublisherDto, is(equalTo(publisherDto)));
    }

    @Test
    void testPublisherFindById_NotFound() {
        PublisherDto publisherDto = createPublisherDto();

        when(publisherRepository.findById(publisherDto.getId())).thenReturn(empty());

        assertThrows(PublisherNotFoundException.class, () -> publisherService.findById(publisherDto.getId()));
    }

    @Test
    void testPublisherFindAll() {
        Publisher publisher = createPublisher();
        PublisherDto publisherDto = createPublisherDto();

        when(publisherRepository.findAll()).thenReturn(Collections.singletonList(publisher));
        when(publisherMapper.toDto(publisher)).thenReturn(publisherDto);

        List<PublisherDto> foundPublisherDto = publisherService.findAll();

        assertThat(foundPublisherDto.size(), is(1));
        assertThat(foundPublisherDto.get(0), is(equalTo(publisherDto)));
    }

    @Test
    void testPublisherFindAll_EmptyList() {

        when(publisherRepository.findAll()).thenReturn(Collections.emptyList());

        List<PublisherDto> foundPublisherDto = publisherService.findAll();

        assertThat(foundPublisherDto.size(), is(0));
    }
}
