/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Model.Curso;
import Model.VerNiveles;
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
public class VerNivel extends HttpServlet {
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
        PrintWriter out = response.getWriter();
        try {
            VerNiveles v = new VerNiveles();
            LinkedList <Curso>l = v.listaCurso(request.getParameter("nivel"));
            Iterator i = l.iterator();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilo.css\" />");
            out.println("<title>Cursos</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println(inicio);            
            out.println("<div id='der-cont'>");
            out.println("<h1>"+request.getParameter("nivel")+"</h1>");
            out.println("<table  cellpadding='12'> ");
            out.println("<tr class=info >");
            out.println("<td class=info >Profesor");
            out.println("</td>");   
            out.println("<td class=info >ID");
            out.println("</td>"); 
            out.println("<td class=info >Hora Inicio");
            out.println("</td>");
            out.println("<td class=info >Hora Final");
            out.println("</td>");
            out.println("<td class=info >Fecha Inicio");
            out.println("</td>");
            out.println("<td class=info >Fecha Final");
            out.println("</td>");
            out.println("<td class=info >");
            out.println("</td>");
            out.println("</tr>");
            while(i.hasNext()){
                Curso c = (Curso)i.next();
                String id = c.getCurso_id();
                out.println("<tr class=info >");
                out.println("<td>"+c.getProfesor()+"</td>");
                out.println("<td>"+c.getCurso_id()+"</td>");                
                out.println("<td>"+c.getHora_Inicio()+"</td>");
                out.println("<td>"+c.getHora_Final()+"</td>");
                out.println("<td>"+c.getFecha_Inicio()+"</td>");
                out.println("<td>"+c.getFecha_Final()+"</td>");
                out.println("</tr>");
            }
            out.println("</table></div></div></body></html>");
        } finally {            
            out.close();
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
