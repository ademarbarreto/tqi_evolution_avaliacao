package com.tqi.credito.dto;

import com.tqi.credito.entities.Emprestimo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String nome;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String rg;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String endereco;

    private BigDecimal renda;

    @NotEmpty
    private String senha;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="clienteid")
    private List<Emprestimo> emprestimos;


}
