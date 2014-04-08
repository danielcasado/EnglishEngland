/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author arturo
 */
public class VerificarProfesor {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    public LinkedList<Profesor> listaProf(){
        LinkedList prof = new LinkedList();
        try{
            ConexionBD con = new ConexionBD();
            Connection conex = con.conectar();
            Statement stmt = conex.createStatement();
            ResultSet rs = stmt.executeQuery("select * from profesor where verificado=false;");
            while(rs.next()){
                Profesor p = new Profesor();
                String usr = rs.getString("nUsuario");
                p.setNusuario(usr);
                p.setNombre(rs.getString("nombre"));
                p.setEmail(rs.getString("correo"));
                p.setDir(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                Statement stmt2 = conex.createStatement();
                ResultSet rs2 = stmt2.executeQuery("select * from certificados as c"
                        + " where c.nUsuario='" + usr + "';");                            
                while(rs2.next()){
                    p.agregaCertificado(rs2.getString("certificado"));
                }
                Statement stmt3 = conex.createStatement();                
                ResultSet rs3 = stmt3.executeQuery("select * from videos as v"
                        + " where v.nUsuario='" + usr + "';");
                while(rs3.next()){
                    p.agregaVideo(rs2.getString("video"));
                }
                prof.add(p);
            }
            con.desconectar(conex);
        }catch(Exception e){
            e.printStackTrace();
        }
        return prof;
    }
    public void aceptaProf(String usr){
        try{
            ConexionBD con = new ConexionBD();
            Connection conex = con.conectar();
            Statement stmt = conex.createStatement();
            stmt.executeUpdate("update profesor set verificado=true where nUsuario='"+ usr +"';");
            con.desconectar(conex);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void borraProf(String usr){
        try{
            ConexionBD con = new ConexionBD();
            Connection conex = con.conectar();
            Statement stmt = conex.createStatement();
            stmt.executeUpdate("delete from profesor where nUsuario='"+ usr +"';");
            con.desconectar(conex);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
