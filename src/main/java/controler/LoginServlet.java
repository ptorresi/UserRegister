/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import database.UserJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String logemail = request.getParameter("email");
        String logpass = request.getParameter("contraseña");
        
        UserJDBC uJdbc = new UserJDBC();
        
        User user=uJdbc.login(logemail, logpass);
        
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("logUser", user);
            response.sendRedirect("Welcome.jsp");
        }else{
            out.println("Usuario no encontrado");
        }
        
    }



}
