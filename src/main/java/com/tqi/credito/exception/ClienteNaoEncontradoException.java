package com.tqi.credito.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradoException extends Exception {
    public ClienteNaoEncontradoException(Long id) {
        super("Cliente não encontrado com ID " + id);
    }
}
