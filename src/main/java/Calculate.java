/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zitounhe
 */
@WebServlet(urlPatterns = {"/Calculate"})
public class Calculate extends HttpServlet {

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
        
        int principal = Integer.parseInt(request.getParameter("principal"));
        double rate = Float.parseFloat(request.getParameter("rateInputName"));
        int period = Integer.parseInt(request.getParameter("period"));
        double interest=0;
        double frequency=0;
        double freqCompo=0;
        String texte = request.getParameter("interest");
        
        rate = Math.round(rate*1000)/1000;
        if(request.getParameter("interest").equals("simple")){
            interest = principal*(rate/100)*2;
        }
        if(request.getParameter("interest").equals("compound")){
            frequency= Integer.parseInt(request.getParameter("freqYears"))*365
                    + Integer.parseInt(request.getParameter("freqMonths"))*30
                    + Integer.parseInt(request.getParameter("freqWeeks"))*7
                    + Integer.parseInt(request.getParameter("freqDays"));
            freqCompo=365 / frequency;
            interest =principal*Math.pow((1+ (rate/100)/freqCompo),freqCompo*2) - principal;
            
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"    	<meta charset=\"utf-8\"/>\n" +
"        <link rel=\"stylesheet\" href=\"style.css\" />\n" +
"        <title>Calculate</title>\n" +
"    </head>\n" +
"    <body>\n" +
"        <h1>Calculate : "+interest+" of interest    </h1>		\n" +
"\n" +
"    </body>\n" +
"</html>");
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
