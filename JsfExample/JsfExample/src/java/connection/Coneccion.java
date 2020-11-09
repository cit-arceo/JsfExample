package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author citlalli
 */
public class Coneccion {
    private static Coneccion instancia;
    private Connection conexion;
    
    private String url = "jdbc:postgresql://localhost:5432/personas";
    private String user = "postgres";
    private String password = "tlali150";
    
    private Coneccion(){
        try {
            Class.forName("org.postgresql.Driver");  
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado...");
        } catch (SQLException ex) {
            Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static Coneccion getInstance(){
        if(instancia == null){
            instancia = new Coneccion();
        }
        return instancia;
    }
    
    public boolean actulizar(String sentenciaSql){
        boolean res = false;
        try {
            Statement instancia = conexion.createStatement();
            res = instancia.execute(sentenciaSql);
        } catch (SQLException ex) {
            Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public ResultSet getData(String sentenciaSql){
        ResultSet records = null;
        try {
            Statement instancia = conexion.createStatement();
            records = instancia.executeQuery(sentenciaSql);
        } catch (SQLException ex) {
            Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return records;
    }
}
