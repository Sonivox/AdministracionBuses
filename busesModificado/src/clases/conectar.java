package clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ds.desktop.notify.DesktopNotify;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author artea
 */
public class conectar {
    static Connection con=null;
    
    private static String host = "mysql5015.site4now.net";
    private static String db = "db_a3d72f_buses";
    
    private static String server = "jdbc:mysql://"+ host + "/" + db;
    private static String user = "a3d72f_buses";
    private static String pass = "huevos12";
    
        public conectar(){
            conexion();
        }
        
    public void conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(server,user,pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }

    }
   

    public void insertUsuario(int id,String usuario) throws SQLException{
        try{
     
            con.createStatement().execute("insert into usuario (id_usuario, nombre) values ('" + id + "','" + usuario + "')");
            insertUser(id, usuario);
            System.out.println("Registro Guardado con Exito!");
        }catch(SQLException e)  {
            System.out.println(e.getMessage());
        }
    }
    public void insertLogin(int id, int clave, String tipo) throws SQLException{
        try{
     
            con.createStatement().execute("insert into login (id_usuario, clave, tipo) values ('" + id + "','" + clave + "','" + tipo + "')");
            DesktopNotify.showDesktopMessage("BIENVENIDO","Registro Agregado con Exito!\nRecuerde su PIN: " + clave, DesktopNotify.SUCCESS,10000L);
            //insertUser(id, tipo);
            System.out.println("Usuario Guardado con Exito!");
        }catch(SQLException e)  {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertParada(String nombre) throws SQLException{
        try{
     
            con.createStatement().execute("insert into paradas values ('"+nombre+"')");
            insertr_parada(nombre);
            System.out.println("Parada Guardada con Exito!");
        }catch(SQLException e)  {
            System.out.println(e.getMessage());
        }
    }

     public void insertBus(String nombre, String tiempo, String precio, String tipo, String viajes, String inicio, String fin, String color) throws SQLException{
        try{
       
            PreparedStatement st = con.prepareStatement("insert into buses (nombre, tiempo, precio, tipo, viajes, inicio, final, color) values (?,?,?,?,?,?,?,?)");
            st.setString(1, nombre);
            st.setString(2, tiempo);
            st.setString(3, precio);
            st.setString(4, tipo);
            st.setString(5, viajes);
            st.setString(6, inicio);
            st.setString(7, fin);
            st.setString(8, color);
            st.execute();
            System.out.println("Bus Guardado con Exito!");
            // Añadiendo Al Registro

        }catch(SQLException e)  {
            System.out.println(e.getMessage());
        }
    }
     
     public void insertBusParada(String parada,String codigo, String nombre, String tiempo, String precio, String tipo, String viajes, String inicio, String fin, String color, String empresario) throws SQLException{
        try{
       
            PreparedStatement st = con.prepareStatement("insert into buses (parada, codigo, nombre, tiempo, precio, tipo, viajes, inicio, final, color, empresario) values (?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, parada);
            st.setString(2, codigo);
            st.setString(3, nombre);
            st.setString(4, tiempo);
            st.setString(5, precio);
            st.setString(6, tipo);
            st.setString(7, viajes);
            st.setString(8, inicio);
            st.setString(9, fin);
            st.setString(10, color);
            st.setString(11, empresario);
            st.execute();
            System.out.println("Bus Guardado con Exito!");
            insertr_bus(nombre,parada,precio,tipo);
        }catch(SQLException e)  {
            System.out.println(e.getMessage());
        }
    }

    public void updateParada(String parada, String nombre) throws SQLException{
        try{
            con.createStatement().executeUpdate("update paradas set nombre = '" + nombre + "' where nombre='"+ parada +"'");
            con.createStatement().executeUpdate("update buses set parada = '" + nombre + "' where parada='"+ parada +"'");
            modr_parada(nombre,parada);
            System.out.println("Parada Modificada Correctamente");
        }catch(SQLException e){
                System.out.println("No se pudo modificar la parada " + e.getMessage());
        }  
    }
    
    public void updateBus(String bus, String nombre, String tiempo, String precio) throws SQLException{
        try{
          
            if(tiempo.length()>0){
                con.createStatement().executeUpdate("update buses set tiempo = '" + tiempo + "' where nombre = '"+ bus +"'");
            }
            if(precio.length()>0){
                con.createStatement().executeUpdate("update buses set precio = '" + precio + "' where nombre = '"+ bus +"'");
            }
            if(nombre.length()>0){
                con.createStatement().executeUpdate("update buses set nombre = '" + nombre + "' where nombre = '"+ bus +"'");
            }
            System.out.println("Bus Modificados Correctamente");
            modr_buses(bus,nombre,precio,tiempo);
            
         }catch(SQLException e){
            System.out.println("No se pudo modificar el bus " + e.getMessage());
         }  
    }
    public void updateBus2(String codigo, String nombre) throws SQLException{
        try{
            if(nombre.length()>0){
                con.createStatement().executeUpdate("update buses set nombre = '" + nombre + "' where codigo = '"+ codigo +"'");
            }
            System.out.println("Bus Modificados Correctamente");
            modr_buses2(codigo,nombre);
            
         }catch(SQLException e){
            System.out.println("No se pudo modificar el bus " + e.getMessage());
         }  
    }
    
    public void eliminarParada(String nombre) throws SQLException{
        try{
            con.createStatement().execute("delete from paradas where nombre = '" + nombre + "'");
            con.createStatement().execute("delete from buses where parada = '" + nombre + "'");
        }catch(SQLException e){
            System.out.println("Error al eliminar " + e.getMessage());
        }   
    }
    
    public void eliminarBus(String nombre) throws SQLException{
        try{
            con.createStatement().execute("delete from buses where nombre = '" + nombre + "'");
            System.out.println("Eliminado Correctamente");
            //elimr_parada(nombre);
        }catch(SQLException e){
            System.out.println("Error al eliminar " + e.getMessage());
        }   
    }
     public void eliminarBusParada(String parada, String bus) throws SQLException{
        try{
            con.createStatement().execute("delete from buses where parada = '" + parada + "' and nombre='"+ bus +"'");
        }catch(SQLException e){
            System.out.println("Error al eliminar " + e.getMessage());
        }   
    }
    
    public boolean existeParada(String nombre){
        try {
            return con.createStatement().executeQuery("select * from paradas where nombre='"+ nombre +"'").next();
        } catch (SQLException e) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public boolean existeBus(String nombre){
        try {
            return con.createStatement().executeQuery("select * from buses where nombre='"+ nombre +"'").next();
        } catch (SQLException e) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    

    public ResultSet getBuses(String parada) throws SQLException{
        return con.createStatement().executeQuery("select * from buses where parada='"+ parada +"'");
    }
    
    public ResultSet getNullBuses() throws SQLException{
        return con.createStatement().executeQuery("select * from buses where parada is NULL");
    }
    public ResultSet getNullBus(String nombre) throws SQLException{
        return con.createStatement().executeQuery("select * from buses where parada is NULL and nombre like '"+ nombre +"'");
    }
   
    public ResultSet getParadas() throws SQLException{
        return con.createStatement().executeQuery("select * from paradas");
    }
    
     public ResultSet getBusesRegex(String regex) throws SQLException{
        return con.createStatement().executeQuery("select  * FROM buses where LOWER(nombre) like LOWER('%"+regex+"%') and parada is null");
    }
     //REGISTRO DE EVENTOS DE INSERTAR USUARIO
     public void insertUser(int id, String usuario) throws SQLException{
        try{
            PreparedStatement rt = con.prepareStatement("insert into usuario (id_usuario, nombre) values (?,?)");
            rt.setInt(1, id); 
            rt.setString(2, "Se ha añadido nuevo Usuario: "+ usuario);
            rt.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }                
    }
     //REGISTRO DE EVENTOS RECORRIDO
        public void insertr_bus(String nombre,String parada,String precio, String tipo) throws SQLException{
        try{
            PreparedStatement rt = con.prepareStatement("insert into registro (evento) values (?)");
            rt.setString(1, "Añadido "+tipo+" Ruta: "+nombre+" Costo: "+precio+" En la Parada: "+parada); 
            rt.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }                
    }
       //REGISTRO DE EVENTOS PARADA
        public void insertr_parada(String nombre){
        try{
            PreparedStatement rt = con.prepareStatement("insert into registro (evento) values (?)");
            rt.setString(1, "Parada Añadida: "+nombre); 
            rt.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }        
    }
        //REGISTRO DE EVENTOS MODIFICAR PARADA
        public void modr_parada(String ruta, String parada ){
        try{
            PreparedStatement rt = con.prepareStatement("insert into registro (evento) values (?)");
            rt.setString(1, "Modificado parada: "+parada+"a"+ruta); 
            rt.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }        
    }
        //REGISTRO DE EVENTOS MODIFICAR BUSES
        public void modr_buses(String Bus, String Nombre, String Tiempo, String Precio ){
        try{
            PreparedStatement rt = con.prepareStatement("insert into registro (evento) values (?)");
            rt.setString(1, "Modificado Bus: "+Bus+"a los siguientes valores Ruta: "+Nombre+" Precio: "+Precio+" Tiempo: "+Tiempo); 
            rt.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }        
    }
        public void modr_buses2(String Bus, String Nombre){
        try{
            PreparedStatement rt = con.prepareStatement("insert into registro (evento) values (?)");
            rt.setString(1, "Modificado Bus: "+Bus+"a los siguientes valores Ruta: "+Nombre); 
            rt.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }        
    }
        
        public void elimr_parada(String nombre){
        try{
            PreparedStatement rt = con.prepareStatement("insert into registro (evento) values (?)");
            rt.setString(1, "Eliminada la siguiente Parada: "+nombre); 
            rt.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }        
    }
       
             
        
}   
