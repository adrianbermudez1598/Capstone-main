/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.DbAccess;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "chiroEditServlet", urlPatterns = {"/chiroEditServlet"})
public class chiroEditServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String an =request.getParameter("an");
        String cid =request.getParameter("cid");
        String cn =request.getParameter("cn");
        String pid =request.getParameter("pid");
        String pn =request.getParameter("pn");
        String month =request.getParameter("month");
        String day =request.getParameter("day");
        String year =request.getParameter("year");
        System.out.println(" an "+ an+" cid "+ cid+" cn "+ cn+" pid "+ pid+" pn "+ pn+" month "+month +" day "+ day+" year "+ year);
        
        DbAccess d1 = new DbAccess();
        d1.updateAppointment(an, year, month, day, pid, pn, cid, cn);
        
        d1.selectChiropractor(cid);
        
        HttpSession session;
        session = request.getSession();
        
        session.setAttribute("d1", d1);
        session.setAttribute("id", d1.c1.getChiropractorID());
        
        RequestDispatcher rd = request.getRequestDispatcher("chiroViewAppointment.jsp");
        rd.forward(request, response);
        
        
        
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
