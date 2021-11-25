/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

/**
 *
 * @author 854638
 */
public class ResetPasswordServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        
        if(uuid == null){
            getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
            return;
        }
        if (uuid == ""){
            getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
            return;
        }
        else{
            request.setAttribute("uuid", uuid);
            getServletContext().getRequestDispatcher("/WEB-INF/resetPassword.jsp").forward(request, response);
            return;
        }
        
        
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        AccountService as = new AccountService();
        
        if (request.getParameter("uuid") == null){
            String url = request.getRequestURL().toString();
            String email = request.getParameter("email");
            String path = getServletContext().getRealPath("/WEB-INF");
            try{
                as.resetPassword(email, path, url);
            }catch (Exception e){
                System.out.println("This IS THE ERROR: " + e.getMessage());
            }
        }
        else{
            String password = request.getParameter("password");
            String uuid = request.getParameter("uuid");
            as.changePassword(uuid, password);
        }
        
        response.sendRedirect("login");
        
    }

    

}
