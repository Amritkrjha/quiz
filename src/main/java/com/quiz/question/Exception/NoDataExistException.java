package com.quiz.question.Exception;

public class NoDataExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoDataExistException() {
        super();

    }

    public NoDataExistException(String message) {
        super(message);

    }

}
