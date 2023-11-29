package br.com.omnitech.omniproject.service;

import br.com.omnitech.omniproject.model.Pessoa;

import java.util.List;

public interface PessoaService {

    List<Pessoa> listGerentes();

    List<Pessoa> listFuncionarios();

    Pessoa findById(Long id);

    Pessoa saveOrUpdate(Pessoa entity);
}
