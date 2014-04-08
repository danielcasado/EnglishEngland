/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.LinkedList;

/**
 *
 * @author tsubasa
 */
public class Profesor {
    private String nombre;
    private String telefono;
    private String dir;
    private String email;
    private String nusuario;
    private boolean verificado;
    private LinkedList <String> cursos;
    private LinkedList <String> certificados;
    private LinkedList <String> videos;
    
    public Profesor(){
         this.cursos = new LinkedList();
         this.videos = new LinkedList();
         this. certificados = new LinkedList();
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getTelefono(){
        return telefono;
    }
    public void setDir(String dir) {
        this.dir = dir;
    }
    
    public String getDir(){
        return dir;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    public void setNusuario(String usuario) {
        this.nusuario = usuario;
    }
    
    public String getNusuario(){
        return nusuario;

    }    
    public void agregaCertificado(String certificado) {
        certificados.add(certificado);
    }
    
    public void setVerificado(boolean verificado){
        this.verificado = verificado;
    }
    
    public boolean getVerificado(){
        return verificado;
    }
    
    public LinkedList<String> getCertificados(){
        return certificados;
    }
    
    public void agregaVideo(String video) {
        videos.add(video);
    }
    
    public LinkedList<String> getVideos(){
        return videos;
    }
    public void agregaCurso(String curso) {
        cursos.add(curso);
    }
    
    public LinkedList<String> getCursos(){
        return cursos;
    }
}
