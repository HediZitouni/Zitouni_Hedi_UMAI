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
@WebServlet(urlPatterns = {"/DisplayFields"})
public class DisplayFields extends HttpServlet {

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
        
        
        String interest=request.getParameter("interest");
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            
            out.println("<!DOCTYPE html>\n" +
" <html>\n" +
"    <head>            \n" +
"        <meta charset=\"utf-8\"/>\n" +
"        <link rel=\"stylesheet\" href=\"style.css\" />\n" +
"        <title>MainMenu</title>\n" +
"    </head>\n" +
"\n" +
"    <body>\n" +
"\n" +
"        <header>\n" +
"            <h1>Information</h1>\n" +
"        </header>\n" +
"\n" +
"        <form method=\"post\" action=\"Calculate\">\n" +
"\n" +
"            <div class=\"titleRequest\">Principal</div>\n" +
"            <input type=\"number\" name=\"principal\">\n" +
"            \n" +
"            <div class=\"titleRequest\">Rate of Interest</div>\n" +
"            <input type=\"range\" name=\"rateInputName\" id=\"rateInputId\" value=\"5\" min=\"1\" max=\"20\" step=\"0.1\" oninput=\"rateOutputId.value = rateInputId.value\">\n" +
"            		<output class=\"displayRange\" name=\"rateOutputName\" id=\"rateOutputId\">5</output>\n" +
"            \n" +
"            <div class=\"titleRequest\">Period(Months)</div>\n" +
"            <input type=\"number\" name=\"period\" />\n" +
"            \n" +
"            \n" +
"                       	\n");
            if(interest.equals("compound")){
            out.println(
"            <div class=\"titleRequest\">Frequency</div>\n" +
"            <input type=\"number\" name=\"freqYears\" /> <span class=\"optionNumber\">Years</span></br>\n" +
"                	<input type=\"number\" name=\"freqMonths\" /> <span class=\"optionNumber\">Months</span></br>\n" +
"                	<input type=\"number\" name=\"freqWeeks\" /> <span class=\"optionNumber\">Weeks</span></br>\n" +
"                	<input type=\"number\" name=\"freqDays\" /> <span class=\"optionNumber\">Days</span></br>\n" +
"            \n" +
"            \n"
        );
            }
            out.println(
"            <input name=\"interest\" type=\"hidden\" value="+interest+">\n" +
"            <input type=\"submit\" value=\"Calculate\" />\n" +
"\n" +
"        </form>\n" +
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
