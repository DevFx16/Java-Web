<%@page import="Model.Equipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Agregar Equipo</title>
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
            if(_Equipo == null){
                _Equipo = new Equipo("","","","");
            }
            if(request.getAttribute("Estado") != null && !request.getAttribute("Estado").equals("")){
                out.print("<script>swal('"+request.getAttribute("Titulo")+"', '"+
                        request.getAttribute("Mensaje").toString()+"', '"+request.getAttribute("Estado")+"')</script>");
            }
        %>
        <div class="container">
            <div class="columns is-centered Pad">
                <div class="column is-10 is-centered">
                    <form method="POST" action="./Agregar">
                        <div class="field">
                            <label class="label">Nombre del Equipo</label>
                            <div class="control has-icons-left has-icons-right">
                                <input class="input" type="text" placeholder="F.C. BARCELONA" required minlength="1" maxlength="30" name="Nombre" 
                                       value="<%=_Equipo.getNombre()%>">
                                <span class="icon is-small is-left">
                                    <i class="fas fa-users"></i>
                                </span>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">Nombre del Estadio</label>
                            <div class="control has-icons-left has-icons-right">
                                <input class="input" type="text" placeholder="Camp Nou" required minlength="1" maxlength="30" name="Estadio"
                                       value="<%=_Equipo.getEstadio()%>">
                                <span class="icon is-small is-left">
                                    <i class="fas fa-futbol"></i>
                                </span>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">Url Escudo</label>
                            <div class="control has-icons-left has-icons-right">
                                <input type="url" class="input" type="text" placeholder="https://....png" required minlength="1" maxlength="200" 
                                       name="UrlEscudo" value="<%=_Equipo.getUrlEscudo()%>">
                                <span class="icon is-small is-left">
                                    <i class="fas fa-link"></i>
                                </span>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">Url Estadio</label>
                            <div class="control has-icons-left has-icons-right">
                                <input type="url" class="input" type="text" placeholder="https://....png" required minlength="1" maxlength="200" 
                                       name="UrlEstadio" value="<%=_Equipo.getUrlEstadio()%>">
                                <span class="icon is-small is-left">
                                    <i class="fas fa-link"></i>
                                </span>
                            </div>
                        </div>
                        <div class="field">
                            <p class="control">
                                <button class="button is-success is-centered">
                                    Agregar
                                </button>
                            </p>
                        </div>
                    </form>  
                </div>
            </div>
        </div>
    </body>
</html>
