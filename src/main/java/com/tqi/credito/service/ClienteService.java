package com.tqi.credito.service;

import com.tqi.credito.dto.ClienteDTO;
import com.tqi.credito.dto.MensagemRespostaDTO;
import com.tqi.credito.entities.Cliente;
import com.tqi.credito.entities.Emprestimo;
import com.tqi.credito.entities.EmprestimoCompleto;
import com.tqi.credito.exception.ClienteNaoEncontradoException;
import com.tqi.credito.mappers.ClienteMapper;
import com.tqi.credito.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ToString
@Builder
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {

    private ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;

    public MensagemRespostaDTO cadastrarCliente(ClienteDTO clienteDTO) {
        Cliente clienteParaCadastrar = clienteMapper.toModel(clienteDTO);
        Cliente clienteCadastrado = clienteRepository.save(clienteParaCadastrar);
        return criarMetodoResposta(clienteCadastrado.getId(), "Cliente cadastrado com ID ");
    }


    public List<ClienteDTO> listAll() {
        List<Cliente> todosClientes = clienteRepository.findAll();
        return todosClientes
                .stream()
                .map(clienteMapper::toDTO)
                .collect(Collectors.toList());
    }


    public ClienteDTO findById(Long id) throws ClienteNaoEncontradoException {
        Cliente cliente = verificaSeExisteCliente(id);
        return clienteMapper.toDTO(cliente);
    }

    public List findByIdEmprestimos(Long id) throws ClienteNaoEncontradoException {
        Cliente cliente = verificaSeExisteCliente(id);
        ClienteDTO clienteDTO = clienteMapper.toDTO(cliente);
        return clienteDTO.getEmprestimos();
    }

    public List findByIdDetalheEmprestimos(Long id) throws ClienteNaoEncontradoException {
        Cliente cliente = verificaSeExisteCliente(id);
        ClienteDTO clienteDTO = clienteMapper.toDTO(cliente);
        return clienteDTO.getEmprestimos();

     }


    public void delete(Long id) throws ClienteNaoEncontradoException {
        verificaSeExisteCliente(id);
        clienteRepository.deleteById(id);
    }


    public MensagemRespostaDTO atualizarCliente(Long id, ClienteDTO clienteDTO) throws ClienteNaoEncontradoException {
        verificaSeExisteCliente(id);
        Cliente clienteParaAtualizar = clienteMapper.toModel(clienteDTO);
        Cliente clienteAtualizado = clienteRepository.save(clienteParaAtualizar);
        return criarMetodoResposta(clienteAtualizado.getId(), "Cliente atualizado com ID ");
    }


    private Cliente verificaSeExisteCliente(Long id) throws ClienteNaoEncontradoException {
        return clienteRepository
                .findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException(id));
    }


    private MensagemRespostaDTO criarMetodoResposta(Long id, String mensagem) {
        return MensagemRespostaDTO
                .builder()
                .mensagem(mensagem + id)
                .build();
    }



}