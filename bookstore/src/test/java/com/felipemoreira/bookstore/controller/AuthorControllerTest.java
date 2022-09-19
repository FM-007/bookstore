package com.felipemoreira.bookstore.controller;

import com.felipemoreira.bookstore.builder.AuthorDtoBuilder;
import com.felipemoreira.bookstore.services.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {

    @InjectMocks
    private AuthorController authorController;

    @Mock
    private AuthorService authorService;

    @BeforeEach
    void setUp() {
        AuthorDtoBuilder authorDtoBuilder = AuthorDtoBuilder.builder().build();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authorController)
            .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
            .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
            .build();
    }
}
