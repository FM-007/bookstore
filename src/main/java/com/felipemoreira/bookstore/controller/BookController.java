package com.felipemoreira.bookstore.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @ApiOperation(value = "Return Books")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success method return")
    })
    @GetMapping
    public String hello() {
        return "Hello Word, with Heroku !!!";
    }
}
