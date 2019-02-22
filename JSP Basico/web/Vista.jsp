<%@page import="Datos.Operaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
    </head>
    <body style="flex: 1; height: 100vh; display: flex; flex-direction: column; background: rgb(159,164,32);background: linear-gradient(90deg, rgba(159,164,32,0) 20%, rgba(21,195,199,0.41780462184873945) 46%, rgba(0,212,255,1) 61%);">
        <div class="container" style="height: 100%">
            <div class="row justify-content-center align-items-end" style="height: 50%">
                <h1 style="font-family: 'Pacifico', cursive;"><%= (String) request.getAttribute("Result")%></h1>
            </div>
            <div class="row justify-content-center align-items-center" style="height: 50%">
                <a type="submit" class="btn btn-primary" href="/JSP_Basico/index.html">Regresar</a>
            </div>
        </div>
    </body>
</html>
