<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="is-5" style="padding: 20px">
        <div class="card">
            <div class="card-image">
                <figure class="image is-square">
                    <img src="${param.UrlEstadio}" alt="Placeholder image">
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
        </div>
    </div>
</html>
