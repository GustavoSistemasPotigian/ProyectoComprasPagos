package BaseDeDatos;

import java.sql.*;
import javax.swing.JOptionPane;
  
///clase que conecta con la base de datos potigianBase en MySQL
public class ConexionMySQL {
    //variableq que guarda los datos de conexion
    public String db="potigianbase";
    public String URL="jdbc:mysql://localhost/"+db;
    public String user= "root";
    public String pass="";

public ConexionMySQL()
{

}
    //clase para Conectar a la base de datos con url guardada en variable
   //Devuelve objeto del tipo Connection
    public Connection Conectar(){
       
        Connection link= null;
        try
        {
            Class.forName("org.gjt.mm.mysql.Driver");
            
            link= DriverManager.getConnection(this.URL, this.user,this.pass);
                        
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, pass);
        
        }
    return link;
    }

}   

