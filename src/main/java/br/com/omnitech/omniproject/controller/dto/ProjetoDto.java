package br.com.omnitech.omniproject.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Projeto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_previsao_fim")
    private Date dataPrevisaoFim;

    @Column(name = "data_fim")
    private Date dataFim;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    private String status;

    @Column(name = "orcamento")
    private Double orcamento;

    @Column(name = "risco")
    private String risco;

    @Column(name = "idgerente")
    private Long idgerente;

    @ManyToMany(mappedBy = "projetos")
    private Set<Pessoa> pessoas;
}
