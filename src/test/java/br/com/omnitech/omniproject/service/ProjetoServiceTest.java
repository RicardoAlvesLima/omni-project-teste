package br.com.omnitech.omniproject.service;

import br.com.omnitech.omniproject.exception.ProjetoException;
import br.com.omnitech.omniproject.model.Pessoa;
import br.com.omnitech.omniproject.model.Projeto;
import br.com.omnitech.omniproject.repository.ProjetoRepository;
import br.com.omnitech.omniproject.service.impl.ProjetoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
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

import static br.com.omnitech.omniproject.enums.ProjetoRiscoEnum.*;
import static br.com.omnitech.omniproject.enums.ProjetoStatusEnum.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ProjetoServiceTest {

    public static final String DELETE_ERROR = "Projetos nos status Iniciado, Em Andamento ou Encerrado não podem ser excluidos";

    private List<Pessoa> pessoas;

    private List<Projeto> projetos;

    @InjectMocks
    private ProjetoServiceImpl service;

    @Mock
    private ProjetoRepository repository;

    @BeforeEach
    public void setup() {
        pessoas = Arrays.asList(
                new Pessoa(1L, "Gerente 1", LocalDate.of(1995, 4, 20), "123.456.789-00", false, true, Set.of()),
                new Pessoa(2L, "Funcionario 1", LocalDate.of(1989, 7, 13), "111.222.333-44", true, false, Set.of()),
                new Pessoa(3L, "Funcionario 2", LocalDate.of(1997, 6, 4), "555.666.777-88", true, false, Set.of()));

        projetos = List.of(new Projeto(1L, "Projeto 1", LocalDate.of(2023, 11, 29), LocalDate.of(2023, 12, 24), null,
                        "Descricao 1", EM_ANALISE, 12000.00, MEDIO, 1L, Set.of(pessoas.get(1))),
                new Projeto(2L, "Projeto 2", LocalDate.of(2023, 12, 4), LocalDate.of(2024, 2, 13), null,
                        "Descricao 2", INICIADO, 15000.00, BAIXO, 1L, Set.of(pessoas.get(2))),
                new Projeto(3L, "Projeto 3", LocalDate.of(2023, 12, 4), LocalDate.of(2024, 2, 13), null,
                        "Descricao 3", EM_ANDAMENTO, 15000.00, MEDIO, 1L, Set.of(pessoas.get(2))),
                new Projeto(4L, "Projeto 4", LocalDate.of(2023, 12, 4), LocalDate.of(2023, 12, 20), null,
                        "Descricao 4", ENCERRADO, 25000.00, ALTO, 1L, Set.of(pessoas.get(2))));
    }

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
        assertEquals(projetos.get(0).getStatus(), projeto.getStatus());
        assertEquals(projetos.get(0).getOrcamento(), projeto.getOrcamento());
        assertEquals(projetos.get(0).getRisco(), projeto.getRisco());
        assertEquals(projetos.get(0).getIdgerente(), projeto.getIdgerente());
    }

    @Test
    void findByIdNotFound() {
        given(repository.findById(anyLong()))
                .willReturn(Optional.empty());

        assertThrows(ProjetoException.class, () -> service.findById(anyLong()), "Projeto não encontrado");
    }

    @Test
    void findAll() {
        given(repository.findAll())
                .willReturn(projetos);

        List<Projeto> projetoList = service.findAll();

        assertEquals(4, projetoList.size());
    }

    @Test
    void saveRiscoBaixo() {
        given(repository.save(any()))
                .willReturn(projetos.get(1));

        projetos.get(1).setId(null);
        Projeto projeto = service.saveOrUpdate(projetos.get(1));

        assertEquals(projetos.get(1).getId(), projeto.getId());
        assertEquals(projetos.get(1).getNome(), projeto.getNome());
        assertEquals(projetos.get(1).getDataInicio(), projeto.getDataInicio());
        assertEquals(projetos.get(1).getDataPrevisaoFim(), projeto.getDataPrevisaoFim());
        assertEquals(projetos.get(1).getDataFim(), projeto.getDataFim());
        assertEquals(projetos.get(1).getDescricao(), projeto.getDescricao());
        assertEquals(projetos.get(1).getDescricao(), projeto.getDescricao());
        assertEquals(projetos.get(1).getStatus(), projeto.getStatus());
        assertEquals(projetos.get(1).getOrcamento(), projeto.getOrcamento());
        assertEquals(projetos.get(1).getRisco(), projeto.getRisco());
        assertEquals(projetos.get(1).getIdgerente(), projeto.getIdgerente());
    }

    @Test
    void saveRiscoMedio() {
        given(repository.save(any()))
                .willReturn(projetos.get(0));

        projetos.get(0).setId(null);
        Projeto projeto = service.saveOrUpdate(projetos.get(0));

        assertEquals(projetos.get(0).getId(), projeto.getId());
        assertEquals(projetos.get(0).getNome(), projeto.getNome());
        assertEquals(projetos.get(0).getDataInicio(), projeto.getDataInicio());
        assertEquals(projetos.get(0).getDataPrevisaoFim(), projeto.getDataPrevisaoFim());
        assertEquals(projetos.get(0).getDataFim(), projeto.getDataFim());
        assertEquals(projetos.get(0).getDescricao(), projeto.getDescricao());
        assertEquals(projetos.get(0).getDescricao(), projeto.getDescricao());
        assertEquals(projetos.get(0).getStatus(), projeto.getStatus());
        assertEquals(projetos.get(0).getOrcamento(), projeto.getOrcamento());
        assertEquals(projetos.get(0).getRisco(), projeto.getRisco());
        assertEquals(projetos.get(0).getIdgerente(), projeto.getIdgerente());
    }

    @Test
    void saveRiscoAlto() {
        given(repository.save(any()))
                .willReturn(projetos.get(3));

        projetos.get(3).setId(null);
        Projeto projeto = service.saveOrUpdate(projetos.get(3));

        assertEquals(projetos.get(3).getId(), projeto.getId());
        assertEquals(projetos.get(3).getNome(), projeto.getNome());
        assertEquals(projetos.get(3).getDataInicio(), projeto.getDataInicio());
        assertEquals(projetos.get(3).getDataPrevisaoFim(), projeto.getDataPrevisaoFim());
        assertEquals(projetos.get(3).getDataFim(), projeto.getDataFim());
        assertEquals(projetos.get(3).getDescricao(), projeto.getDescricao());
        assertEquals(projetos.get(3).getDescricao(), projeto.getDescricao());
        assertEquals(projetos.get(3).getStatus(), projeto.getStatus());
        assertEquals(projetos.get(3).getOrcamento(), projeto.getOrcamento());
        assertEquals(projetos.get(3).getRisco(), projeto.getRisco());
        assertEquals(projetos.get(3).getIdgerente(), projeto.getIdgerente());
    }

    @Test
    void update() {
        given(repository.save(any()))
                .willReturn(projetos.get(0));

        Projeto projeto = service.saveOrUpdate(projetos.get(0));

        assertEquals(projetos.get(0).getId(), projeto.getId());
        assertEquals(projetos.get(0).getNome(), projeto.getNome());
        assertEquals(projetos.get(0).getDataInicio(), projeto.getDataInicio());
        assertEquals(projetos.get(0).getDataPrevisaoFim(), projeto.getDataPrevisaoFim());
        assertEquals(projetos.get(0).getDataFim(), projeto.getDataFim());
        assertEquals(projetos.get(0).getDescricao(), projeto.getDescricao());
        assertEquals(projetos.get(0).getDescricao(), projeto.getDescricao());
        assertEquals(projetos.get(0).getStatus(), projeto.getStatus());
        assertEquals(projetos.get(0).getOrcamento(), projeto.getOrcamento());
        assertEquals(projetos.get(0).getRisco(), projeto.getRisco());
        assertEquals(projetos.get(0).getIdgerente(), projeto.getIdgerente());
    }

    @Test
    void changeStatusById() {
        given(repository.findById(anyLong()))
                .willReturn(Optional.ofNullable(projetos.get(0)));

        given(repository.save(any()))
                .willReturn(projetos.get(0));

        Projeto projeto = service.changeStatusById(projetos.get(0).getId(), INICIADO);

        assertEquals(projetos.get(0).getId(), projeto.getId());
        assertEquals(projetos.get(0).getNome(), projeto.getNome());
        assertEquals(projetos.get(0).getDataInicio(), projeto.getDataInicio());
        assertEquals(projetos.get(0).getDataPrevisaoFim(), projeto.getDataPrevisaoFim());
        assertEquals(projetos.get(0).getDataFim(), projeto.getDataFim());
        assertEquals(projetos.get(0).getDescricao(), projeto.getDescricao());
        assertEquals(projetos.get(0).getDescricao(), projeto.getDescricao());
        assertEquals(projetos.get(0).getStatus(), projeto.getStatus());
        assertEquals(projetos.get(0).getOrcamento(), projeto.getOrcamento());
        assertEquals(projetos.get(0).getRisco(), projeto.getRisco());
        assertEquals(projetos.get(0).getIdgerente(), projeto.getIdgerente());
    }

    @Test
    void delete() {
        given(repository.findById(anyLong()))
                .willReturn(Optional.ofNullable(projetos.get(0)));
        service.delete(anyLong());
    }

    @Test
    void deleteIniciado() {
        given(repository.findById(anyLong()))
                .willReturn(Optional.ofNullable(projetos.get(1)));

        assertThrows(ProjetoException.class, () -> service.delete(anyLong()), DELETE_ERROR);
    }

    @Test
    void deleteEmAndamento() {
        given(repository.findById(anyLong()))
                .willReturn(Optional.ofNullable(projetos.get(2)));

        assertThrows(ProjetoException.class, () -> service.delete(anyLong()), DELETE_ERROR);
    }

    @Test
    void deleteEncerrado() {
        given(repository.findById(anyLong()))
                .willReturn(Optional.ofNullable(projetos.get(3)));

        assertThrows(ProjetoException.class, () -> service.delete(anyLong()), DELETE_ERROR);
    }
}