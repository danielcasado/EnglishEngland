/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author d01000100
 */
public class ConexionBD{
 
    private String driver;
    private String cadenaCon;
    private String userName;
    private String password;
	
    
 /**
  * Esto es lo que capaz tengan que cambiar!!!!!
  */
  public ConexionBD() {
        driver ="com.mysql.jdbc.Driver";
        cadenaCon = "jdbc:mysql://localhost:3306/EnglishEngalnd";
        userName = "root";
        password = "";
    }
  
  public Connection conectar() throws ClassNotFoundException {
        Connection cn;
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(cadenaCon, userName, password);
            return cn;
        } catch (SQLException ex) {
            System.out.println("error: " + ex);
            return null;
        }
    }
  
    public void desconectar( Connection cn ) {
	try{
	    if( cn != null && ! cn.isClosed() ) {
		cn.close();
	    }
	}catch( SQLException e ) {
            e.printStackTrace();
	}
    }
  public static void main(String[] pps)
  {
      try
      {
	ConexionBD con = new ConexionBD();
      
	Connection conex = con.conectar();
	Statement stmt = conex.createStatement();
	ResultSet rs = stmt.executeQuery("select * from profesor;");
        Scanner in = new Scanner(System.in);
	
	while(rs.next())
	{
	  String user = rs.getString("nUsuario");
	  String contrasenia = rs.getString("contrasenia");
	  String nombre = rs.getString("nombre");
	  String correo = rs.getString("correo");
	  String direccion = rs.getString("direccion");
	  String telefono = rs.getString("telefono");
          
          System.out.println("Profesor Registrado: " + user + " " + contrasenia + " " + nombre + " " + correo + " " + direccion + " " + telefono);
          
       
	}
        
        System.out.println("Escribe un nuevo nombre");
        
        String nuevoNombre = in.next();
        
        System.out.println("Escribe una nueva contrasenia");
        
        String nuevaPw = in.next();
        
        stmt.execute("insert into profesor (nUsuario,contrasenia,nombre,correo,direccion,telefono)"
                + " values ('42','" + nuevoNombre + "','" + nuevaPw + "','hacemeun@kease','av. siempre viva','45678');");
	
	con.desconectar(conex);
      }
      catch(Exception e)
      {
	e.printStackTrace();
      }
  }

}
