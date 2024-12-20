package org.example.javacourse.error;


import org.example.javacourse.exception.QuestionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(QuestionNotFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    public ErrorResponse handleQuestionNotFound(QuestionNotFoundException questionNotFoundException) {
        return ErrorResponse.builder()
                .message(questionNotFoundException.getMessage())
                .statusCode(404)
                .build();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleInternalServerError(RuntimeException runtimeException) {
        return ErrorResponse.builder()
                .message("Bilinmeyen xeta bash verdi: " + runtimeException.getMessage())
                .build();
    }
}
