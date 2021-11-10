/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.Chiropractor;
import Business.DbAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kerds
 */
@WebServlet(name = "chiroLoginServlet", urlPatterns = 
{
    "/chiroLoginServlet"
})
public class chiroLoginServlet extends HttpServlet
{

    //String DBlocation = "jdbc:ucanaccess:///Users/lalu/Documents/GitHub/Capstone/ChiropracterWebApplication/ChiropracticDB.accdb";
    String DBlocation ="jdbc:ucanaccess://C:/Users/Jaru/Documents/GitHub/Capstone/ChiropracterWebApplication/ChiropracticDB.accdb";
    //String DBlocation ="jdbc:ucanaccess://C:/Users/kerds/Documents/GitHub/Capstone/ChiropracterWebApplication/ChiropracticDB.accdb";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        /******************************
         * DRIVER STEPS
         *****************************/
                    //Load Driver - Step #1
                try {
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                //Get Connection from the Driver - Step #2
                    Connection con;
                    con=DriverManager.getConnection(DBlocation);
                //Create a Statement - Step #3
                    Statement stmt = con.createStatement(); 
                //Execute Statement - Step #4
                    String chiroSQL = ("select * from Chiropractors");

                    
                    ResultSet crs = stmt.executeQuery(chiroSQL);
                    
                //Process through the Data - Step #5
                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = response.getWriter();        
        //END DRIVER STATMENTS
        
        
        /***RECEIVE AND PROCESS ID and PASSWORD INPUT****/
        String id = (request.getParameter("userID"));       //Stores input from index:userID field 
        String pw = request.getParameter("passWord");       //Stores input from index:passWord field
        
        //Put Object in session
        HttpSession session;
        session = request.getSession();

        //Chiropractor c1;    //Crates new Chiropractor
        //c1 = new Chiropractor();
        
        DbAccess d1;
        d1 = new DbAccess();
        d1.selectChiropractor(id);
        System.out.println("UserID: " + id + ", User Password: " + pw);      
        
        session.setAttribute("d1", d1);
        session.setAttribute("id", d1.c1.getChiropractorID());
        System.out.println("Chiropractor " + d1.c1 + " added to session");
        if (pw.equals(d1.c1.getChiropractorPW()))
        {
            System.out.println(d1.c1.getChiropractorID() + " " + d1.c1.getChiropractorPW());
            RequestDispatcher rd = request.getRequestDispatcher("/chiroHub.jsp");
            rd.forward(request, response);
        }
        else
        {
            System.out.println(d1.c1.getChiropractorID() + " " + d1.c1.getChiropractorPW() + " is wrong, should be" + d1.c1.getChiropractorPW());
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }

                    }
                    catch(Exception se) // Ends from Driver steps
                        {
                        System.out.println(se);
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
    
}
