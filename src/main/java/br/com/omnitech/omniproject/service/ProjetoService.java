package br.com.omnitech.omniproject.service;

import br.com.omnitech.omniproject.enums.ProjetoStatusEnum;
import br.com.omnitech.omniproject.model.Projeto;

import java.util.List;

public interface ProjetoService {

    Projeto findById(Long id);

    List<Projeto> findAll();

    Projeto saveOrUpdate(Projeto projeto);

    Projeto changeStatusById(Long id, ProjetoStatusEnum status);

    void delete(Long id);

    void addMembro(Long projetoId, Long membroId);

    void removeMembro(Long projetoId, Long pessoaId);
}
