package br.com.omnitech.omniproject.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Projeto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "data_inicio")
    private Date dataInicio;
    @Basic
    @Column(name = "data_previsao_fim")
    private Date dataPrevisaoFim;
    @Basic
    @Column(name = "data_fim")
    private Date dataFim;
    @Basic
    @Column(name = "descricao")
    private String descricao;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "orcamento")
    private Double orcamento;
    @Basic
    @Column(name = "risco")
    private String risco;
    @Basic
    @Column(name = "idgerente")
    private long idgerente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataPrevisaoFim() {
        return dataPrevisaoFim;
    }

    public void setDataPrevisaoFim(Date dataPrevisaoFim) {
        this.dataPrevisaoFim = dataPrevisaoFim;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public long getIdgerente() {
        return idgerente;
    }

    public void setIdgerente(long idgerente) {
        this.idgerente = idgerente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projeto projeto = (Projeto) o;
        return id == projeto.id && idgerente == projeto.idgerente && Objects.equals(nome, projeto.nome) && Objects.equals(dataInicio, projeto.dataInicio) && Objects.equals(dataPrevisaoFim, projeto.dataPrevisaoFim) && Objects.equals(dataFim, projeto.dataFim) && Objects.equals(descricao, projeto.descricao) && Objects.equals(status, projeto.status) && Objects.equals(orcamento, projeto.orcamento) && Objects.equals(risco, projeto.risco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataInicio, dataPrevisaoFim, dataFim, descricao, status, orcamento, risco, idgerente);
    }
}
