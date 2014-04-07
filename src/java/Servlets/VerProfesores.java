/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Model.Profesor;
import Model.VerProfesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tsubasa
 */
public class VerProfesores extends HttpServlet {

    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            VerProfesor v = new VerProfesor();
            LinkedList <Profesor>l = v.listaProf();
            Iterator i = l.iterator();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Profesores</title>");
  
            out.println("</head>");
            out.println("<body>");
            out.println("<table  cellpadding='15' border='0'> ");
            while(i.hasNext()){
                Profesor p = (Profesor)i.next();
                out.println("<tr id="+p.getNusuario()+" class=info >");
                out.println("<p class=nombres >"+p.getNombre()+"</p>");
                out.println("</tr>");                
            }
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VerProfesor v = new VerProfesor();
        LinkedList <Profesor>l = v.listaProf();
        Iterator i = l.iterator();
        PrintWriter out = response.getWriter();            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilo.css\" />");
            out.println("<head>");
            out.println("<title>Profesores</title>");
  
            out.println("</head>");
            out.println("<body>");
            out.println("<table  cellpadding='15' border='0'> ");
                     
            while(i.hasNext()){
                Profesor p = (Profesor)i.next();
                out.println("<tr id="+p.getNusuario()+" class=info >");
                out.println("<p> Nombre: "+p.getNombre()+"</p>");
                out.println("<p> Email: "+p.getEmail()+"</p>");
                out.println("<form action='InfoProfesor' method='get'>");
                out.println("<input type='text' class=users name=user value="+p.getNusuario()+"></p>");
                out.println("<input type='submit' value='Ver informacion'>");
                out.println("</form>");
                out.println("</tr>");
            }

            out.println("</table></body></html>");
        out.close();
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Post Method</title></head>");
        out.println("<body>");
        out.println("<h1>¡Post!</h1>");
        out.println(" Nombre: <br>");
        out.println(" Password: <br>");
        //String nombre = request.getHeader("Name");
        //out.println("Tu nombre es: " + nombre);
        
        out.println("</body></html>");
        out.close();
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
