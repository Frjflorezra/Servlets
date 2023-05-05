
package principal;

import base_datos.BaseDatos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registro extends HttpServlet {
 
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" -- Llegamos desde una peticion GET");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String cedula = request.getParameter("cedula_persona");
        String nombres = request.getParameter("nombres_persona");
        String apellidos = request.getParameter("apellidos_persona");
        String telefono = request.getParameter("telefono_persona");
        String email = request.getParameter("email_persona");
        
        BaseDatos db = new BaseDatos();
        
        boolean proceso = db.insertarPersona(cedula, nombres, apellidos, telefono, email);
                
        RequestDispatcher despachador = getServletContext().getRequestDispatcher("/Registro.jsp");
        despachador.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
