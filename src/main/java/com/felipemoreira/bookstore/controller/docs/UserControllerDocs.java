package com.felipemoreira.bookstore.controller.docs;

import com.felipemoreira.bookstore.domain.dto.MessageDto;
import com.felipemoreira.bookstore.domain.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("System users management")
public interface UserControllerDocs {

    @ApiOperation(value = "User creation operation")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success user creation"),
        @ApiResponse(code = 400, message = "Missing required field, or on validation field rules")
    })
    MessageDto create(UserDto userToCreateDto);
}
