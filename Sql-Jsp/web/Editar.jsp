<%@page import="Model.Equipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
        <link href="https://fonts.googleapis.com/css?family=Permanent+Marker" rel="stylesheet">
        <link href="./Styles/Estilo.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.4/css/bulma.min.css">
        <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <body>
        <jsp:include page="NavBar.jsp" />
        <%Equipo _Equipo;%>
        <%
            _Equipo = (Equipo) request.getAttribute("Equipo");
            if (_Equipo == null) {
                _Equipo = new Equipo(request.getParameter("Id"), request.getParameter("Nombre"), request.getParameter("Estadio"),
                        request.getParameter("UrlEscudo"), request.getParameter("UrlEstadio"));
            }
            if (request.getAttribute("Estado") != null && !request.getAttribute("Estado").equals("")) {
                out.print("<script>swal('" + request.getAttribute("Titulo") + "', '"
                        + request.getAttribute("Mensaje").toString() + "', '" + request.getAttribute("Estado") + "')</script>");
            }
        %>
        <jsp:include page="Formulario.jsp">
            <jsp:param name="Nombre" value="<%=_Equipo.getNombre()%>"/>
            <jsp:param name="Estadio" value="<%=_Equipo.getEstadio()%>"/>
            <jsp:param name="UrlEscudo" value="<%=_Equipo.getUrlEscudo()%>"/>
            <jsp:param name="UrlEstadio" value="<%=_Equipo.getUrlEstadio()%>"/>
            <jsp:param name="Id" value="<%=_Equipo.getId()%>"/>
            <jsp:param name="Accion" value="./Actualizaciones?Metodo=Editar&Id=${param.Id}"/>
        </jsp:include>
    </body>
</html>
