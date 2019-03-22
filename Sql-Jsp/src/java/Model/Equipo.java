package Model;

public class Equipo {
    
    private int Id;
    private String Nombre;
    private String Estadio;
    private String UrlEquipo;
    private String UrlEstadio;

    public Equipo(int Id, String Nombre, String Estadio, String UrlEquipo, String UrlEstadio) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Estadio = Estadio;
        this.UrlEquipo = UrlEquipo;
        this.UrlEstadio = UrlEstadio;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
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

    public String getUrlEquipo() {
        return UrlEquipo;
    }

    public void setUrlEquipo(String UrlEquipo) {
        this.UrlEquipo = UrlEquipo;
    }

    public String getUrlEstadio() {
        return UrlEstadio;
    }

    public void setUrlEstadio(String UrlEstadio) {
        this.UrlEstadio = UrlEstadio;
    }
    
}
