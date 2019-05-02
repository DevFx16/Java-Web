package Model;

import java.sql.Array;

public class Formulario {
    
    private String Nombres;
    private String Apellidos;
    private String Email;
    private String Lenguaje;
    private Array Hobbies;

    public Formulario(String Nombres, String Apellidos, String Email, String Lenguaje, Array Hobbies) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.Lenguaje = Lenguaje;
        this.Hobbies = Hobbies;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getLenguaje() {
        return Lenguaje;
    }

    public void setLenguaje(String Lenguaje) {
        this.Lenguaje = Lenguaje;
    }

    public Array getHobbies() {
        return Hobbies;
    }

    public void setHobbies(Array Hobbies) {
        this.Hobbies = Hobbies;
    }
    
}
