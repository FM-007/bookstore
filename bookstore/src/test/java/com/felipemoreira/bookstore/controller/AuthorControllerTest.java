package com.felipemoreira.bookstore.controller;

import static com.felipemoreira.bookstore.helper.AuthorHelper.authorCreated;
import static com.felipemoreira.bookstore.utils.JsonConversionUtils.asJsonString;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.felipemoreira.bookstore.domain.dto.AuthorDto;
import com.felipemoreira.bookstore.services.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {

    @InjectMocks
    private AuthorController authorController;

    @Mock
    private AuthorService authorService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authorController)
            .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
            .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
            .build();
    }

    @Test
    public void testAuthorControllerStatusCreated() throws Exception {
        AuthorDto authorDto = authorCreated();

        when(authorService.create(authorDto)).thenReturn(authorDto);

        mockMvc
            .perform(MockMvcRequestBuilders.post("/api/v1/authors")
            .contentType(APPLICATION_JSON)
            .content(asJsonString(authorDto)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id", is(authorDto.getId().intValue())))
            .andExpect(jsonPath("$.name", is(authorDto.getName())))
            .andExpect(jsonPath("$.age", is(authorDto.getAge())));
    }

    @Test
    public void testAuthorControllerStatusCreated_BadRequest() throws Exception {
        AuthorDto authorDto = authorCreated();
        authorDto.setName(null);

        mockMvc
            .perform(MockMvcRequestBuilders.post("/api/v1/authors")
            .contentType(APPLICATION_JSON)
            .content(asJsonString(authorDto)))
            .andExpect(status().isBadRequest());
    }
}
