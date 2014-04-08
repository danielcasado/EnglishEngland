/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Model.Profesor;
import Model.VerificarProfesor;
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
 * @author arturo
 */
public class VerificarProfesores extends HttpServlet{
    
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
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            VerificarProfesor v = new VerificarProfesor();
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
     * <code>GET</codecFulanito> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VerificarProfesor v = new VerificarProfesor();
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
            out.println(inicio);
            out.println("<div id='der-cont'>");
            out.println("<table  cellpadding='15' border='0'> ");
                     
            while(i.hasNext()){
                Profesor p = (Profesor)i.next();
                out.println("<tr id="+p.getNusuario()+" class=info >");
                out.println("<p> Nombre: "+p.getNombre()+"</p>");
                out.println("<p> Email: "+p.getEmail()+"</p>");
                out.println("<p> Certificados:</p><br><ul>");
                LinkedList<String> cert = p.getCertificados();
                Iterator it = cert.iterator();
                while(it.hasNext()){
                    String c = (String) it.next();
                    out.println("<li>"+ c +"</li>");
                }

                out.println("</ul><p> Videos:</p><br><ul>");            
                cert = p.getVideos();
                it = cert.iterator();
                while(it.hasNext()){
                    String c = (String) it.next();
                    out.println("<li href="+ c +">"+ c +"</li>");
                }
                out.println("</ul><form action='BorrarProfesor' method='post'>");
                out.println("<input type='text' class=users name=user value="+p.getNusuario()+"></p>");
                out.println("<input type='submit' value='Rechazar'>");
                out.println("</form>");
                out.println("</ul><form action='AceptarProfesor' method='post'>");
                out.println("<input type='text' class=users name=user value="+p.getNusuario()+"></p>");
                out.println("<input type='submit' value='Validar'>");
                out.println("</form>");
                out.println("</tr>");
            }

            out.println("</table></div></div></body></html>");
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
