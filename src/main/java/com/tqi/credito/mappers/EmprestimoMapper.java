package com.tqi.credito.mappers;

import com.tqi.credito.dto.EmprestimoDTO;
import com.tqi.credito.entities.Emprestimo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmprestimoMapper {

       EmprestimoMapper INSTANCE = Mappers.getMapper(EmprestimoMapper.class);

       @Mapping(source = "dataprimeiraparcela", target = "dataprimeiraparcela", dateFormat = "dd-MM-yyyy")
       Emprestimo toModel(EmprestimoDTO emprestimoDTO);

       EmprestimoDTO toDTO(Emprestimo emprestimo);

}
