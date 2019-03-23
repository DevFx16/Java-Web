<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="is-5" style="padding: 20px">
        <div class="card">
            <div class="card-image">
                <figure class="image">
                    <img src="${param.UrlEstadio}" alt="Placeholder image" style="height: 320px; width: 320px" >
                </figure>
            </div>
            <div class="card-content">
                <div class="media">
                    <div class="media-left">
                        <figure class="image is-48x48">
                            <img src="${param.UrlEscudo}" alt="Placeholder image">
                        </figure>
                    </div>
                    <div class="media-content">
                        <p class="title is-4">${param.Nombre}</p>
                        <p class="subtitle is-6">${param.Estadio}</p>
                    </div>
                </div>
            </div>
            <footer class="card-footer">
                <div class="card-footer-item">                
                    <a class="button is-primary" href="./Editar.jsp?Nombre=${param.Nombre}&UrlEstadio=
                       ${param.UrlEstadio}&Estadio=${param.Estadio}&Id=${param.Id}&UrlEscudo=${param.UrlEscudo}">
                        <span class="icon">
                            <i class="fas fa-edit"></i>
                        </span>
                        <span style="padding-left: 10px">Editar</span>
                    </a>
                </div>
                <div class="card-footer-item">                
                    <a class="button is-danger" href="./Actualizaciones?Metodo=Eliminar&Nombre=${param.Nombre}&
                       UrlEstadio=${param.UrlEstadio}&Estadio=${param.Estadio}&Id=${param.Id}&UrlEscudo=${param.UrlEscudo}">
                        <span class="icon">
                            <i class="fas fa-trash-alt"></i>
                        </span>
                        <span style="padding-left: 2px">Eliminar</span>
                    </a>
                </div>
            </footer>
        </div>
    </div>
</html>
