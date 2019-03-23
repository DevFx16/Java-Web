<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="container">
        <div class="columns is-centered Pad">
            <div class="column is-10 is-centered">
                <form method="POST" action="${param.Accion}">
                    <div class="field">
                        <label class="label">Nombre del Equipo</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="F.C. BARCELONA" required minlength="1" maxlength="30" name="Nombre" 
                                   value="${param.Nombre}">
                            <span class="icon is-small is-left">
                                <i class="fas fa-users"></i>
                            </span>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Nombre del Estadio</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="Camp Nou" required minlength="1" maxlength="30" name="Estadio"
                                   value="${param.Estadio}">
                            <span class="icon is-small is-left">
                                <i class="fas fa-futbol"></i>
                            </span>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Url Escudo</label>
                        <div class="control has-icons-left has-icons-right">
                            <input type="url" class="input" type="text" placeholder="https://....png" required minlength="1" maxlength="200" 
                                   name="UrlEscudo" value="${param.UrlEscudo}">
                            <span class="icon is-small is-left">
                                <i class="fas fa-link"></i>
                            </span>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Url Estadio</label>
                        <div class="control has-icons-left has-icons-right">
                            <input type="url" class="input" type="text" placeholder="https://....png" required minlength="1" maxlength="200" 
                                   name="UrlEstadio" value="${param.UrlEstadio}">
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
</html>
