/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author ucu
 */
public class DAO_Raza {
    public void agregarRaza(String nombre, String nombreAnimal) throws SQLException{
        Connection conexion = Conexion.getInstance().establecerConexion();
         java.sql.Statement st = conexion.createStatement();
        String sql = "SELECT * FROM RAZA";
        ResultSet result = st.executeQuery(sql);
        ResultSetMetaData rsmd = result.getMetaData();
        String columnas = "";
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            columnas = columnas +  rsmd.getColumnName(i).toUpperCase() + ",";
        }
        columnas = columnas.substring(0, columnas.length() -1);        
        String sql1 =  String.format("insert into RAZA(" + columnas + ") VALUES ('%s','%s')",nombre,nombreAnimal);
        System.out.println(sql1);
        st.execute(sql1);
        st.close();
        conexion.close();
    }
    public static void main (String[] args) throws SQLException{
        DAO_Raza dao = new DAO_Raza();
        dao.agregarRaza("ROTWAILER", "PERRO");
    }
}
