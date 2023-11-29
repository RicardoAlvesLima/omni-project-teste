package br.com.omnitech.omniproject.repository;

import br.com.omnitech.omniproject.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
