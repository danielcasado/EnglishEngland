<%-- 
    Document   : Acceder
    Created on : 7/04/2014, 09:42:44 PM
    Author     : tsubasa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceder</title>
        <link rel='stylesheet' type='text/css' href='css/estilo.css' />      
    </head>
    <body>
       <div id= "superior">
   <div id= "superior1">
<img id= "TEE_Logo" src="imagenes/LogoEnglish.jpg">            
<a id= "titulo"> The English England</a>
           </div>
           <div id= "superior2">
<a id="iniciarSesion" class="inicial" href="Acceder.jsp"> Iniciar sesi&oacuten</a>
<br>
<a id="registrarProfesor" class="inicial" href="CrearProfesor.html">Registrar Profesor</a>
<div  id="raya"><a>|</a></div>
<a id="registrarAlumno" class="inicial">Registrar Alumno</a>
   </div>
       </div> 
        <div id="izq">
          <div id="text-izq">
             <br>
             <br>
             <br>
             <a id="verCursos" class="casos"> Ver Cursos</a>
             <br>
             <br>
             <br>
             <a id="verNiveles" class="casos"> Ver Niveles</a>
             <br>
             <br>
             <br>
             <a id="verProfesores" class="casos" href="VerProfesores"> Ver Profesores</a>
             <br>
             <br>
             <br>
             <a id="inscribirCurso" class="casos"> Inscribir Curso</a>
             <br>
             <br>
             <br>
             <a id="verificarProfesor" class="casos"> Verificar  Profesor</a>
             <br>
             <br>
             <br>
          </div>
       </div>
            <div id="der">
                <form name="input" action="AccedeCuenta" method="post" id="myFormGet">
                    Usuario: <input type="text" name="user"><br>
                    Contraseña: <input type="password" name="contra"><br>
                    <input type="submit" value="Ingresar">
                </form>                
          </div>
    </body>
</html>
