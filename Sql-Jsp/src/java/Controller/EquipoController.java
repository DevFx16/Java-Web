package Controller;

import Model.Equipo;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class EquipoController implements IEquipo {

    private final String Driver = "com.mysql.jdbc.Driver";
    private final String User = "root";
    private final String Password = "DevelopGadget";
    private final String Url = "jdbc:mysql://localhost:8080/equiposdb?useSSL=false";

    @Override
    public Connection Conexion() throws ClassNotFoundException, SQLException {
        Class.forName(Driver);
        return DriverManager.getConnection(Url, User, Password); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Create(Equipo Datos) throws ClassNotFoundException, SQLException {
        Connection _Conexion = Conexion();
        Datos.setId(UUID.randomUUID().toString());
        PreparedStatement stm = _Conexion.prepareStatement("INSERT INTO EQUIPOS VALUES(?,?,?,?,?)");
        stm.setString(1, Datos.getId());
        stm.setString(2, Datos.getNombre());
        stm.setString(3, Datos.getEstadio());
        stm.setString(4, Datos.getUrlEscudo());
        stm.setString(5, Datos.getUrlEstadio());
        stm.executeUpdate();
        _Conexion.close();
    }

    @Override
    public List<Equipo> Read() throws ClassNotFoundException, SQLException {
        List<Equipo> Get = new ArrayList();
        Connection _Conexion = Conexion();
        Statement stm = _Conexion.createStatement();
        ResultSet Result = stm.executeQuery("SELECT * FROM EQUIPOS");
        while(Result.next()){
            Get.add(new Equipo(Result.getString(1), Result.getString(2), Result.getString(3), Result.getString(4), Result.getString(5)));
        }
        return Get;
    }

    @Override
    public Equipo Read(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Equipo Update(Equipo Datos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Delete(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CreateSchema() throws ClassNotFoundException, SQLException {
        Connection _Conexion = Conexion();
        PreparedStatement stm = _Conexion.prepareStatement("CREATE TABLE IF NOT EXISTS EQUIPOS (Id VARCHAR(100) PRIMARY KEY, "
                + "Nombre VARCHAR(30) NOT NULL, Estadio VARCHAR(30) NOT NULL, UrlEscudo VARCHAR(200) NOT NULL, UrlEstadio VARCHAR(200) NOT NULL)");
        stm.executeUpdate();
        _Conexion.close();
    }

}

interface IEquipo {

    Connection Conexion() throws ClassNotFoundException, SQLException;

    void CreateSchema() throws ClassNotFoundException, SQLException;

    void Create(Equipo Datos) throws ClassNotFoundException, SQLException;

    List<Equipo> Read() throws ClassNotFoundException, SQLException;

    Equipo Read(int Id) throws ClassNotFoundException, SQLException;

    Equipo Update(Equipo Datos) throws ClassNotFoundException, SQLException;

    boolean Delete(int Id) throws ClassNotFoundException, SQLException;
}
