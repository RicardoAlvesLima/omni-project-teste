package br.com.omnitech.omniproject.controller;

import br.com.omnitech.omniproject.controller.dto.PessoaDto;
import br.com.omnitech.omniproject.mapper.PessoaMapper;
import br.com.omnitech.omniproject.service.PessoaService;
import br.com.omnitech.omniproject.service.impl.PessoaServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    private final PessoaService service;
    private final PessoaMapper mapper;

    public PessoasController(PessoaServiceImpl service, PessoaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public PessoaDto create(@RequestBody PessoaDto pessoa) {
        return mapper.toDto(service.saveOrUpdate(mapper.toEntity(pessoa)));
    }

    @GetMapping("/gerentes")
    public List<PessoaDto> listGerentes() {
        return mapper.toDtoList(service.listGerentes());
    }

    @GetMapping("/funcionarios")
    public List<PessoaDto> listFuncionarios() {
        return mapper.toDtoList(service.listFuncionarios());
    }
}
