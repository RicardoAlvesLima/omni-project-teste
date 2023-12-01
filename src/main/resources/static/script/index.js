const status = {
    EM_ANALISE: "Em Análise",
    ANALISE_REALIZADA: "Análise Realizada",
    ANALISE_APROVADA: "Análise Aprovada",
    INICIADO: "Iniciado",
    PLANEJADO: "Planejado",
    EM_ANDAMENTO: "Em Andamento",
    ENCERRADO: "Encerrado",
    CANCELADO: "Cancelado"
}

const statusBoardsIds = {
    EM_ANALISE: "em-analise-board",
    ANALISE_REALIZADA: "analise-realizada-board",
    ANALISE_APROVADA: "analise-aprovada-board",
    INICIADO: "iniciado-board",
    PLANEJADO: "planejado-board",
    EM_ANDAMENTO: "em-andamento-board",
    ENCERRADO: "encerrado-board",
    CANCELADO: "cancelado-board"
}

const risco = {
    BAIXO: "Baixo",
    MEDIO: "Medio",
    ALTO: "Alto"
}

const riscoClassColor = {
    BAIXO: "bg-success",
    MEDIO: "bg-warning",
    ALTO: "bg-danger"
}

const createProjectDOM = (projeto) => {
    $(`#${statusBoardsIds[projeto.status]}`).append(
        `<div id="${projeto.id}" class="card op-card animate__animated animate__zoomIn animate__fast" style="width: 18rem;">
            <div class="d-flex card-header align-items-center justify-content-center">
                <h5 class="card-title m-0">${projeto.nome}</h5>
            </div>
            <div class="d-flex flex-column gap-3 card-body">
                <div class="d-flex gap-2 align-items-center">
                    <label class="fw-bold">Status:</label>
                    <select class="status-projeto-select-${projeto.id} w-100 form-select form-select-sm" onchange="changeStatus(${projeto.id}, this)"></select>
                </div>
            
                <div class="d-flex gap-2 align-items-center">
                    <label class="fw-bold">Risco:</label>
                    <span class="badge fw-normal w-100 ${riscoClassColor[projeto.risco]}">${risco[projeto.risco]}</span>
                </div>
                
                <div class="d-flex flex-column gap-1">
                    <label class="fw-bold">Descrição:</label>
                    <p class="card-text small">${projeto.descricao}</p>
                </div>
                
                <div class="d-flex flex-column">
                    <div class="d-flex gap-2 align-items-center">
                        <label class="fw-bold">Início:</label>
                        <p class="card-text small">${new Date(projeto.dataInicio).toLocaleDateString()}</p>
                    </div>
                    ${projeto.dataPrevisaoFim ? 
                        `<div class="d-flex gap-2 align-items-center">
                            <label class="fw-bold">Previsão:</label>
                            <p class="card-text small">${new Date(projeto.dataPrevisaoFim).toLocaleDateString()}</p>
                        </div>` : ``}
                    ${projeto.dataFim ?
                        `<div class="d-flex gap-2 align-items-center">
                            <label class="fw-bold">Finalizado:</label>
                            <p class="card-text small">${new Date(projeto.dataFim).toLocaleDateString()}</p>
                        </div>` : ``}
                </div>
            </div>
            <div class="card-footer">
                <div class="d-flex justify-content-end gap-1 w-100">
                    <span data-bs-toggle="tooltip" data-bs-placement="top" title="Membros">
                        <a onclick="loadMembros(${projeto.id})" class="d-flex btn btn-sm btn-primary align-items-center" data-bs-toggle="modal" data-bs-target="#editar-membros-projeto-modal">
                            <svg viewBox="0 0 24 24" width="18" height="18" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path><circle cx="9" cy="7" r="4"></circle><path d="M23 21v-2a4 4 0 0 0-3-3.87"></path><path d="M16 3.13a4 4 0 0 1 0 7.75"></path></svg>
                        </a>
                    </span>
                    <span data-bs-toggle="tooltip" data-bs-placement="top" title="Detalhes">
                        <a onclick="loadProjectDetails(${projeto.id})" class="d-flex btn btn-sm btn-primary align-items-center" data-bs-toggle="modal" data-bs-target="#editar-projeto-modal">
                            <svg viewBox="0 0 24 24" width="18" height="18" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1"><path d="M11 4H4a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7"></path><path d="M18.5 2.5a2.121 2.121 0 0 1 3 3L12 15l-4 1 1-4 9.5-9.5z"></path></svg>
                        </a>
                    </span>
                    <span data-bs-toggle="tooltip" data-bs-placement="top" title="Apagar projeto">
                        <a onclick="deletarProjeto(${projeto.id})" class="d-flex btn btn-sm btn-danger align-items-center">
                            <svg viewBox="0 0 24 24" width="18" height="18" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path><line x1="10" y1="11" x2="10" y2="17"></line><line x1="14" y1="11" x2="14" y2="17"></line></svg>
                        </a>
                    </span>
                </div>
            </div>
        </div>`
    )
}

