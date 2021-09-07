/*
 * Clase donde se define todo lo relacionado a conexiones
 */
package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


public class Conex {
    
    //CONEXIONES LOCALES
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/userregister?useSSL=false&useTimeZone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "sirpla";
    private static final String JDBC_PASSWORD = "Sirpla%7012";
    
    //CONEXION PARA DEPLOY - REEMPLAZAR LOS VALORES NECESARIOS
        //private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sirplacrt?useSSL=false&useTimeZone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        //private static final String JDBC_USER = "sirplactr";
        //private static final String JDBC_PASSWORD = "Sirpla%7012";
    
    
    //DEFINO EL POOL DE CONEXIONES DEL MYSQL
    public static DataSource getDataSource(){
        BasicDataSource ds=new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        ds.setInitialSize(50);
        
        return ds;
               
    }
    
    //OBTENGO LA CONEXION
    public static Connection getConnection(Boolean esTransaccion) throws SQLException {
        Connection c = null;
        c = getDataSource().getConnection();
        if (esTransaccion) {
            if (c.getAutoCommit() == true) {
                c.setAutoCommit(false);

            }
        }
        return c;
    }
    
    //Cierro el resultset
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }
    
    //Cierro el statement
    public static void close(PreparedStatement ps){
        try {
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    //Cierro la conexion
    public static void close(Connection cnn){
        try {
            cnn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
