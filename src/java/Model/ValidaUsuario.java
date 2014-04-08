/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tsubasa
 */
public class ValidaUsuario {
    public String validar(String usr, String cont){
        try{
            ConexionBD con = new ConexionBD();
            Connection conex = con.conectar();
            Statement stmt = conex.createStatement();
            ResultSet rs = stmt.executeQuery("select * from profesor where nUsuario='"+usr+"';");
            if(rs.next()){
                String c=rs.getString("contrasenia");
                if(c.equals(cont)){
                    return "prof";
                }
                return "err";
            }
            stmt = conex.createStatement();
            rs = stmt.executeQuery("select * from estudiante where nUsuario='"+usr+"';");
            if(rs.next()){
                String c=rs.getString("contrasenia");
                if(c.equals(cont)){
                    return "est";
                }
                return "err";
            }
            stmt = conex.createStatement();
            rs = stmt.executeQuery("select * from admin where nUsuario='"+usr+"';");
            if(rs.next()){
                String c=rs.getString("contrasenia");
                if(c.equals(cont)){
                    return "admin";
                }
                return "err";
            }
        }catch(Exception e){
            
        }
        
        return "none";
    }
}
