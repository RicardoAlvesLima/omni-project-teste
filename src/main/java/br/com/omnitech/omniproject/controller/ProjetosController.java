package br.com.omnitech.omniproject.controller;

import br.com.omnitech.omniproject.controller.dto.ApiResponse;
import br.com.omnitech.omniproject.controller.dto.ProjetoDto;
import br.com.omnitech.omniproject.enums.ProjetoStatusEnum;
import br.com.omnitech.omniproject.mapper.ProjetoMapper;
import br.com.omnitech.omniproject.service.ProjetoService;
import br.com.omnitech.omniproject.service.impl.ProjetoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetosController {

    private final ProjetoService service;

    private final ProjetoMapper mapper;

    public ProjetosController(ProjetoServiceImpl service, ProjetoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<ProjetoDto> findById(Long id) {
        return ResponseEntity.ok(mapper.toDto(service.findById(id)));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProjetoDto>> findAll() {
        return ResponseEntity.ok(mapper.toDtoList(service.findAll()));
    }

    @PostMapping
    public ProjetoDto create(@RequestBody ProjetoDto body) {
        return mapper.toDto(service.saveOrUpdate(mapper.toEntity(body)));
    }

    @PutMapping
    public ProjetoDto update(@RequestBody ProjetoDto body) {
        return mapper.toDto(service.saveOrUpdate(mapper.toEntity(body)));
    }

    @PutMapping("/change-status")
    public ProjetoDto changeStatus(Long id, ProjetoStatusEnum status) {
        return mapper.toDto(service.changeStatusById(id, status));
    }

    @DeleteMapping
    public ApiResponse delete(Long id) {
        service.delete(id);
        return new ApiResponse("Projeto removido com sucesso");
    }

    @PutMapping("/membros")
    public ApiResponse addMembro(Long projetoId, Long pessoaId) {
        service.addMembro(projetoId, pessoaId);
        return new ApiResponse("Membro adicionado com sucesso");
    }

    @DeleteMapping("/membros")
    public ApiResponse removeMembro(Long projetoId, Long pessoaId) {
        service.removeMembro(projetoId, pessoaId);
        return new ApiResponse("Membro removido com sucesso");
    }
}
