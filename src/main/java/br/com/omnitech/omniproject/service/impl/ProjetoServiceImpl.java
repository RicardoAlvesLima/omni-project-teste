package br.com.omnitech.omniproject.service.impl;

import br.com.omnitech.omniproject.enums.ProjetoRiscoEnum;
import br.com.omnitech.omniproject.enums.ProjetoStatusEnum;
import br.com.omnitech.omniproject.exception.ProjetoException;
import br.com.omnitech.omniproject.model.Pessoa;
import br.com.omnitech.omniproject.model.Projeto;
import br.com.omnitech.omniproject.repository.ProjetoRepository;
import br.com.omnitech.omniproject.service.PessoaService;
import br.com.omnitech.omniproject.service.ProjetoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static br.com.omnitech.omniproject.enums.ProjetoRiscoEnum.*;
import static br.com.omnitech.omniproject.enums.ProjetoStatusEnum.*;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    private final ProjetoRepository repository;
    private final PessoaService pessoaService;

    public ProjetoServiceImpl(ProjetoRepository repository, PessoaServiceImpl pessoaService) {
        this.repository = repository;
        this.pessoaService = pessoaService;
    }

    public Projeto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProjetoException("Projeto não encontrado"));
    }

    public List<Projeto> findAll() {
        return repository.findAll();
    }

    public Projeto saveOrUpdate(Projeto projeto) {
        if (projeto.getId() != null) {
            return repository.save(projeto);
        }

        validarRisco(projeto);
        projeto.setStatus(EM_ANALISE);
        return repository.save(projeto);
    }

    public Projeto changeStatusById(Long id, ProjetoStatusEnum status) {
        Projeto projeto = repository.findById(id).orElseThrow(RuntimeException::new);

        projeto.setStatus(status);
        return repository.save(projeto);
    }

    public void delete(Long id) {
        Projeto projeto = repository.findById(id)
                .orElseThrow(() -> new ProjetoException("Projeto não encontrado"));

        if (INICIADO.equals(projeto.getStatus()) || EM_ANDAMENTO.equals(projeto.getStatus()) || ENCERRADO.equals(projeto.getStatus())) {
            throw new ProjetoException("Projetos nos status Iniciado, Em Andamento ou Encerrado não podem ser excluidos");
        }

        repository.delete(projeto);
    }

    public void addMembro(Long projetoId, Long membroId) {
        Projeto projeto = findById(projetoId);
        Pessoa pessoa = pessoaService.findById(membroId);

        if (projeto.getPessoas().contains(pessoa)) {
            throw new ProjetoException("Funcionário ja faz parte do projeto");
        }

        projeto.getPessoas().add(pessoa);
        saveOrUpdate(projeto);
    }

    public void removeMembro(Long projetoId, Long pessoaId) {
        Projeto projeto = findById(projetoId);

        projeto.getPessoas().removeIf(p -> p.getId().equals(pessoaId));
        saveOrUpdate(projeto);
    }

    private void validarRisco(Projeto projeto) {
        long diasParaFim = ChronoUnit.DAYS.between(LocalDate.now(), projeto.getDataPrevisaoFim());

        ProjetoRiscoEnum risco = BAIXO;

        if (diasParaFim < 30 && projeto.getOrcamento() > 20000) {
            risco = ALTO;
        } else if (diasParaFim < 30 && projeto.getOrcamento() > 10000) {
            risco = MEDIO;
        }

        projeto.setRisco(risco);
    }
}
