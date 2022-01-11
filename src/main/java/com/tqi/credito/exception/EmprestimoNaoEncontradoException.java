package com.tqi.credito.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmprestimoNaoEncontradoException extends Exception {
    public EmprestimoNaoEncontradoException(Long id) {
        super("Emprestimo não encontrado com ID " + id);
    }
}
