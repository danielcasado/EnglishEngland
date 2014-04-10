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

/**
 *
 * @author arturo
 */
public class InscribirCurso {
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    public LinkedList<Curso> listaCurso(){
        LinkedList curso = new LinkedList();
        try{
            ConexionBD con = new ConexionBD();
            Connection conex = con.conectar();
            Statement stmt = conex.createStatement();
            ResultSet rs = stmt.executeQuery("select * from curso;");
            while(rs.next()){
                Curso c = new Curso();
                String id=rs.getString("curso_id");
                c.setCurso_id(id);
                c.setNivel(rs.getString("nivel"));
                c.setHora_Inicio(rs.getString("Hora_Inicio"));
                c.setHora_Final(rs.getString("Hora_Final"));
                c.setFecha_Inicio(rs.getString("Fecha_Inicio"));
                c.setFecha_Final(rs.getString("Fecha_Final"));
                Statement stmt1 = conex.createStatement();
                ResultSet rs1 = stmt1.executeQuery("select * from ensenia as e, "
                       + "profesor as p where p.nUsuario=e.nUsuario and "
                       + "curso_id='" + id + "';");
                if(rs1.next()){
                    c.setProfesor(rs1.getString("nombre"));
                }
                curso.add(c);
            }
            con.desconectar(conex);
        }catch(Exception e){
            e.printStackTrace();
        }
        return curso;
    }
        
    public void inscribir(String curso_id, String nusuario){
        try{
            ConexionBD con = new ConexionBD();
            Connection conex = con.conectar();
            Statement stmt = conex.createStatement();
            stmt.executeUpdate("insert into atiende (curso_id, nUsuario) values ('" + curso_id + "','" + nusuario + "');" );
            con.desconectar(conex);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
