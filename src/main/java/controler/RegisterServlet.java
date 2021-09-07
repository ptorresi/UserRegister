/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import database.UserJDBC;
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
import javax.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author ptorr
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String nombre = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        
        User userModel = new User(nombre,email,pass);
        
        //Crea el modelo de datos
        UserJDBC uJdbc = new UserJDBC();
        try {
            if(uJdbc.AgregarDatos(userModel)){
                    response.sendRedirect("index.jsp");
            }else{
                String errorMessage = "Usuario Disponible";
                HttpSession regSession = request.getSession();
                regSession.setAttribute("RegError", errorMessage);
                response.sendRedirect("register.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }       

 

}
