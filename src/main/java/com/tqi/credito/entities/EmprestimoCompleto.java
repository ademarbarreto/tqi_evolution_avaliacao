package com.tqi.credito.entities;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmprestimoCompleto {
    private Long idemprestimo;
    private BigDecimal valor;
    private LocalDate dataprimeiraparcela;
    private Integer quantidadeparcelas;
    private String email;
    private float renda;
    private Long clienteid;
}
