package Model;

import java.sql.Array;

public class Formulario {
    
    private int Id;
    private String Nombres;
    private String Apellidos;
    private String Email;
    private String Lenguaje;
    private String[] Hobbies;

    public Formulario(String Nombres, String Apellidos, String Email, String Lenguaje, String[] Hobbies) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.Lenguaje = Lenguaje;
        this.Hobbies = Hobbies;
    }

    public Formulario(int Id, String Nombres, String Apellidos, String Email, String Lenguaje, String[] Hobbies) {
        this.Id = Id;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.Lenguaje = Lenguaje;
        this.Hobbies = Hobbies;
    }

    public int getId() {
        return Id;
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

    public String[] getHobbies() {
        return Hobbies;
    }

    public void setHobbies(String[] Hobbies) {
        this.Hobbies = Hobbies;
    }
    
}
