
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

public class DAO_Denuncia_Rescate {
     public void agregarDenuncia(Date fecha, String descripcion,boolean pendiente, int chip,String idRescatista) throws SQLException{
            //Calendar.getInstance().getTime() para afuera
            
            java.sql.Date date = new java.sql.Date(fecha.getTime());
            Connection conexion = Conexion.getInstance().establecerConexion();
            java.sql.Statement st = conexion.createStatement();
            String sql = "SELECT * FROM DENUNCIA_RESCATE";
            ResultSet result = st.executeQuery(sql);
            ResultSetMetaData rsmd = result.getMetaData();
            String columnas = "";
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                columnas = columnas +  rsmd.getColumnName(i).toUpperCase() + ",";
            }
            columnas = columnas.substring(0, columnas.length() -1);        
            String sql1 =  String.format("insert into DENUNCIA_RESCATE(" + columnas + ") VALUES (?,'%s','%s','%s','%s')",descripcion,String.valueOf(pendiente),
                                                                             String.valueOf(chip), idRescatista);
            PreparedStatement prep = conexion.prepareStatement(sql1);
            prep.setDate(1, (java.sql.Date) date);
            
            System.out.println(prep.toString());
            prep.executeQuery();
            st.close();
            conexion.close();
    }
    public static void main(String[] args) throws SQLException{
        DAO_Denuncia_Rescate dao = new DAO_Denuncia_Rescate();
        
        Date fecha =  Calendar.getInstance().getTime();
        Date date = new Date(fecha.getTime());
        dao.agregarDenuncia(date, "jajaj", true, 00, "00");
    }
}
