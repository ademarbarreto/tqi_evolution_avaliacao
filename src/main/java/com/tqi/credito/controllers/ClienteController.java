package com.tqi.credito.controllers;

import com.tqi.credito.dto.ClienteDTO;
import com.tqi.credito.dto.MensagemRespostaDTO;
import com.tqi.credito.exception.ClienteNaoEncontradoException;
import com.tqi.credito.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/credito/v1/clientes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {

    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemRespostaDTO cadastrarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        return clienteService.cadastrarCliente(clienteDTO);
    }

    @GetMapping
    public List<ClienteDTO> listAll() {
        return clienteService.listAll();
    }

    @GetMapping("/{id}")
    public ClienteDTO findById(@PathVariable Long id) throws ClienteNaoEncontradoException {
        return clienteService.findById(id);
    }

    @GetMapping("/emprestimos/{id}")
    public List findByIdEmprestimos(@PathVariable Long id) throws ClienteNaoEncontradoException {
        return clienteService.findByIdEmprestimos(id);
    }

    @GetMapping("/detalhe/emprestimos/{id}")
    public List findByIdDetalheEmprestimos(@PathVariable Long id) throws ClienteNaoEncontradoException {
        return clienteService.findByIdDetalheEmprestimos(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ClienteNaoEncontradoException {
        clienteService.delete(id);
    }

    @PutMapping("/{id}")
    public MensagemRespostaDTO atualizaCliente(@PathVariable Long id, @RequestBody @Valid ClienteDTO clienteDTO) throws ClienteNaoEncontradoException {
        return clienteService.atualizarCliente(id,clienteDTO);
    }

}
