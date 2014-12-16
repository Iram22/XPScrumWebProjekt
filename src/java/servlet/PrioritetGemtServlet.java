/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import controller.Controller;
import entity.Valgfag;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bruger
 */
@WebServlet(name = "PrioritetGemtServlet", urlPatterns = {"/PrioritetGemtServlet"})
public class PrioritetGemtServlet extends HttpServlet {

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
        try{
        String navn = request.getParameter("navn");
        List fag = new ArrayList();
        fag.add(request.getParameter("1a"));
        fag.add(request.getParameter("1b"));
        fag.add(request.getParameter("2a"));
        fag.add(request.getParameter("2b"));
        
        Controller controller = new Controller();
        
        controller.gemPrioriteterIDB(navn, fag);
        
        request.getRequestDispatcher("PrioriteterRegistreret.jsp").forward(request, response);
        }
        catch(ArrayIndexOutOfBoundsException e){
        Controller controller = new Controller();
        Collection<Valgfag> valgfag = controller.hentUdvalgteFagTilFørsteRunde();
        int count = valgfag.size();
        request.setAttribute("count", count);
        request.setAttribute("valgfag", valgfag);
        request.setAttribute("error", "VÆLG 4 PRIORITETER OG UDFYLD NAVN!!!!! :@");
        request.getRequestDispatcher("sætPrioritetFørsteRunde.jsp").forward(request, response);
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
