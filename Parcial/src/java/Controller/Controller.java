package Controller;

import Model.Formulario;
import com.mysql.jdbc.Connection;
import java.sql.Array;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Controller {

    private final String Driver = "com.mysql.jdbc.Driver";
    private final String User = "root";
    private final String Password = null;
    private final String Url = "jdbc:mysql://localhost:3306/midb";

    public Connection Conexion() throws ClassNotFoundException, SQLException {
        Class.forName(Driver);
        return (Connection) DriverManager.getConnection(Url, User, Password);
    }

    public List<Formulario> Read() throws ClassNotFoundException, SQLException {
        List<Formulario> Get = new ArrayList();
        Connection _Conexion = Conexion();
        Statement stm = _Conexion.createStatement();
        ResultSet Result = stm.executeQuery("SELECT * FROM DATOS");
        System.out.println(Result.toString());
        while (Result.next()) {
            Get.add(new Formulario(Result.getInt("Id"), Result.getString("Nombres"), Result.getString("Apellidos"),
                    Result.getString("Email"), Result.getString("lenguaje"), toArray(Result.getString("Hobbies"))));
        }
        _Conexion.close();
        return Get;
    }

    private String[] toArray(String data) {
        data = data.replace("[", "");
        data = data.replace("]", "");
        return data.split(",");
    }

    public void Create(Model.Formulario Datos) throws ClassNotFoundException, SQLException {
        Connection _Conexion = Conexion();
        PreparedStatement stm = _Conexion.prepareStatement("INSERT INTO DATOS (Nombres, Apellidos, Email, Lenguaje, Hobbies) VALUES(?,?,?,?,?)");
        stm.setString(1, Datos.getNombres());
        stm.setString(2, Datos.getApellidos());
        stm.setString(3, Datos.getEmail());
        stm.setString(4, Datos.getLenguaje());
        stm.setString(5, Arrays.toString(Datos.getHobbies()));
        stm.executeUpdate();
        _Conexion.close();
    }

    public void CreateSchema() throws ClassNotFoundException, SQLException {
        Connection _Conexion = Conexion();
        Statement stm = _Conexion.createStatement();
        String cons = "CREATE TABLE IF NOT EXISTS DATOS "
                + "(Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "Nombres VARCHAR(30) NOT NULL, Apellidos VARCHAR(30) NOT NULL,"
                + "Email VARCHAR(30) NOT NULL,"
                + "Lenguaje VARCHAR(30) NOT NULL, Hobbies VARCHAR(300) NOT NULL);";
        System.out.println(cons);
        stm.executeUpdate(cons);
        _Conexion.close();
    }

}
