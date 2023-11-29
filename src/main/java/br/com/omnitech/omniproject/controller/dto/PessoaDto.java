package br.com.omnitech.omniproject.controller.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PessoaDto {

    private Long id;

    private String nome;

    private LocalDate datanascimento;

    private String cpf;

    private Boolean funcionario;

    private Boolean gerente;
}