const createMembroDOM = (id, nome) => {
    $(`#list-membros-projeto-edit`).append(
        `<li class="item-membro list-group-item d-flex justify-content-between align-items-center">
            <input class="list-membros-id-edit form-control form-control-sm" hidden value="${id}">
            ${nome}
            <a class="d-flex btn btn-sm btn-danger align-items-center" onclick="removeMembro(this)">
                <svg viewBox="0 0 24 24" width="18" height="18" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path><line x1="10" y1="11" x2="10" y2="17"></line><line x1="14" y1="11" x2="14" y2="17"></line></svg>
            </a>
        </li>`
    )
}

const createNotificationDOM = (color, message) => {
    const toastId = Math.floor(Math.random() * 100)

    $("#toast-container").append(
        `<div id='liveToast-${toastId}' class="toast ${color} text-white" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="d-flex gap-2 toast-header">
              <img src="https://seeklogo.com/images/R/risingwave-icon-logo-837E37238C-seeklogo.com.png" alt="Logo"
                   width="30" height="24" class="d-inline-block align-text-top">
              <strong class="me-auto">OmniProject</strong>
              <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
              ${message}
            </div>
        </div>`
    )

    const toastElement = document.getElementById(`liveToast-${toastId}`)
    const toast = new bootstrap.Toast(toastElement)
    toast.show()

    toastElement.addEventListener('hidden.bs.toast', () => {
        toastElement.remove()

    })
}

const notifyError = (message) => {
    createNotificationDOM('bg-danger', message)
}

const notifySuccess = (message) => {
    createNotificationDOM('bg-success', message)
}

const notify = (message) => {
    createNotificationDOM('bg-primary', message)
}

const loadStatusOptions = (selector, projeto) => {
    Object.keys(status).forEach(key => {
        $(selector).append($("<option/>", {
            selected: key === projeto.status,
            value: key,
            text: status[key]
        }));
    })
}

const loadStatusOptionsByClass = (projeto) => {
    loadStatusOptions(`.status-projeto-select-${projeto.id}`, projeto)
}

const loadStatusOptionsById = (projeto) => {
    loadStatusOptions(`#input-status-projeto-edit`, projeto)
}

const loadProjects = () => {
    $.get('/projetos/list', (response) => {
        [...response].forEach(p => {
            createProjectDOM(p)
            loadStatusOptionsByClass(p)
        })
    });
}

const loadFuncionarios = (projeto) => {
    $('#input-membros-projeto-edit').empty()
    $('#list-membros-projeto-edit').empty()

    $.get('/pessoas/funcionarios', (response) => {
        $(`#input-membros-projeto-edit`).append($("<option/>"));

        [...response].forEach(f => {
            $(`#input-membros-projeto-edit`).append($("<option/>", {
                value: f.id,
                text: f.nome
            }));
        })
    });

    [...projeto.pessoas].forEach(p => {
        createMembroDOM(p.id, p.nome)
    })
}

const loadGerentes = (edit, idgerente) => {
    $(`#input-gerente-projeto-edit`).empty()

    $.get('/pessoas/gerentes', (response) => {
        [...response].forEach(g => {
            $(edit ? `#input-gerente-projeto-edit` : `#input-gerente-projeto`).append($("<option/>", {
                selected: edit ? g.id === idgerente : null,
                value: g.id,
                text: g.nome
            }));
        })
    });
}

const loadProjectDetails = (id) => {
    $.get('/projetos', {
        id: id
    }, (response) => {
        $('#input-id-projeto-edit').val(response.id)
        $('#input-risco-projeto-edit').val(response.risco)
        $('#input-nome-projeto-edit').val(response.nome)
        $('#input-data-inicio-projeto-edit').val(response.dataInicio)
        $('#input-data-previsao-fim-projeto-edit').val(response.dataPrevisaoFim)
        $('#input-data-fim-projeto-edit').val(response.dataFim)
        $('#input-descricao-projeto-edit').val(response.descricao)
        $('#input-orcamento-projeto-edit').val(response.orcamento).maskMoney({
            prefix: 'R$ ',
            allowNegative: true,
            thousands: '.', decimal: ',',
            affixesStay: true,
        })
        loadGerentes(true, response.idgerente)
        loadStatusOptionsById(response)
    });
}

