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
public class DAO_TipoAnimal {
    
    
    
    public void agregarTipoAnimal(String nombre) throws SQLException{
        Connection conexion = Conexion.getInstance().establecerConexion();
        java.sql.Statement st = conexion.createStatement();
        String sql = "SELECT * FROM TIPO_ANIMAL";
        ResultSet result = st.executeQuery(sql);
        ResultSetMetaData rsmd = result.getMetaData();
        String columnas = "";
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            columnas = columnas +  rsmd.getColumnName(i).toUpperCase() + ",";
        }
        columnas = columnas.substring(0, columnas.length() -1);        
        String sql1 =  String.format("insert into TIPO_ANIMAL(" + columnas + ") VALUES ('%s')",nombre);
        System.out.println(sql1);
        st.execute(sql1);
        st.close();
        conexion.close();
    }
    public static void main(String[] args) throws SQLException{
        DAO_TipoAnimal dao = new DAO_TipoAnimal();
        dao.agregarTipoAnimal("ANIMAL1");
        
    }
}
