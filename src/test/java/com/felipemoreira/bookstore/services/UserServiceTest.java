package com.felipemoreira.bookstore.services;

import static com.felipemoreira.bookstore.helper.UserHelper.createdUserDto;
import static com.felipemoreira.bookstore.helper.UserHelper.createdUserEntity;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.felipemoreira.bookstore.domain.dto.MessageDto;
import com.felipemoreira.bookstore.domain.dto.UserDto;
import com.felipemoreira.bookstore.domain.exception.UserAlreadyExistsException;
import com.felipemoreira.bookstore.domain.mappper.UserMapper;
import com.felipemoreira.bookstore.entities.User;
import com.felipemoreira.bookstore.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUserCreatedSuccessfully() {
        User user = createdUserEntity();
        UserDto userDto = createdUserDto();
        String expectedCreatedMessage = "User FM with ID 1 successfully created";

        String email = userDto.getEmail();
        String userName = user.getUserName();

        when(userRepository.findByEmailOrUsername(email, userName))
            .thenReturn(empty());
        when(userMapper.toEntity(userDto)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);

        MessageDto userToCreate = userService.create(userDto);

        assertThat(expectedCreatedMessage, is(equalTo(userToCreate.getMessage())));
        assertNotNull(userToCreate);
    }

    @Test
    void testUserCreated_UserAlreadyExistsException() {
        User user = createdUserEntity();
        UserDto userDto = createdUserDto();
        String email = userDto.getEmail();
        String userName = user.getUserName();

        when(userRepository.findByEmailOrUsername(email, userName))
            .thenReturn(of(user));

        assertThrows(UserAlreadyExistsException.class, () -> userService.create(userDto));
    }
}