const loadMembros = (id) => {
    $.get('/projetos', {
        id: id
    }, (response) => {
        $('#input-membros-id-projeto-edit').val(response.id)

        loadFuncionarios(response)
    });
}

const salvarProjeto = (edit) => {
    let modalElement = document.getElementById(edit ? 'editar-projeto-modal' : 'criar-projeto-modal')
    let modal = bootstrap.Modal.getInstance(modalElement)

    let data = {
        id: edit ? $("#input-id-projeto-edit").val() : null,
        risco: edit ? $("#input-risco-projeto-edit").val() : null,
        nome: $(edit ? "#input-nome-projeto-edit" : "#input-nome-projeto").val(),
        dataInicio: $(edit ? "#input-data-inicio-projeto-edit" : "#input-data-inicio-projeto").val(),
        dataPrevisaoFim: $(edit ? "#input-data-previsao-fim-projeto-edit" : "#input-data-previsao-fim-projeto").val(),
        dataFim: $(edit ? "#input-data-fim-projeto-edit" : "#input-data-fim-projeto").val(),
        descricao: $(edit ? "#input-descricao-projeto-edit" : "#input-descricao-projeto").val(),
        orcamento: $(edit ? "#input-orcamento-projeto-edit" : "#input-orcamento-projeto").maskMoney('unmasked')[0],
        status: edit ? $("#input-status-projeto-edit").val() : null,
        idgerente: Number($(edit ? "#input-gerente-projeto-edit" : "#input-gerente-projeto").val())

    };

    $.ajax({
        type: edit ? "PUT" : "POST",
        url: "/projetos",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: (response) => {
            if (edit) {
                $(`#${response.id}`).remove()
            }

            createProjectDOM(response)
            loadStatusOptionsByClass(response)
            modal.hide()
            notifySuccess(edit ? 'Alteracoes salvas com sucesso' : 'Projeto criado com sucesso')
        }
    })
}

const deletarProjeto = (id) => {
    $.ajax({
        url: '/projetos',
        type: 'DELETE',
        data: {
            id: id,
        },
        success: (response) => {
            notifySuccess(response.message)
            const element = document.getElementById(id)
            element.classList.add('animate__animated', 'animate__zoomOut', 'animate__fast')

            element.addEventListener('animationend', () => {
                $(`#${id}`).remove()
            })
        },
        error: (response) => {
            notifyError(response.responseJSON.message)
        }
    });
}

const changeStatus = (id, event) => {
    $.ajax({
        url: '/projetos/change-status',
        type: 'PUT',
        data: {
            id: id,
            status: event.value
        },
        success: (response) => {
            const element = document.getElementById(id)
            element.classList.add('animate__animated', 'animate__zoomOut', 'animate__fast')

            element.addEventListener('animationend', () => {
                $(`#${id}`).remove()
                createProjectDOM(response)
                loadStatusOptionsByClass(response)
            })
        }
    });
}

const addMembro = () => {
    const projetoId = $("#input-membros-id-projeto-edit").val()
    const pessoa = $("#input-membros-projeto-edit").find(":selected")
    console.log(pessoa)

    $.ajax({
        url: '/projetos/membros',
        type: 'PUT',
        data: {
            projetoId: projetoId,
            pessoaId: pessoa.val()
        },
        success: (response) => {
            notifySuccess(response.message)
            createMembroDOM(pessoa.val(), pessoa.text())
        },
        error: (response) => {
            notifyError(response.responseJSON.message)
        }
    });
}

const removeMembro = (event) => {
    const projetoId = $("#input-membros-id-projeto-edit").val()
    const pessoaId = event.parentElement.querySelector('.list-membros-id-edit').value

    $.ajax({
        url: '/projetos/membros',
        type: 'DELETE',
        data: {
            projetoId: projetoId,
            pessoaId: pessoaId
        },
        success: (response) => {
            notifySuccess(response.message)
            event.parentElement.remove()
        }
    });
}

$(document).ready(function () {
    loadProjects()
    loadGerentes(false)

    $('#input-orcamento-projeto').maskMoney({
        prefix: 'R$ ',
        allowNegative: true,
        thousands: '.', decimal: ',',
        affixesStay: true,
    });
});