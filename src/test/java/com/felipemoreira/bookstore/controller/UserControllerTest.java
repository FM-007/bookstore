package com.felipemoreira.bookstore.controller;

import static com.felipemoreira.bookstore.helper.UserHelper.createdUserDto;
import static com.felipemoreira.bookstore.utils.JsonConversionUtils.asJsonString;
import static com.felipemoreira.bookstore.utils.constants.BookstoreConstants.USER_URL;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.felipemoreira.bookstore.domain.dto.MessageDto;
import com.felipemoreira.bookstore.domain.dto.UserDto;
import com.felipemoreira.bookstore.services.UserService;
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
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
            .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
            .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
            .build();
    }

    @Test
    void testUserController_CreatedSuccessfully() throws Exception {
        UserDto userDto = createdUserDto();
        String message = "User FM with ID 1 successfully created";
        MessageDto messageDto = MessageDto.builder().message(message).build();

        when(userService.create(userDto)).thenReturn(messageDto);

        mockMvc
            .perform(post(USER_URL)
                .contentType(APPLICATION_JSON)
                .content(asJsonString(userDto)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.message", is(message)));
    }

    @Test
    void testUserController_BadRequest() throws Exception {
        UserDto userDto = createdUserDto();
        userDto.setUsername(null);

        mockMvc
            .perform(post(USER_URL)
                .contentType(APPLICATION_JSON)
                .content(asJsonString(userDto)))
            .andExpect(status().isBadRequest());
    }
}
