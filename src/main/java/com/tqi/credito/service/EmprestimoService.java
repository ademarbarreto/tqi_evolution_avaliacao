package com.tqi.credito.service;

import com.tqi.credito.dto.EmprestimoDTO;
import com.tqi.credito.dto.MensagemRespostaDTO;
import com.tqi.credito.entities.Emprestimo;
import com.tqi.credito.exception.DataEmprestimoMaior3MesesException;
import com.tqi.credito.exception.EmprestimoNaoEncontradoException;
import com.tqi.credito.mappers.EmprestimoMapper;
import com.tqi.credito.repositories.EmprestimoRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ToString
@Builder
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmprestimoService {

    private EmprestimoRepository emprestimoRepository;
    private final EmprestimoMapper emprestimoMapper = EmprestimoMapper.INSTANCE;

    public MensagemRespostaDTO cadastrarEmprestimo(EmprestimoDTO emprestimoDTO)throws DataEmprestimoMaior3MesesException {
        Emprestimo emprestimoParaCadastrar = emprestimoMapper.toModel(emprestimoDTO);
        if (!confirmaData3meses(emprestimoParaCadastrar.getDataprimeiraparcela())) {
             throw new DataEmprestimoMaior3MesesException();
        }
        Emprestimo emprestimoCadastrado = emprestimoRepository.save(emprestimoParaCadastrar);
        return criarMetodoResposta(emprestimoCadastrado.getIdemprestimo(), "Emprestimo cadastrado com ID ");
    }

    public List<EmprestimoDTO> listAll() {
        List<Emprestimo> todosEmprestimos = emprestimoRepository.findAll();
        return todosEmprestimos
                .stream()
                .map(emprestimoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MensagemRespostaDTO atualizarEmprestimo(Long id, EmprestimoDTO emprestimoDTO) throws EmprestimoNaoEncontradoException {
        verificaSeExisteEmprestimo(id);
        Emprestimo emprestimoParaAtualizar = emprestimoMapper.toModel(emprestimoDTO);
        Emprestimo emprestimoAtualizado = emprestimoRepository.save(emprestimoParaAtualizar);
        return criarMetodoResposta(emprestimoAtualizado.getIdemprestimo(), "Emprestimo atualizado com ID ");
    }

    public EmprestimoDTO findById(Long id) throws EmprestimoNaoEncontradoException {
        Emprestimo emprestimo = verificaSeExisteEmprestimo(id);
        return emprestimoMapper.toDTO (emprestimo);
    }

    public void delete(Long id) throws EmprestimoNaoEncontradoException {
        verificaSeExisteEmprestimo(id);
        emprestimoRepository.deleteById(id);
    }

    private Emprestimo verificaSeExisteEmprestimo(Long id) throws EmprestimoNaoEncontradoException {
        return emprestimoRepository
                .findById(id)
                .orElseThrow( () -> new EmprestimoNaoEncontradoException(id));
    }

    private MensagemRespostaDTO criarMetodoResposta(Long id, String mensagem) {
        return MensagemRespostaDTO
                .builder()
                .mensagem(mensagem + id)
                .build();
    }

    //Verifica se a data da primeira parcela ultrapassou 3 meses a partir da data de hoje
    private Boolean confirmaData3meses(LocalDate dataPrimeiraParcela){
        LocalDate data3meses = LocalDate.now().plusMonths(3);
        return (dataPrimeiraParcela.isBefore(data3meses));
    }
}
