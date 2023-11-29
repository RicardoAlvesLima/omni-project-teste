<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body
        class="d-flex flex-column gap-3 p-3"
        style="background: #f3f3f3"
>

<nav class="navbar p-3 bg-white navbar-expand-lg shadow-sm rounded-2">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="https://seeklogo.com/images/R/risingwave-icon-logo-837E37238C-seeklogo.com.png" alt="Logo"
                 width="30" height="24" class="d-inline-block align-text-top">
            OmniProjects
        </a>
        <div class="dropdown">
            <button class="btn dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                Status
            </button>
            <ul class="dropdown-menu">
                <li>
                    <button class="dropdown-item" type="button">Action</button>
                </li>
                <li>
                    <button class="dropdown-item" type="button">Another action</button>
                </li>
                <li>
                    <button class="dropdown-item" type="button">Something else here</button>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="d-flex flex-wrap gap-3">
    <c:forEach items="${projetos}" var="projeto">
        <div class="card op-card overflow-hidden" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                    card's
                    content.</p>
                <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
        </div>
    </c:forEach>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<script src="script/index.js"></script>
</body>
</html>
