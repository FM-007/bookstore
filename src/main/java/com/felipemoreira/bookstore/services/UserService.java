package com.felipemoreira.bookstore.services;

import com.felipemoreira.bookstore.domain.dto.MessageDto;
import com.felipemoreira.bookstore.domain.dto.UserDto;
import com.felipemoreira.bookstore.domain.mappper.UserMapper;
import com.felipemoreira.bookstore.entities.User;
import com.felipemoreira.bookstore.repositories.UserRepository;
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
        User userToCreate = userMapper.toEntity(userToCreateDto);
        User createdUser = userRepository.save(userToCreate);

        return creationMessage(createdUser);
    }

    private MessageDto creationMessage(User createdUser) {
        String userName = createdUser.getName();
        Long createdUserId = createdUser.getId();
        String createdUserMessage = String.format("User %s with ID %s successfully created",
            userName, createdUserId);

        return MessageDto.builder()
            .message(createdUserMessage)
            .build();
    }
}
