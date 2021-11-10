/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.Appointments;
import Business.Patient;
import Business.DbAccess;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "patientLoginServlet", urlPatterns = {"/patientLoginServlet"})
public class patientLoginServlet extends HttpServlet 
{

    
      //String DBlocation = "jdbc:ucanaccess:///Users/lalu/Classes/Senior Project/Capstone/ChiropracterWebApplication/ChiropracticDB.accdb";
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
                
                String patientSQL = ("Select * from Patients");

                    
                ResultSet crs = stmt.executeQuery(patientSQL);
                    
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                    
                String id = (request.getParameter("patID"));
                String password = (request.getParameter("PassWord"));
                    
                HttpSession session;
                session = request.getSession();
                
                DbAccess d1;
                d1 = new DbAccess();
                d1.selectPatient(id);
                System.out.println("PatientID: " + id + ", Password: " + password);      
        
                session.setAttribute("d1", d1);
                session.setAttribute("id", d1.p1.getPatientID());
                System.out.println("Patient " + d1.p1 + " added to session");
        
                if (password.equals(d1.p1.getPatientPW()))
                {
                    System.out.println(d1.p1.getPatientID() + " " + d1.p1.getPatientPW());
                    RequestDispatcher rd = request.getRequestDispatcher("/patientHub.jsp");
                    rd.forward(request, response);
                }
                else
                {
                    System.out.println(d1.p1.getPatientID() + " " + d1.p1.getPatientPW() + " is wrong, should be" + d1.p1.getPatientPW());
                    RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
                    rd.forward(request, response);
                }
        }
        catch(Exception e)
        {
            System.out.println(e);
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
