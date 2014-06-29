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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Valera
 */
@Controller
public class Rest {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @RequestMapping(value = "/rest")
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Cache-Control", "no-cache");
        response.setContentType("text/javascript;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Malin m1 = (Malin) request.getSession().getAttribute("malin");
        if (m1 == null) {
            try {
                InitialContext ic = new InitialContext();
                m1 = (Malin) ic.lookup("java:global/alvine/malin-1/Malin");
                request.getSession().setAttribute("malin", m1);
            } catch (NamingException ex) {
                Logger.getLogger(Rest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        out.println("{\"value\":\"" + m1.getCount() + "\"}");
    }

}
