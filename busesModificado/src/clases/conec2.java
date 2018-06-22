package clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author artea
 */
public class conec2 {
    
    static Connection con=null;
    
    private static String host = "mysql5015.site4now.net";
    private static String db = "db_a3d72f_buses";
    
    private static String server = "jdbc:mysql://"+ host + "/" + db;
    private static String user = "a3d72f_buses";
    private static String pass = "huevos12";
    
    public conec2(){
        conexion();
    }
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(server,user,pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.print(e.getMessage());
        }
        return con;
    }
    
    public void insertParada(String nombre) throws SQLException{
        try{
            conexion();
        con.createStatement().execute("insert into paradas (nombre) values ('"+nombre+"')");
        System.out.println("Parada " + nombre + " Agregada Correctamente! ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
        }
    }
    public void mostrar(){
    }
}
