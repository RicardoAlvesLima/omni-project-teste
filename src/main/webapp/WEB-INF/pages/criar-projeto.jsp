<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="modal fade" id="criar-projeto-modal" tabindex="-1" aria-labelledby="criar-projeto-modal" aria-hidden="true">
    <div class="row g-3">
        <div class="modal-dialog">
            <div class="criar-projeto-modal-content modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="criar-projeto-modal-label">Projeto</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="d-flex flex-column gap-2 modal-body">
                    <div class="col-auto">
                        <label for="input-nome-projeto">Nome</label>
                        <input class="form-control form-control-sm" id="input-nome-projeto">
                    </div>
                    <div class="col-auto">
                        <label for="input-data-inicio-projeto">Data Início</label>
                        <input type="date" class="form-control form-control-sm" id="input-data-inicio-projeto">
                    </div>
                    <div class="col-auto">
                        <label for="input-data-previsao-fim-projeto">Data Previsão Fim</label>
                        <input type="date" class="form-control form-control-sm" id="input-data-previsao-fim-projeto">
                    </div>
                    <div class="col-auto">
                        <label for="input-data-fim-projeto">Data Fim</label>
                        <input type="date" class="form-control form-control-sm" id="input-data-fim-projeto">
                    </div>
                    <div class="col-auto">
                        <label for="input-descricao-projeto" class="form-label">Descrição</label>
                        <textarea class="form-control" id="input-descricao-projeto" rows="3"></textarea>
                    </div>
                    <div class="col-auto">
                        <label for="input-orcamento-projeto">Orçamento</label>
                        <input class="form-control form-control-sm" id="input-orcamento-projeto">
                    </div>
                    <div class="col-auto">
                        <label for="input-gerente-projeto" >Gerente Responsável</label>
                        <select class="form-control form-control-sm" id="input-gerente-projeto"></select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                    <button onclick="salvarProjeto()" class="btn btn-primary">Salvar</button>
                </div>
            </div>
        </div>
    </div>
</div>