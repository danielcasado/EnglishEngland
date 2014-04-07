package Controlador;

import java.sql.*;

public class ConexionBD{
  
  private String driver;
    private String cadenaCon;
    private String userName;
    private String password;
	
  public ConexionBD() {
        driver ="com.mysql.jdbc.Driver";
        cadenaCon = "jdbc:mysql://localhost:3306/TEE";
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
        try {
              if( cn != null && ! cn.isClosed() ) {
                  cn.close();
               }
            }
         catch( SQLException e ) {
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
	
	while(rs.next())
	{
	  String user = rs.getString("nUsuario");
	  String contrasenia = rs.getString("contrasenia");
	  String nombre = rs.getString("nombre");
	  String correo = rs.getString("correo");
	  String direccion = rs.getString("direccion");
	  String telefono = rs.getString("telefono");
	}
	
	con.desconectar(conex);
      }
      catch(Exception e)
      {
	e.printStackTrace();
      }
  }

}