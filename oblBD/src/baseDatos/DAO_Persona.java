/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author ucu
 */
public class DAO_Persona {
    
    public void agregarPersona(String nombre,String apellido,String cedula, Date fecha,String correo,String telefono, String telefonoSec, 
                                String pais, String calle, String esquina,String departamento, String ciudad,
                                    String numero, String numeroAp, String pin, boolean bis) throws SQLException{
         Connection conexion = Conexion.getInstance().establecerConexion();
         java.sql.Statement st = conexion.createStatement();
        String sql = "SELECT * FROM PERSONA";
        ResultSet result = st.executeQuery(sql);
        ResultSetMetaData rsmd = result.getMetaData();
        String columnas = "";
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            columnas = columnas +  rsmd.getColumnName(i).toUpperCase() + ",";
        }
        columnas = columnas.substring(0, columnas.length() -1);        
        String sql1 =  String.format("insert into PERSONA(" + columnas + ") VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',"
                + "'%s','%s','%s','%s','%s','%s')",nombre,apellido,cedula,fecha,telefono,telefonoSec,pais,calle,esquina,departamento,ciudad,numero,numeroAp,pin,Boolean.toString(bis));
        System.out.println(sql1);
        st.execute(sql1);
        st.close();
        conexion.close();
 
    }
}
