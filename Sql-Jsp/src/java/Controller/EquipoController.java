package Controller;

import Model.Equipo;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EquipoController implements IEquipo {

    private final String Driver = "com.mysql.jdbc.Driver";
    private final String User = "root";
    private final String Password = "DevelopGadget";
    private final String Url = "jdbc:mysql://localhost:8080/equiposdb";

    @Override
    public Connection Conexion() throws ClassNotFoundException, SQLException {
        Class.forName(Driver);
        return DriverManager.getConnection(Url, User, Password); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Create() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Equipo> Read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Equipo ReadId() {
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
        PreparedStatement stm = _Conexion.prepareStatement("CREATE TABLE IF NOT EXISTS EQUIPOS (Id INT AUTO_INCREMENT PRIMARY KEY, "
                + "Nombre VARCHAR(30) NOT NULL, Estadio VARCHAR(30) NOT NULL, UrlEscudo VARCHAR(200) NOT NULL, UrlEstadio VARCHAR(200) NOT NULL)");
        stm.executeUpdate();
    }

}

interface IEquipo {

    Connection Conexion() throws ClassNotFoundException, SQLException;

    void CreateSchema() throws ClassNotFoundException, SQLException;

    ;

    boolean Create() throws ClassNotFoundException, SQLException;

    ;

    List<Equipo> Read() throws ClassNotFoundException, SQLException;

    ;

    Equipo ReadId() throws ClassNotFoundException, SQLException;

    ;

    Equipo Update(Equipo Datos) throws ClassNotFoundException, SQLException;

    ;

    boolean Delete(int Id) throws ClassNotFoundException, SQLException;
;
}
