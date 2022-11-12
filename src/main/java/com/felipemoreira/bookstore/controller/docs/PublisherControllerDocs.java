package com.felipemoreira.bookstore.controller.docs;

import com.felipemoreira.bookstore.domain.dto.PublisherDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Api("Publisher Management")
public interface PublisherControllerDocs {

    @ApiOperation(value = "Publisher creation operation")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success publisher creation"),
        @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or publisher already registered on system")
    })
    PublisherDto create(PublisherDto publisherDto);

    @ApiOperation(value = "Find publisher by id operation")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success publisher found"),
        @ApiResponse(code = 404, message = "Publisher not found error!")
    })
    PublisherDto findById(Long id);

    @ApiOperation(value = "List all registered publishers")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Return all registered publishers")
    })
    List<PublisherDto> findAll();

    @ApiOperation(value = "Delete publisher by id operation")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Success publisher deleted"),
        @ApiResponse(code = 404, message = "Publisher not found error!")
    })
    void delete(Long id);
}
