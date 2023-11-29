package br.com.omnitech.omniproject.service;

import br.com.omnitech.omniproject.model.Pessoa;
import br.com.omnitech.omniproject.model.Projeto;
import br.com.omnitech.omniproject.repository.ProjetoRepository;
import br.com.omnitech.omniproject.service.impl.ProjetoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static br.com.omnitech.omniproject.enums.ProjetoRiscoEnum.BAIXO;
import static br.com.omnitech.omniproject.enums.ProjetoRiscoEnum.MEDIO;
import static br.com.omnitech.omniproject.enums.ProjetoStatusEnum.EM_ANALISE;
import static br.com.omnitech.omniproject.enums.ProjetoStatusEnum.INICIADO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ProjetoServiceTest {

    private final List<Pessoa> pessoas = Arrays.asList(
            new Pessoa(1L, "Gerente 1", LocalDate.of(1995, 4, 20), "123.456.789-00", false, true, Set.of()),
            new Pessoa(2L, "Funcionario 1", LocalDate.of(1989, 7, 13), "111.222.333-44", true, false, Set.of()),
            new Pessoa(3L, "Funcionario 2", LocalDate.of(1997, 6, 4), "555.666.777-88", true, false, Set.of()));

    private final List<Projeto> projetos = List.of(
            new Projeto(1L, "Projeto 1", LocalDate.of(2023, 11, 29), LocalDate.of(2023, 12, 29), null,
                    "Descricao 1", EM_ANALISE, 12000.00, BAIXO, 1L, Set.of(pessoas.get(1))),
            new Projeto(2L, "Projeto 2", LocalDate.of(2023, 12, 4), LocalDate.of(2024, 2, 13), null,
                    "Descricao 2", INICIADO, 15000.00, MEDIO, 1L, Set.of(pessoas.get(2))));

    @InjectMocks
    private ProjetoServiceImpl service;

    @Mock
    private ProjetoRepository repository;

    @Test
    void findById() {
        given(repository.findById(anyLong()))
                .willReturn(Optional.ofNullable(projetos.get(0)));

        Projeto projeto = service.findById(anyLong());

        assertEquals(projetos.get(0).getId(), projeto.getId());
        assertEquals(projetos.get(0).getNome(), projeto.getNome());
        assertEquals(projetos.get(0).getDataInicio(), projeto.getDataInicio());
        assertEquals(projetos.get(0).getDataPrevisaoFim(), projeto.getDataPrevisaoFim());
        assertEquals(projetos.get(0).getDataFim(), projeto.getDataFim());
        assertEquals(projetos.get(0).getDescricao(), projeto.getDescricao());
        assertEquals(projetos.get(0).getDescricao(), projeto.getDescricao());
    }

    @Test
    void findAll() {
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void changeStatusById() {
    }

    @Test
    void delete() {
    }

    @Test
    void addMembro() {
    }

    @Test
    void removeMembro() {
    }
}