package br.com.omnitech.omniproject.controller.dto;

import br.com.omnitech.omniproject.enums.ProjetoRiscoEnum;
import br.com.omnitech.omniproject.enums.ProjetoStatusEnum;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class ProjetoDto {

    private Long id;

    private String nome;

    private LocalDate dataInicio;

    private LocalDate dataPrevisaoFim;

    private LocalDate dataFim;

    private String descricao;

    private ProjetoStatusEnum status;

    private Double orcamento;

    private ProjetoRiscoEnum risco;

    private Long idgerente;

    private Set<PessoaDto> pessoas = new HashSet<>();
}
