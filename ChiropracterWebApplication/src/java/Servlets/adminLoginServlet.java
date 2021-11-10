/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.DbAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jaru
 */
@WebServlet(name = "adminLoginServlet", urlPatterns = {"/adminLoginServlet"})
public class adminLoginServlet extends HttpServlet 
{
    //String DBlocation = "jdbc:ucanaccess:///Users/lalu/Documents/GitHub/Capstone/ChiropracterWebApplication/ChiropracticDB.accdb";
    String DBlocation ="jdbc:ucanaccess://C:/Users/Jaru/Documents/GitHub/Capstone/ChiropracterWebApplication/ChiropracticDB.accdb";
    //String DBlocation ="jdbc:ucanaccess://C:/Users/kerds/Documents/GitHub/Capstone/ChiropracterWebApplication/ChiropracticDB.accdb";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {  
        try 
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            Connection con;
            con=DriverManager.getConnection(DBlocation);           
            Statement stmt = con.createStatement();            
            String adminSQL = ("Select * from Admin");
            ResultSet crs = stmt.executeQuery(adminSQL);
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            String id = (request.getParameter("adminID"));
            String password = (request.getParameter("PassWord"));
            String adMinSQL = ("select * from Admin where adminID = '" + id + "'");
            ResultSet rt = stmt.executeQuery(adMinSQL);
            
             DbAccess d1;
            d1 = new DbAccess();             
            d1.selectAdmin(id);
            
            HttpSession session;
            session = request.getSession();
            
            System.out.println("AdminID: " + id + ", Password: " + password);
            session.setAttribute("d1", d1);
            session.setAttribute("id", d1.ad1.getAdminID());
            System.out.println("Patient " + d1.ad1 + " added to session");
        
                if (password.equals(d1.ad1.getAdminPassword()))
                {
                    System.out.println(d1.ad1.getAdminID() + " " + d1.ad1.getAdminPassword());
                    RequestDispatcher rd = request.getRequestDispatcher("/adminHub.jsp");
                    rd.forward(request, response);
                }
                else
                {
                    System.out.println(d1.ad1.getAdminID() + " " + d1.ad1.getAdminPassword() + " is wrong, should be" + d1.ad1.getAdminPassword());
                    RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
                    rd.forward(request, response);
                }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
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
