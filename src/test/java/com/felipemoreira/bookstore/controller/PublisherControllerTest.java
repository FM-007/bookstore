package com.felipemoreira.bookstore.controller;

import static com.felipemoreira.bookstore.helper.PublisherHelper.createPublisherDto;
import static com.felipemoreira.bookstore.utils.JsonConversionUtils.asJsonString;
import static com.felipemoreira.bookstore.utils.constants.BookstoreConstants.PUBLISHER_URL;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.felipemoreira.bookstore.domain.dto.PublisherDto;
import com.felipemoreira.bookstore.services.PublisherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@ExtendWith(MockitoExtension.class)
public class PublisherControllerTest {

    @InjectMocks
    private PublisherController publisherController;

    @Mock
    private PublisherService publisherService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(publisherController)
            .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
            .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
            .build();
    }

    @Test
    void testPublisherController_CreatedSuccessfully() throws Exception {
        PublisherDto publisherDto = createPublisherDto();

        when(publisherService.create(publisherDto)).thenReturn(publisherDto);

        mockMvc
            .perform(post(PUBLISHER_URL)
                .contentType(APPLICATION_JSON)
                .content(asJsonString(publisherDto)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id", is(publisherDto.getId().intValue())))
            .andExpect(jsonPath("$.name", is(publisherDto.getName())))
            .andExpect(jsonPath("$.code", is(publisherDto.getCode())));
    }

    @Test
    void testPublisherController_ExceptionBadRequest() throws Exception {
        PublisherDto publisherDto = createPublisherDto();
        publisherDto.setName(null);

        mockMvc
            .perform(post(PUBLISHER_URL)
                .contentType(APPLICATION_JSON)
                .content(asJsonString(publisherDto)))
            .andExpect(status().isBadRequest());
    }

    @Test
    void testPublisherControllerFindById() throws Exception {
        PublisherDto publisherDto = createPublisherDto();

        when(publisherService.findById(publisherDto.getId())).thenReturn(publisherDto);

        mockMvc
            .perform(get(PUBLISHER_URL + "/" + publisherDto.getId())
                .contentType(APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(publisherDto.getId().intValue())))
            .andExpect(jsonPath("$.name", is(publisherDto.getName())))
            .andExpect(jsonPath("$.code", is(publisherDto.getCode())));
    }
}
