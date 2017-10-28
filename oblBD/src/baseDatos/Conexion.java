/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author ucu
 */
public class Conexion {
        private static Conexion conexion=null;
        private Conexion(){
            
        }
        public static Conexion getInstance(){
            if(conexion==null) {
                conexion=new Conexion();
            }
            return conexion;

        }
    
        private String[] datos = new String[3];
        private String url = "jdbc:postgresql://localhost:3000/obligatorio";
        private String usuario = "postgres";
        private String contraseña = "a";
        public Connection establecerConexion(){
            try{
                Class.forName("org.postgresql.Driver");
                Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
                return conexion;
                }
            catch(Exception e){
                    System.out.println("ERROR DE CONEXION " + e.getMessage());
                    return null;
            }
        }
        
}
