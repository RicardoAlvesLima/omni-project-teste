<div class="modal fade" id="editar-projeto-modal" tabindex="-1" aria-labelledby="editar-projeto-modal" aria-hidden="true">
    <div class="row g-3">
        <div class="modal-dialog">
            <div class="editar-projeto-modal-content modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="editar-projeto-modal-label">Projeto</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="d-flex flex-column gap-2 modal-body">
                    <div class="col-auto" hidden>
                        <label for="input-id-projeto-edit">Id</label>
                        <input class="form-control form-control-sm" id="input-id-projeto-edit">
                    </div>
                    <div class="col-auto" hidden>
                        <label for="input-risco-projeto-edit">Risco</label>
                        <input class="form-control form-control-sm" id="input-risco-projeto-edit">
                    </div>
                    <div class="col-auto">
                        <label for="input-status-projeto-edit">Status</label>
                        <select class="form-select form-select-sm" id="input-status-projeto-edit" onchange="changeStatus(this)"></select>
                    </div>
                    <div class="col-auto">
                        <label for="input-nome-projeto-edit">Nome</label>
                        <input class="form-control form-control-sm" id="input-nome-projeto-edit">
                    </div>
                    <div class="col-auto">
                        <label for="input-data-inicio-projeto-edit">Data Inicio</label>
                        <input type="date" class="form-control form-control-sm" id="input-data-inicio-projeto-edit">
                    </div>
                    <div class="col-auto">
                        <label for="input-data-previsao-fim-projeto-edit">Data Previsao Fim</label>
                        <input type="date" class="form-control form-control-sm" id="input-data-previsao-fim-projeto-edit">
                    </div>
                    <div class="col-auto">
                        <label for="input-data-fim-projeto-edit">Data Fim</label>
                        <input type="date" class="form-control form-control-sm" id="input-data-fim-projeto-edit">
                    </div>
                    <div class="col-auto">
                        <label for="input-descricao-projeto-edit" class="form-label">Descricao</label>
                        <textarea class="form-control" id="input-descricao-projeto-edit" rows="3"></textarea>
                    </div>
                    <div class="col-auto">
                        <label for="input-orcamento-projeto-edit">Orcamento</label>
                        <input class="form-control form-control-sm" id="input-orcamento-projeto-edit">
                    </div>
                    <div class="col-auto">
                        <label for="input-gerente-projeto-edit" >Gerente Responsavel</label>
                        <select class="form-control form-control-sm" id="input-gerente-projeto-edit"></select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                    <button onclick="salvarProjeto(true)" class="btn btn-primary">Salvar</button>
                </div>
            </div>
        </div>
    </div>
</div>