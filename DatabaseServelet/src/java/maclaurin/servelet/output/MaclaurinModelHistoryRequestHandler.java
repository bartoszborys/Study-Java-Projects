/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.servelet.output;

import maclaurin.servelet.input.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import maclaurin.database.dbController;

/**
 *
 * @author Bartek
 * @version 5.0
 */
@WebServlet(name = "History", urlPatterns = {"/MMHRH"})
public class MaclaurinModelHistoryRequestHandler extends HttpServlet {

    private static PrintWriter webPage; 
    
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
            webPage = out;
            
            this.drawHead();
            
            try{
                int count = Integer.parseInt( request.getParameter("count") );
                this.drawContent(count);
            }catch(Exception e){
                webPage.print("ERROR: " + e.getMessage());
            }
            
            this.drawFoot();
        }
    }
    
    /**
     * Draws head
     */
    private void drawHead(){
        webPage.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"bormok.css\">");
        webPage.println("<h1>History: </h1>");
    }
    
    /**
     * draws content
     * @param count Count of history results to draw
     */
    private void drawContent(int count){
        webPage.print("<pre id='history'>");        
        int counter = 0;
        
        dbController dataBase = new dbController();
        
        for(Double result : dataBase.getHistory(count)){
            if(counter == count){
                break;
            }
            webPage.println("[" + counter + "]: " + result);
            counter++;
        }
        webPage.print("</pre>");
    }
    
    /**
     * draws foot
     */
    private void drawFoot(){
        webPage.println("<div><input class='back-button pointerOnHover' type='button' value='Back' onclick='history.back()'/></div>");
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
