package com.quiz.question.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 7294042352025580099L;

    public BadRequestException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BadRequestException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

}
