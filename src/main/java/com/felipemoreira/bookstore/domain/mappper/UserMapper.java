package com.felipemoreira.bookstore.domain.mappper;

import com.felipemoreira.bookstore.domain.dto.UserDto;
import com.felipemoreira.bookstore.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto userDto);

    UserDto toDto(User user);
}
