package Controller;

import Model.Formulario;
import Model.Response;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Peticion", urlPatterns = {"/Peticion"})
public class Peticion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        Controller Cont = new Controller();
        try {
            StringBuilder sb = new StringBuilder();
            String body;
            while ((body = request.getReader().readLine()) != null) {
                sb.append(body);
            }
            Formulario user = (Formulario) gson.fromJson(sb.toString(), Formulario.class);
            Cont.Create(user);
            out.print(gson.toJson(new Response(true, user)));
        } catch (Exception ex) {
            out.print(gson.toJson(new Response(false, ex)));
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
