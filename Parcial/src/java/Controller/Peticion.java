package Controller;

import Model.Formulario;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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
            Cont.CreateSchema();
            StringBuilder sb = new StringBuilder();
            String body;
            while ((body = request.getReader().readLine()) != null) {
                sb.append(body);
            }

            System.out.println(sb.toString());
            Formulario user = (Formulario) gson.fromJson(sb.toString(), Formulario.class);
            Cont.Create(user);
            String userJson = gson.toJson(user);
            out.print(userJson);

        } catch (Exception ex) {
            out.print(gson.toJson(ex));
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
