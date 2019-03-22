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
            try {
                _Service.CreateSchema();
            } catch (Exception e) {
            }
        %>
        <jsp:include page="NavBar.jsp" />
    </body>
</html>
