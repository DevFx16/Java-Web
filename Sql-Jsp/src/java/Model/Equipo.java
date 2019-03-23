package Model;

public class Equipo {
    
    private String Id;
    private String Nombre;
    private String Estadio;
    private String UrlEscudo;
    private String UrlEstadio;

    public Equipo(String Nombre, String Estadio, String UrlEscudo, String UrlEstadio) {
        this.Id = Id;
        this.Nombre = Nombre.toUpperCase();
        this.Estadio = Estadio.toUpperCase();
        this.UrlEscudo = UrlEscudo;
        this.UrlEstadio = UrlEstadio;
    }

    public Equipo(String Id, String Nombre, String Estadio, String UrlEscudo, String UrlEstadio) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Estadio = Estadio;
        this.UrlEscudo = UrlEscudo;
        this.UrlEstadio = UrlEstadio;
    }
    
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEstadio() {
        return Estadio;
    }

    public void setEstadio(String Estadio) {
        this.Estadio = Estadio;
    }

    public String getUrlEscudo() {
        return UrlEscudo;
    }

    public void setUrlEscudo(String UrlEscudo) {
        this.UrlEscudo = UrlEscudo;
    }

    public String getUrlEstadio() {
        return UrlEstadio;
    }

    public void setUrlEstadio(String UrlEstadio) {
        this.UrlEstadio = UrlEstadio;
    }
    
}
