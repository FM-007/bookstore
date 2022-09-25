package com.felipemoreira.bookstore.utils;

import com.felipemoreira.bookstore.domain.dto.AuthorDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Authors Management")
public interface AuthorsControllerDocs {

    @ApiOperation(value = "Author creation operation")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success author creation"),
        @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or author already registered on system")
    })
    AuthorDto create(AuthorDto authorDto);

    @ApiOperation(value = "Find author by id operation")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success author found"),
        @ApiResponse(code = 404, message = "Author not found error code")
    })
    public AuthorDto findById(Long id);
}
