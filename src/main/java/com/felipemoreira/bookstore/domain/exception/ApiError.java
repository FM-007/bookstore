package com.felipemoreira.bookstore.domain.exception;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    private int code;

    private String status;

    @JsonFormat(shape = STRING, pattern = "dd-mm-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private String message;

    private List<String> errors;
}
