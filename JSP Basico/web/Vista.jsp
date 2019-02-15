<%@page import="Datos.Operaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos</title>
    </head>
    <body>
        <%!
            Operaciones Op = new Operaciones();
        %>
        <%
            if (Op.Verificar(request.getParameter("X"), request.getParameter("X"))) {

            } else {
                response.sendRedirect("/JSP_Basico/index.html?Datos=1");
            }
        %>
    </body>
</html>
