<%@page import="Controller.Controller"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Formulario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.4/css/bulma.min.css">
        <!-- Optional: include a polyfill for ES6 Promises for IE11 and Android browser -->
        <script src="https://cdn.jsdelivr.net/npm/promise-polyfill"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-standalone/6.26.0/babel.min.js"></script>
        <script type="text/babel" src="./Agregar.js"></script>
        <style>
            .is-horizontal-center {
                justify-content: center;
            }

            .is-vertical-center {
                display: flex;
                align-items: center;
            }
            .full {
                margin: 0px;height: 100%;
            }
            .float {
                position:fixed;
                box-shadow: 2px 2px 3px #999;
                bottom:40px;
                right:40px;
            }
        </style>
    </head>
    <body class="full">
        <%!
            boolean Cargado = false;
            List<Formulario> Registros = new ArrayList();
            Controller Cont = new Controller();
        %>
        <%
            try {
                Cont.CreateSchema();
                Registros = Cont.Read();
            } catch (Exception e) {
            }
            Cargado = true;
        %>
        <div class="container is-fullhd full">
            <div class="columns full" >
                <%if (Cargado) {%>
                <div class="column">
                    <table class="table is-fullwidth">
                        <thead>
                            <tr><th colspan="6" class="has-text-centered">Registros</th></tr>
                            <tr>
                                <th class="has-text-centered">Id</th>
                                <th class="has-text-centered">Nombres</th>
                                <th class="has-text-centered">Apellidos</th>
                                <th class="has-text-centered">Email</th>
                                <th class="has-text-centered">Lenguaje</th>
                                <th class="has-text-centered">Hobbies</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (Formulario Reg : Registros) {%>
                            <tr>
                                <td class="has-text-centered"><%=Reg.getId()%></td>
                                <td class="has-text-centered"><%=Reg.getNombres()%></td>
                                <td class="has-text-centered"><%=Reg.getApellidos()%></td>
                                <td class="has-text-centered"><%=Reg.getEmail()%></td>
                                <td class="has-text-centered"><%=Reg.getLenguaje()%></td>
                                <td class="has-text-centered">
                                    <div class="tags is-horizontal-center">
                                        <% for (String Data : Reg.getHobbies()) {%>
                                        <span class="tag is-success"><%=Data%></span>
                                        <% } %>
                                    </div>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                    <a class="button is-primary float" onClick="LanzarFormulario();"><i class="fa fa-plus"></i></a>
                </div>
                <%} else {%>
                <div class="column is-flex is-horizontal-center is-vertical-center full">
                    <img src="https://loading.io/spinners/liquid/lg.liquid-fill-preloader.gif" />
                </div>
                <%}%>
            </div>
        </div>
    </body>
</html>
