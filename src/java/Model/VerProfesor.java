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
 * @author tsubasa
 */
public class VerProfesor {
    
    public LinkedList<Profesor> listaProf(){
        LinkedList prof = new LinkedList();
        try{
            ConexionBD con = new ConexionBD();
            Connection conex = con.conectar();
            Statement stmt = conex.createStatement();
            ResultSet rs = stmt.executeQuery("select * from profesor;");
            while(rs.next()){
                Profesor p = new Profesor();
                String usr = rs.getString("nUsuario");
                p.setNusuario(usr);
                p.setNombre(rs.getString("nombre"));
                p.setEmail(rs.getString("correo"));
                p.setDir(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                Statement stmt1 = conex.createStatement();
                ResultSet rs1 = stmt1.executeQuery("select * from ensenia as e, "
                       + "curso as c where e.curso_id=e.curso_id and "
                       + "e.nUsuario='" + usr + "';");
                while(rs1.next()){
                    p.agregaCurso(rs1.getString("nivel") + " clave " 
                            + rs1.getString("curso_id"));
                }
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
    public Profesor informacionProf(String usr){
        Profesor p = new Profesor();        
        try{
            ConexionBD con = new ConexionBD();
            Connection conex = con.conectar();
            Statement stmt = conex.createStatement();
            ResultSet rs = stmt.executeQuery("select * from profesor where nUsuario='"+ usr +"';");
            rs.next();
                p.setNombre(rs.getString("nombre"));
                p.setEmail(rs.getString("correo"));
                p.setDir(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                ResultSet rs1 = stmt.executeQuery("select * from ensenia as e, "
                       + "curso as c where e.curso_id=e.curso_id and "
                       + "e.nUsuario='" + usr + "';");
                while(rs1.next()){
                    p.agregaCurso(rs1.getString("nivel") + " clave " 
                            + rs1.getString("curso_id"));
                }
                ResultSet rs2 = stmt.executeQuery("select * from certificados as c"
                        + " where c.nUsuario='" + usr + "';");                            
                while(rs2.next()){
                    p.agregaCertificado(rs2.getString("certificado"));
                }
                ResultSet rs3 = stmt.executeQuery("select * from videos as v"
                        + " where v.nUsuario='" + usr + "';");
                while(rs3.next()){
                    p.agregaVideo(rs2.getString("video"));
                }       
            con.desconectar(conex);
        }catch(Exception e){
            e.printStackTrace();
        }
        return p;
    }
    
}
