package com.felipemoreira.bookstore.services;

import com.felipemoreira.bookstore.domain.dto.MessageDto;
import com.felipemoreira.bookstore.domain.dto.UserDto;
import com.felipemoreira.bookstore.domain.exception.UserAlreadyExistsException;
import com.felipemoreira.bookstore.domain.mappper.UserMapper;
import com.felipemoreira.bookstore.entities.User;
import com.felipemoreira.bookstore.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository,
        UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public MessageDto create(UserDto userToCreateDto) {

        verifyIfExists(userToCreateDto.getEmail(), userToCreateDto.getUsername());

        User userToCreate = userMapper.toEntity(userToCreateDto);
        User createdUser = userRepository.save(userToCreate);

        return creationMessage(createdUser);
    }

    private void verifyIfExists(String email, String userName) {
        Optional<User> foundUser = userRepository.findByEmailOrUsername(email, userName);
        if (foundUser.isPresent()) {
            throw new UserAlreadyExistsException(email, userName);
        }
    }

    private MessageDto creationMessage(User createdUser) {
        String userName = createdUser.getUsername();
        Long createdUserId = createdUser.getId();
        String createdUserMessage = String.format("User %s with ID %s successfully created",
            userName, createdUserId);

        return MessageDto.builder()
            .message(createdUserMessage)
            .build();
    }
}
