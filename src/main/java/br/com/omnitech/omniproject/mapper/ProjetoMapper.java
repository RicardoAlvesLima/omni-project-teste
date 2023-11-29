package br.com.omnitech.omniproject.mapper;

import br.com.omnitech.omniproject.controller.dto.ProjetoDto;
import br.com.omnitech.omniproject.model.Projeto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {PessoaMapper.class}
)
public interface ProjetoMapper {

    Projeto toEntity(ProjetoDto dto);

    ProjetoDto toDto(Projeto entity);
    List<ProjetoDto> toDtoList(List<Projeto> entities);
}
