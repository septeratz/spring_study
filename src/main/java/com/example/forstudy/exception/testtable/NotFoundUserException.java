package com.example.forstudy.exception.testtable;

public class NotFoundUserException extends RuntimeException{
    public NotFoundUserException(final String message) {
        super(message);
    }
    public NotFoundUserException(){
        this("사용자를 찾을 수 없습니다.");
    }
}
