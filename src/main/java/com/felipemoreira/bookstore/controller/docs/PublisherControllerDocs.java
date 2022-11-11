package com.felipemoreira.bookstore.controller.docs;

import com.felipemoreira.bookstore.domain.dto.PublisherDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Publisher Management")
public interface PublisherControllerDocs {

    @ApiOperation(value = "Publisher creation operation")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Success publisher creation"),
        @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or publisher already registered on system")
    })
    PublisherDto create(PublisherDto publisherDto);
}
