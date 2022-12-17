package com.felipemoreira.bookstore.controller;

import static com.felipemoreira.bookstore.utils.constants.BookstoreConstants.USER_URL;
import static org.springframework.http.HttpStatus.CREATED;

import com.felipemoreira.bookstore.controller.docs.UserControllerDocs;
import com.felipemoreira.bookstore.domain.dto.MessageDto;
import com.felipemoreira.bookstore.domain.dto.UserDto;
import com.felipemoreira.bookstore.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(USER_URL)
public class UserController implements UserControllerDocs {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public MessageDto create(@RequestBody @Valid UserDto userToCreateDto) {
        return userService.create(userToCreateDto);
    }
}
