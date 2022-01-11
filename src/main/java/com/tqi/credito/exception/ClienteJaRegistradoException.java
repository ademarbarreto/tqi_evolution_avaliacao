package com.tqi.credito.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClienteJaRegistradoException extends  Exception{

    public ClienteJaRegistradoException(String clienteNome) {
        super(String.format("Cliente com nome %s já está registrado no sistema.",clienteNome));
    }
}
