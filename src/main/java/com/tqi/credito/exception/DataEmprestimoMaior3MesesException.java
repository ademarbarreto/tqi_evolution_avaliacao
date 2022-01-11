package com.tqi.credito.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataEmprestimoMaior3MesesException extends  Exception {

    public DataEmprestimoMaior3MesesException() {
        super(String.format("Cliente informou data maior que 3 meses"));
    }
}
