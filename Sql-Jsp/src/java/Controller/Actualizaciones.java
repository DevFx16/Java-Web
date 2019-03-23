package Controller;

import Model.Equipo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Actualizaciones", urlPatterns = {"/Actualizaciones"})
public class Actualizaciones extends HttpServlet {

    EquipoController _Service = new EquipoController();
    Equipo _Equipo;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
        _Equipo = new Equipo(request.getParameter("Id"), request.getParameter("Nombre"), request.getParameter("Estadio"),
                request.getParameter("UrlEscudo"), request.getParameter("UrlEstadio"));
        if (request.getParameter("Metodo").equals("Eliminar")) {
            try {
                _Service.Delete(_Equipo.getId());
                request.setAttribute("Estado", "success");
                request.setAttribute("Titulo", "Eliminado");
                request.setAttribute("Mensaje", "Eliminado correctamente de la base de datos");
                dispatcher.forward(request, response);
            } catch (SQLException ex) {
                request.setAttribute("Estado", "error");
                request.setAttribute("Titulo", "Error con la Base de Datos");
                request.setAttribute("Mensaje", ex.toString().replace("'", ""));
                request.setAttribute("Equipo", _Equipo);
                dispatcher.forward(request, response);
            }
        } else {

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
            Logger.getLogger(Actualizaciones.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Actualizaciones.class.getName()).log(Level.SEVERE, null, ex);
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
