/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.Controller3;
import entity.AndenRunde;
import entity.Valgfag;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hanan
 */
@WebServlet(name = "ServletHanan", urlPatterns = {"/ServletHanan"})
public class ServletHanan extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int fpA = Integer.parseInt(request.getParameter("førsteprioritetA"));
            int apA = Integer.parseInt(request.getParameter("andenprioritetA"));
            int fpB = Integer.parseInt(request.getParameter("førsteprioritetB"));
            int apB = Integer.parseInt(request.getParameter("andenprioritetB"));
        
            Controller3 controller3 = new Controller3();
           
            Valgfag valgFPA = controller3.hentFagViaID(fpA);
            Valgfag valgAPA = controller3.hentFagViaID(apA);
            Valgfag valgFPB = controller3.hentFagViaID(fpB);
            Valgfag valgAPB = controller3.hentFagViaID(apB);

            AndenRunde resultat = new AndenRunde(3, valgFPA, valgAPA , valgFPB, valgAPB);
            controller3.gemValgAndenRunde(resultat);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
