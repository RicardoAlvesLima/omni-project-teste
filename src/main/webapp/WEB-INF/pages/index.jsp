<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Omni Project</title>
    <link href="https://fonts.icasei.com.br/fonts.css?use=Sora-Regular_ExtraLight" rel="stylesheet"/>
    <link href="https://fonts.icasei.com.br/fonts.css?use=Sora-Regular_Light" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="style/index.css" rel="stylesheet" type="text/css">
</head>
<body class="body-container d-flex flex-column gap-3 p-3">

<nav class="navbar p-3 bg-white navbar-expand-lg shadow-sm rounded-2">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="https://seeklogo.com/images/R/risingwave-icon-logo-837E37238C-seeklogo.com.png" alt="Logo"
                 width="30" height="24" class="d-inline-block align-text-top">
            OmniProjects
        </a>


        <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                data-bs-target="#criar-projeto-modal">
            Criar Projeto
        </button>
    </div>
</nav>

<div class="d-flex flex-row pb-3 gap-3 overflow-x-scroll">
    <div class="board-column">
        <label class="board-column-title mb-2">Em Análise</label>
        <div id="em-analise-board" class="d-flex flex-column gap-2">
        </div>
    </div>

    <div class="board-column">
        <label class="board-column-title mb-2">Análise Realizada</label>
        <div id="analise-realizada-board" class="d-flex flex-column gap-2">
        </div>
    </div>

    <div class="board-column">
        <label class="board-column-title mb-2">Análise Aprovada</label>
        <div id="analise-aprovada-board" class="d-flex flex-column gap-2">
        </div>
    </div>

    <div class="board-column">
        <label class="board-column-title mb-2">Iniciado</label>
        <div id="iniciado-board" class="d-flex flex-column gap-2">
        </div>
    </div>

    <div class="board-column">
        <label class="board-column-title mb-2">Planejado</label>
        <div id="planejado-board" class="d-flex flex-column gap-2">
        </div>
    </div>

    <div class="board-column">
        <label class="board-column-title mb-2">Em Andamento</label>
        <div id="em-andamento-board" class="d-flex flex-column gap-2">
        </div>
    </div>

    <div class="board-column">
        <label class="board-column-title mb-2">Encerrado</label>
        <div id="encerrado-board" class="d-flex flex-column gap-2">
        </div>
    </div>

    <div class="board-column">
        <label class="board-column-title mb-2">Cancelado</label>
        <div id="cancelado-board" class="d-flex flex-column gap-2">
        </div>
    </div>
</div>

<div id="toast-container" class="d-flex flex-column position-fixed bottom-0 end-0 p-3" style="z-index: 11">

</div>

<jsp:include page="criar-projeto.jsp"/>
<jsp:include page="edit-membros-projeto.jsp"/>
<jsp:include page="edit-projeto.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script src="https://cdn.rawgit.com/plentz/jquery-maskmoney/master/dist/jquery.maskMoney.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<script src="script/index.js"></script>
</body>
</html>
