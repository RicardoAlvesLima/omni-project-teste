<div class="modal fade" id="editar-membros-projeto-modal" tabindex="-1" aria-labelledby="editar-membros-projeto-modal" aria-hidden="true">
    <div class="row g-3">
        <div class="modal-dialog">
            <div class="editar-membros-projeto-modal-content modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="editar-membros-projeto-modal-label">Membros</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="d-flex flex-column gap-3 modal-body">
                    <div class="col-auto" hidden>
                        <label for="input-membros-id-projeto-edit">Id</label>
                        <input class="form-control form-control-sm" id="input-membros-id-projeto-edit">
                    </div>
                    <div class="col-auto">
                        <label for="input-membros-projeto-edit" >Selecione um funcionario</label>
                        <select class="form-control form-control-sm" id="input-membros-projeto-edit" onchange="addMembro(this)"></select>
                    </div>
                    <ul id="list-membros-projeto-edit" class="list-group">
                    </ul>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                </div>
            </div>
        </div>
    </div>
</div>