package com.tqi.credito.controllers;

import com.tqi.credito.dto.EmprestimoDTO;
import com.tqi.credito.dto.MensagemRespostaDTO;
import com.tqi.credito.exception.DataEmprestimoMaior3MesesException;
import com.tqi.credito.exception.EmprestimoNaoEncontradoException;
import com.tqi.credito.service.EmprestimoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/credito/v1/emprestimos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmprestimoController {

    private EmprestimoService emprestimoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemRespostaDTO cadastrarEmprestimo (@RequestBody @Valid EmprestimoDTO emprestimoDTO) throws DataEmprestimoMaior3MesesException {
        return emprestimoService.cadastrarEmprestimo(emprestimoDTO);
    }

    @GetMapping
    public List<EmprestimoDTO> listAll() {

        return emprestimoService.listAll();
    }

    @GetMapping("/{id}")
    public EmprestimoDTO findById(@PathVariable Long id) throws EmprestimoNaoEncontradoException {
        return emprestimoService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws EmprestimoNaoEncontradoException {
        emprestimoService.delete(id);
    }

    @PutMapping("/{id}")
    public MensagemRespostaDTO atualizarEmprestimo(@PathVariable Long id, @RequestBody @Valid EmprestimoDTO emprestimoDTO) throws EmprestimoNaoEncontradoException {
        return emprestimoService.atualizarEmprestimo(id,emprestimoDTO);
    }

}
