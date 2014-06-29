/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dvala;

import com.malin.Malin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
//import redis.clients.jedis.Jedis;

/**
 *
 * @author Valera
 */


//@WebServlet(name="dvala",urlPatterns = "dvala")
//@ServletSecurity(
//@HttpConstraint(transportGuarantee = ServletSecurity.TransportGuarantee.NONE,rolesAllowed={"admin"}))
@Controller
public class Dvala {
    //Jedis jedis = new Jedis("localhost");
    @RequestMapping(value = "/dvala")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Dvala</title>");            
            out.println("</head>");
            out.println("<body>");
            
            Malin m1 = (Malin) request.getSession().getAttribute("malin");
            if(m1==null)             {
            
            try {
                InitialContext ic = new InitialContext();
                m1 = (Malin) ic.lookup("java:global/alvine/malin-1/Malin");
                request.getSession().setAttribute("malin", m1);
            } catch (NamingException ex) {
                Logger.getLogger(Dvala.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
            
            out.println("<h1>Here " + m1.getCount() + "</h1>");
            out.println("<h1>Here " + RequestContextHolder.currentRequestAttributes().getSessionId() + "</h1>");
//            out.println("<form class=\"form-inline\" action=\"logout\" method=\"post\">");
//            out.println("<input type=\"submit\" value=\"Log out\" />");
//            out.println("<input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\"/>");
//            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}
