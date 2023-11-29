package br.com.omnitech.omniproject.service.impl;

import br.com.omnitech.omniproject.exception.PessoaException;
import br.com.omnitech.omniproject.model.Pessoa;
import br.com.omnitech.omniproject.repository.PessoaRepository;
import br.com.omnitech.omniproject.service.PessoaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository repository;

    public PessoaServiceImpl(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<Pessoa> listGerentes() {
        return repository.findAllByGerente(true);
    }

    public List<Pessoa> listFuncionarios() {
        return repository.findAllByFuncionario(true);
    }

    public Pessoa findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PessoaException("Membro não encontrado"));
    }

    public Pessoa saveOrUpdate(Pessoa entity) {
        return repository.save(entity);
    }
}
