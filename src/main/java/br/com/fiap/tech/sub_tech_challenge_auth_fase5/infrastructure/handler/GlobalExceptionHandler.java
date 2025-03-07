package br.com.fiap.tech.sub_tech_challenge_auth_fase5.infrastructure.handler;


import br.com.fiap.tech.sub_tech_challenge_auth_fase5.infrastructure.exceptions.CustomErrorTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomErrorTypeException.class)
    public ResponseEntity<?> handleException(CustomErrorTypeException exception) {

        Map<String, Object> body = new HashMap<>();
        HttpStatus status;


        switch (exception.getMessage()) {
            case "Cliente nao encontrado com esse CPF.":
                status = HttpStatus.NOT_FOUND;
                break;
            case "Cliente com dado CPF ja cadastrado":
                status = HttpStatus.BAD_REQUEST;
                break;
            default:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        body.put("errorType", status.value());
        body.put("message", exception.getMessage());

        return new ResponseEntity<>(body, status);

    }

    }
