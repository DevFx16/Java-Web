package Controller;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Controller {

    private final String Driver = "com.mysql.jdbc.Driver";
    private final String User = "root";
    private final String Password = "estudiante";
    private final String Url = "jdbc:mysql://localhost:3306/midb";

    public Connection Conexion() throws ClassNotFoundException, SQLException {
        Class.forName(Driver);
        return (Connection) DriverManager.getConnection(Url, User, Password);
    }

    public List<Model.Formulario> Read() throws ClassNotFoundException, SQLException {
        List<Model.Formulario> Get = new ArrayList();
        Connection _Conexion = Conexion();
        Statement stm = _Conexion.createStatement();
        ResultSet Result = stm.executeQuery("SELECT * FROM DATOS");
        while (Result.next()) {
            Get.add(new Model.Formulario(Result.getString(1), Result.getString(2), Result.getString(3), Result.getString(4), Result.getArray(5)));
        }
        _Conexion.close();
        return Get;
    }

    public void Create(Model.Formulario Datos) throws ClassNotFoundException, SQLException {
        Connection _Conexion = Conexion();
        PreparedStatement stm = _Conexion.prepareStatement("INSERT INTO DATOS VALUES(?,?,?,?,?)");
        stm.setString(1, Datos.getNombres());
        stm.setString(2, Datos.getApellidos());
        stm.setString(3, Datos.getEmail());
        stm.setString(4, Datos.getLenguaje());
        stm.setArray(5, Datos.getHobbies());
        stm.executeUpdate();
        _Conexion.close();
    }

    public void CreateSchema() throws ClassNotFoundException, SQLException {
        Connection _Conexion = Conexion();
        Statement stm = _Conexion.createStatement();
        stm.executeUpdate("CREATE TABLE IF NOT EXISTS DATOS (Id  AUTO_INCREMENT PRIMARY KEY, "
                + "Nombres VARCHAR(30) NOT NULL, Apellidos VARCHAR(30) NOT NULL, Email VARCHAR(30) NOT NULL, Lenguaje VARCHAR(30) NOT NULL, "
                + "Hobbies VARCHAR(200) NOT NULL)");
        _Conexion.close();
    }

}
