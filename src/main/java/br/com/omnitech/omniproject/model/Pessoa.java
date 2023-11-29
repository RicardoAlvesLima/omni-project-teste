package br.com.omnitech.omniproject.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Set;

@Data
@Entity
public class Pessoa {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "datanascimento")
    private Date datanascimento;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "funcionario")
    private Boolean funcionario;

    @Column(name = "gerente")
    private Boolean gerente;

    @ManyToMany
    @JoinTable(
            name = "membros",
            joinColumns = @JoinColumn(name = "idpessoa"),
            inverseJoinColumns = @JoinColumn(name = "idprojeto"))
    private Set<Projeto> projetos;
}
