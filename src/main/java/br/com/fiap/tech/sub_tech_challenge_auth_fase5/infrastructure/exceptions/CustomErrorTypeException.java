package br.com.fiap.tech.sub_tech_challenge_auth_fase5.infrastructure.exceptions;

public class CustomErrorTypeException extends RuntimeException{

    public CustomErrorTypeException (String msg) {
        super(msg);
    }
}
