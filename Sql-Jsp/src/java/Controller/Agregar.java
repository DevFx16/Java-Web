package Controller;

import Controller.EquipoController;
import Model.Equipo;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Agregar"})
public class Agregar extends HttpServlet {

    EquipoController _Service = new EquipoController();
    Equipo _Equipo;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Agregar.jsp");
        _Equipo = new Equipo(request.getParameter("Nombre"), request.getParameter("Estadio"),
                request.getParameter("UrlEscudo"), request.getParameter("UrlEstadio"));
        try {
            if (_Service.VerificarImagen(_Equipo.getUrlEscudo()) && _Service.VerificarImagen(_Equipo.getUrlEstadio())) {
                _Service.Create(_Equipo);
                request = _Service.RequestAtributos(request, "success", "Agregado", "Agregado correctamente a la base de datos", _Equipo);
                dispatcher.forward(request, response);
            } else {
                request = _Service.RequestAtributos(request, "error", "Error en las imagenes", "Imagen no encontrada", _Equipo);
                dispatcher.forward(request, response);
            }
        } catch (IOException ex) {
            request = _Service.RequestAtributos(request, "error", "Error en las imagenes", "Imagen no encontrada", _Equipo);
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            request = _Service.RequestAtributos(request, "error", "Error con la Base de Datos", ex.toString().replace("'", ""), _Equipo);
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
