package com.felipemoreira.bookstore.domain.mappper;

import com.felipemoreira.bookstore.domain.dto.UserDto;
import com.felipemoreira.bookstore.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto userDto);

    UserDto toDto(User user);
}
