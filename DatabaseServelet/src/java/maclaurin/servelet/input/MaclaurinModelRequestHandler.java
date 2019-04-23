/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.servelet.input;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import maclaurin.database.dbController;
import maclaurin.model.MaclaurinModel;
import maclaurin.model.MaclaurinModelImp;
import maclaurin.servelet.output.MaclaurinModelHistoryRequestHandler;

/**
 *
 * @author Bartek
 * @version 5.0
 */
@WebServlet(name = "Count", urlPatterns = {"/MMRH"})
public class MaclaurinModelRequestHandler extends HttpServlet {
    
    private Vector<Double> arguments;
    private int accuracy;
    private PrintWriter webPage;
    
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
        
        ArgumentParser argParser = new ArgumentParser( request.getParameter("ArgsX").trim() );
        
        try (PrintWriter out = response.getWriter()){
            webPage = out; // Hacking
            response.setContentType("text/html;charset=UTF-8");
            
            this.drawHead();
            try{
                arguments = argParser.parse();
                accuracy = Integer.parseInt(request.getParameter("Acc").trim());

                this.cookieAction( request.getCookies() );
                response.addCookie( new Cookie("lastACC", request.getParameter("Acc")) );
                
                Vector<Double> result = this.getResult(arguments, accuracy);
                
                this.drawResult(result);  
            }catch(Exception e){
                out.println("ERROR: " + e.getMessage());
            }
            this.drawFoot();
        }
    }
    
    /**
     * Draws head
     */
    private void drawHead(){
        webPage.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"bormok.css\">");
        webPage.println("<h1>Results: </h1>");
    }
    
    /**
     * Do action with cookies
     * @param COOKIEEEES all cookies
     */
    private void cookieAction(Cookie[] COOKIEEEES){
        if(COOKIEEEES == null){
            return;
        }
        for (Cookie cookie : COOKIEEEES) {
             if (cookie.getName().equals("lastACC")) {
                 webPage.print( "Last accuracy: " + cookie.getValue() );
             }
         }
         
    }
    
    /**
     * Draws results
     * @param result results
     */
    
    private void drawResult(Vector<Double> result) throws Exception{
        dbController dataBase = new dbController();
        
        webPage.print("<pre id='result'>");
        webPage.println("Accuracy: " + accuracy);
        
        for( Double row : result ){
            int index = result.indexOf(row);
            webPage.println("[" + index + "] Argument: " + arguments.get(index) + ", Result: " + row);
            String Query = "INSERT INTO RESULTS VALUES (" + row + "," + arguments.get(index) + "," + accuracy + ")";
            dataBase.executeUpdate(Query);
        }

        webPage.print("</pre>");
    }
    
    /**
     * Draws footer
    */
    private void drawFoot(){
        webPage.println("<div><input class='back-button pointerOnHover' type='button' value='Back' onclick='history.back()'/></div>");
    }
    
    /**
     * get results
     * @param arguments arguments from form
     * @param accuracy accuracy from form
     * @return results
     * @throws Exception might occur inside model exception
     */
    private Vector<Double> getResult(Vector<Double> arguments, int accuracy) throws Exception{
        MaclaurinModel ModelInstance = MaclaurinModelImp.getInstance();
        
        ModelInstance.setAccuracy(accuracy);
        ModelInstance.setManyArguments(arguments);
        
        return ModelInstance.getManyResults();
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
