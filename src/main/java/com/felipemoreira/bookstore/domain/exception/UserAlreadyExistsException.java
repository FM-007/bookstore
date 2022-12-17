package com.felipemoreira.bookstore.domain.exception;

import javax.persistence.EntityExistsException;

public class UserAlreadyExistsException extends EntityExistsException {

    public UserAlreadyExistsException(String email, String userName) {
        super(String.format("User with email %s or username %s already exists!", email, userName));
    }
}
