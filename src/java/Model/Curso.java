/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

//import java.sql.Time;
//import java.sql.Date;
//import java.util.Date;
//import java.util.LinkedList;


/**
 *
 * @author arturo
 */
public class Curso {
    private String curso_id;
    private String nivel;
    private String fecha_Inicio;
    private String fecha_Final;
    private String hora_Inicio;
    private String hora_Final;
    private String profesor;
    
/*  Faltan los date y time.
    private LinkedList <String> cursos;
    private LinkedList <String> certificados;
    private LinkedList <String> videos;
    
    curso_id varchar(10) not null,
    nivel varchar(13) not null,
    Fecha_Inicio date not null,
    Fecha_Final date not null,
    Hora_Inicio time not null,
    Hora_Final time not null,
*/
    
    public void setCurso_id(String curso_id) {
        this.curso_id = curso_id;
    }
    
    public String getCurso_id(){
        return curso_id;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    public String getNivel(){
        return nivel;
    }
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    
    public String getProfesor(){
        return profesor;
    }
    
    public void setFecha_Inicio(String fecha_Inicio){
        this.fecha_Inicio = fecha_Inicio;
    }

    public String getFecha_Inicio(){
        return fecha_Inicio;
    }

    public void setFecha_Final(String fecha_Final){
        this.fecha_Final = fecha_Final;
    }
    
    public String getFecha_Final(){
        return fecha_Final;
    }
    
    public void setHora_Inicio(String hora_Inicio){
        this.hora_Inicio = hora_Inicio;
    }
    
    public String getHora_Inicio(){
        return hora_Inicio;
    }
    
    public void setHora_Final(String hora_Final){
        this.hora_Final = hora_Final;
    }
    
    public String getHora_Final(){
        return hora_Final;
    }
    
}
