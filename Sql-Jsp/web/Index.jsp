<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Model.Equipo"%>
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
        <%!
            boolean Cargado;
            List<Equipo> _Equipos = new ArrayList();
        %>
        <%
            Cargado = false;
            EquipoController _Service = new EquipoController();
            try {
                _Service.CreateSchema();
                _Equipos = _Service.Read();
                Cargado = true;
            } catch (Exception e) {
                Cargado = true;
            }
        %>
        <jsp:include page="NavBar.jsp" />
        <div class="container">

            <% if (Cargado) { %>
            <% if (_Equipos.isEmpty()) { %>
            <div class="column is-5">
                <figure class="image is-square">
                    <img src="https://raw.githubusercontent.com/DevelopGadget/MongoClient/master/src/assets/404.png">
                </figure>
            </div>
            <% } else { %>
            <div class="column">
                <div class="columns">
                    <% for (Equipo Data : _Equipos) {%>
                    <jsp:include page="Card.jsp">
                        <jsp:param name="Nombre" value="<%=Data.getNombre()%>"/>
                        <jsp:param name="Estadio" value="<%=Data.getEstadio()%>"/>
                        <jsp:param name="UrlEscudo" value="<%=Data.getUrlEscudo()%>"/>
                        <jsp:param name="UrlEstadio" value="<%=Data.getUrlEstadio()%>"/>
                        <jsp:param name="Id" value="<%=Data.getId()%>"/>
                    </jsp:include>
                    <% } %>
                </div>
            </div>
            <% } %>
            <% } else { %>
            <div class="column is-5">
                <figure class="image is-square">
                    <img src="https://i.redd.it/ounq1mw5kdxy.gif">
                </figure>
            </div>
            <% }%>
        </div>
    </body>
</html>
