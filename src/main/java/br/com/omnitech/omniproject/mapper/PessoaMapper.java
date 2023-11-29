package br.com.omnitech.omniproject.mapper;

import br.com.omnitech.omniproject.controller.dto.PessoaDto;
import br.com.omnitech.omniproject.model.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface PessoaMapper {

    Pessoa toEntity(PessoaDto dto);

    PessoaDto toDto(Pessoa entity);

    List<PessoaDto> toDtoList(List<Pessoa> entities);
}
