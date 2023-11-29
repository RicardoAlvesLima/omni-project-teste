package br.com.omnitech.omniproject.repository;

import br.com.omnitech.omniproject.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findAllByGerente(Boolean isGerente);
    List<Pessoa> findAllByFuncionario(Boolean isFuncionario);
}
