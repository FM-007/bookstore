package com.felipemoreira.bookstore.controller.docs;

import com.felipemoreira.bookstore.domain.dto.AuthorDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

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

    @ApiOperation(value = "List all registered author")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Return all registered author")
    })
    public List<AuthorDto> findAll();

    @ApiOperation(value = "Delete author by id operation")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Success author deleted"),
        @ApiResponse(code = 404, message = "Author not found error code")
    })
    void delete(@PathVariable Long id);
}
