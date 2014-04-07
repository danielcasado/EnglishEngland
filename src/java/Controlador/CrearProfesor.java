/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sango
 */
public class CrearProfesor extends HttpServlet {
    
    ConexionBD con;
    
    public CrearProfesor()
    {
        
            con = new ConexionBD();
        
    }
    
    public void subirProfesor(String user, String pw, String nombre, String correo, String dir, String tel)
    {
        try {
            
            Connection conex = con.conectar();
            Statement stmt = conex.createStatement();
            
            stmt.execute("insert into profesor (nUsuario,contrasenia,nombre,correo,direccion,telefono)"
                + " values ('" + user + "','" + pw + "','" + nombre + "','" + correo + "','" + dir + "','" + tel  + "');");
            
            con.desconectar(conex);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean repetido(String user)
    {
        try {
            Connection conex = con.conectar();
            Statement stmt = conex.createStatement();
            
            ResultSet rs = stmt.executeQuery("select nUsuario from profesor "
                    + "where nUsuario = '" + user + "';");
            
            return rs.next();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return true;
        }
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
        
        String mensajeIHead = "<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>The English England</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/mensaje.css\" />        \n" +
"    </head>\n" +
"    <body>\n" +
"        <div id= \"superior\">\n" +
"		    <div id= \"superior1\">\n" +
"				<img id= \"TEE_Logo\" src=\"imagenes/LogoEnglish.jpg\">            \n" +
"				<a id= \"titulo\"> The English England</a>\n" +
"            </div>\n" +
"            <div id= \"superior2\">\n" +
"				<a id=\"iniciarSesion\" class=\"inicial\"> Iniciar sesi&oacuten</a>\n" +
"				<br>\n" +
"				<a id=\"registrarProfesor\" class=\"inicial\" href=\"CrearProfesor.html\">Registrar Profesor</a>\n" +
"				<div  id=\"raya\"><a>|</a>\n" +
"				</div>\n" +
"				<a id=\"registrarAlumno\" class=\"inicial\">Registrar Alumno</a>\n" +
"		    </div>\n" +
"        </div>\n" +
"        \n" +
"        <div id=\"izq\">\n" +
"		    <div id=\"text-izq\">\n" +
"				<a id=\"verCursos\" class=\"casos\"> Ver Cursos</a>\n" +
"				<br>\n" +
"				<br>\n" +
"				<br>\n" +
"				<a id=\"verNiveles\" class=\"casos\"> Ver Niveles</a>\n" +
"				<br>\n" +
"				<br>\n" +
"				<br>\n" +
"				<a id=\"inscribirCurso\" class=\"casos\"> Inscribir Curso</a>\n" +
"				<br>\n" +
"				<br>\n" +
"				<br>\n" +
"				<a id=\"verificarProfesor\" class=\"casos\"> Verificar  Profesor</a>\n" +
"		    </div>\n" +
"   	    </div>\n" +
"   	    <div id=\"cuerpo\">\n" +
"   	    		<p class=\"mensaje\">";
        String mensajeIHTail = "</p><br><br>\n" +
"	   	    	<div id=\"botonMenuDiv\">\n" +
"	   	    		<form action=\"index.html\">\n" +
"		   	    		<input type=\"submit\" id=\"botonMenu\" value=\"Men&uacute\">\n" +
"		   	    	</form>\n" +
"	   	    	</div>\n" +
"	   	</div>\n" +
"    </body>\n" +
"</html>\n";
        
        
        String usuario = request.getParameter("usuario");
        String nombre = request.getParameter("nombre");
        String pw = request.getParameter("password");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        
        out.print(mensajeIHead);
        
        if(usuario == "" || nombre == "" || pw == "" || direccion == "" || telefono == "" || correo == "")
        {
            
            out.print("Faltaron los siguientes campos:</p>");
            if(usuario == "")
                out.print("<p class=\"lista\">- Usuario</p>");
            if(pw == "")
                out.print("<p class=\"lista\">- Password</p>");
            if(nombre == "")
                out.print("<p class=\"lista\">- Nombre</p>");
            if(direccion == "")
                out.print("<p class=\"lista\">- Direccion</p>");
            if(telefono == "")
                out.print("<p class=\"lista\">- Telefono</p>");
            if(correo == "")
                out.print("<p class=\"lista\">- Correo</p>");
            out.print("<p>");
        }
        else if(repetido(usuario))
        {
            
            out.print("Ya existe un profesor con el usuario " + usuario);
            
        }
        else
        {
            this.subirProfesor(usuario, pw, nombre, correo, direccion, telefono);
            out.print("Profesor " + nombre + " registrado");
        }
        
        out.print(mensajeIHTail);
        
        out.close();
    }
}
