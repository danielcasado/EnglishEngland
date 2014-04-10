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
public class InfoProfesor extends HttpServlet{

    String inicio = "<div id= \"superior\">\n" +
"   <div id= \"superior1\">\n" +
"<img id= \"TEE_Logo\" src=\"imagenes/LogoEnglish.jpg\">            \n" +
"<a id= \"titulo\"> The English England</a>\n" +
"           </div>\n" +
"           <div id= \"superior2\">\n" +
"<a id=\"iniciarSesion\" class=\"inicial\" href=\"Acceder.jsp\"> Iniciar sesi&oacuten</a>\n" +
"<br>\n" +
"<a id=\"registrarProfesor\" class=\"inicial\" href=\"CrearProfesor.html\">Registrar Profesor</a>\n" +
"<div  id=\"raya\"><a>|</a></div>\n" +
"<a id=\"registrarAlumno\" class=\"inicial\">Registrar Alumno</a>\n" +
"   </div>\n" +
"       </div> \n" +
"        <div id=\"izq\">\n" +
"          <div id=\"text-izq\">\n" +
"             <br>\n" +
"             <br>\n" +
"             <br>\n" +
"             <a id=\"verCursos\" class=\"casos\"> Ver Cursos</a>\n" +
"             <br>\n" +
"             <br>\n" +
"             <br>\n" +
"             <a id=\"verNiveles\" class=\"casos\"> Ver Niveles</a>\n" +
"             <br>\n" +
"             <br>\n" +
"             <br>\n" +
"             <a id=\"verProfesores\" class=\"casos\" href=\"VerProfesores\"> Ver Profesores</a>\n" +
"             <br>\n" +
"             <br>\n" +
"             <br>\n" +
"             <a id=\"inscribirCurso\" class=\"casos\"> Inscribir Curso</a>\n" +
"             <br>\n" +
"             <br>\n" +
"             <br>\n" +
"             <a id=\"verificarProfesor\" class=\"casos\"> Verificar  Profesor</a>\n" +
"             <br>\n" +
"             <br>\n" +
"             <br>\n" +
"          </div>\n" +
"       </div>\n" +
"            <div id=\"der\">";

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
        String usr = request.getParameter("user");
        VerProfesor v = new VerProfesor();
        Profesor p = v.informacionProf(usr);
        PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>"+p.getNombre()+"</title>");  
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilo.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println(inicio);
            out.println("<div id='der-cont'>");            
            out.println("<p> Nombre: " + p.getNombre()+"</p>");
            out.println("<p> Telefono: " + p.getTelefono()+"</p>");
            out.println("<p> Direccion: " + p.getDir()+"</p>");
            out.println("<p> Email: " + p.getEmail()+"</p>");
            out.println("<p> Certificados:</p><br><ul>");
            LinkedList<String> cert = p.getCertificados();
            Iterator i = cert.iterator();
            while(i.hasNext()){
                String c = (String) i.next();
                out.println("<li>"+ c +"</li>");
            }
            out.println("</ul><p> Cursos que imparte:</p><br><ul>");            
            cert = p.getCursos();
            i = cert.iterator();
            while(i.hasNext()){
                String c = (String) i.next();
                out.println("<li>"+ c +"</li>");
            }
            out.println("</ul><p> Videos:</p><br><ul>");            
            cert = p.getVideos();
            i = cert.iterator();
            while(i.hasNext()){
                String c = (String) i.next();
                out.println("<li href="+ c +">"+ c +"</li>");
            }
            out.println("</ul></div></div></body></html>");
        out.close();
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
        processRequest(request, response);
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
