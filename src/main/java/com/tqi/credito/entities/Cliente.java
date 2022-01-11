package com.tqi.credito.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tb_cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    @NotNull(message = "É necessário informar o nome no cadastramento")
    private String nome;

    @Column(nullable = false, unique = true)
    @NotNull(message = "É necessário informar o email no cadastramento")
    private String email;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String rg;

    @Column(nullable = false)
    @NotNull(message = "É necessário informar o endereço no cadastramento")
    private String endereco;

    @Column(nullable = false)
    @NotNull(message = "É necessário informar a renda no cadastramento")
    private Float renda;

    @Column(nullable = false)
    private String senha;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="clienteid")
    private List<Emprestimo> emprestimos;
}
