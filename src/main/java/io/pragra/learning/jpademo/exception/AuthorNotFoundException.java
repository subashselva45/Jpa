package io.pragra.learning.jpademo.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String s) {
        super(s);
    }
}
