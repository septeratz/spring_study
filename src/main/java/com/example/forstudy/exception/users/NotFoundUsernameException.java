package com.example.forstudy.exception.users;

public class NotFoundUsernameException extends RuntimeException{
    public NotFoundUsernameException(final String message) {
        super(message);
    }
    public NotFoundUsernameException() {
        this("유저를 찾을 수 없습니다.");
    }
}
