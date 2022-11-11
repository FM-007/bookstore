package com.felipemoreira.bookstore.utils;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.felipemoreira.bookstore.domain.dto.AuthorDto;

public class JsonConversionUtils {

    public static String asJsonString(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(WRITE_DATES_AS_TIMESTAMPS, false);
            mapper.registerModules(new JavaTimeModule());

            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
