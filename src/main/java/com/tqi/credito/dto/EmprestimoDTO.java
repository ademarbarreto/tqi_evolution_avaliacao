package com.tqi.credito.dto;
import com.tqi.credito.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.JoinColumn;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmprestimoDTO {

    private long idemprestimo;

    private BigDecimal valor;

    @NotNull
    private LocalDate dataprimeiraparcela;

    @Range(min= 1, max= 60)
    private Integer quantidadeparcelas;

    private Long clienteid;

}
