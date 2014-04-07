/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author sango
 */
public class MyBean {
    String nombre;
    String password;
    boolean conectado;
    String tipo;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
    
    public boolean getConectado(){
        return conectado;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return tipo;
    }
}
