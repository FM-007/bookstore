package com.felipemoreira.bookstore.services;

import com.felipemoreira.bookstore.domain.dto.UserDto;
import com.felipemoreira.bookstore.domain.mappper.UserMapper;
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

    public UserDto create(UserDto userDto) {
        return null;
    }
}
