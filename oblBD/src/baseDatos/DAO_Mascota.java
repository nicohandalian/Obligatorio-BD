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
public class DAO_Mascota {
    
    public void agregarMascota(String nombre, char sexo, int chip,String ciDueño, String raza,String foto) throws SQLException{
        Connection conexion = Conexion.getInstance().establecerConexion();
         java.sql.Statement st = conexion.createStatement();
        String sql = "SELECT * FROM MASCOTA";
        ResultSet result = st.executeQuery(sql);
        ResultSetMetaData rsmd = result.getMetaData();
        String columnas = "";
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            columnas = columnas +  rsmd.getColumnName(i).toUpperCase() + ",";
        }
        columnas = columnas.substring(0, columnas.length() -1);        
        String sql1 =  String.format("insert into MASCOTA(" + columnas + ") VALUES ('%s','%s','%s','%s','%s','%s')",nombre,String.valueOf(sexo),
                                                                                            String.valueOf(chip),ciDueño,raza,foto);
        System.out.println(sql1);
        st.execute(sql1);
        st.close();
        conexion.close();
                
        
    }
}
