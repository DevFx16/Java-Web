<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controller.EquipoController" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Inicio</title>
        <link href="https://fonts.googleapis.com/css?family=Permanent+Marker" rel="stylesheet">
        <link href="./Styles/Estilo.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.4/css/bulma.min.css">
        <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
    </head>
    <body>
        <% 
            EquipoController _Service = new EquipoController();
            _Service.CreateSchema();
        %>
        <nav class="navbar is-dark" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
                <a class="navbar-item" href="../Sql">
                    <span class="Titulo is-size-3 has-text-centered">RegeTeam</span>
                </a>
                <a role="button" class="navbar-burger burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                </a>
            </div>
            <div class="navbar-end">
                <div class="navbar-item">
                    <div class="button is-primary">
                        <span class="icon is-medium">
                            <i class="fas fa-plus fa-lg"></i>
                        </span>
                    </div>
                </div>
            </div>
        </nav>
    </body>
</html>
