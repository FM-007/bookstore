package com.felipemoreira.bookstore.helper;

import com.felipemoreira.bookstore.domain.dto.UserDto;
import com.felipemoreira.bookstore.domain.enums.Gender;
import com.felipemoreira.bookstore.entities.User;
import java.time.LocalDate;

public class UserHelper {

    public static User createdUserEntity() {
        User user = new User();

        user.setId(1L);
        user.setName("Felipe Moreira");
        user.setAge(32);
        user.setGender(Gender.MALE);
        user.setEmail("felipe@test.com");
        user.setUserName("FM");
        user.setPassword("123456");
        LocalDate date = LocalDate.of(1991, 01, 16);
        user.setBirthdate(date);

        return user;
    }

    public static UserDto createdUserDto() {
        UserDto userDto = new UserDto();

        userDto.setId(1L);
        userDto.setName("Felipe Moreira");
        userDto.setAge(32);
        userDto.setGender(Gender.MALE);
        userDto.setEmail("felipe@test.com");
        userDto.setUsername("FM");
        userDto.setPassword("123456");
        LocalDate date = LocalDate.of(1991, 1, 16);
        userDto.setBirthdate(date);

        return userDto;
    }
}
