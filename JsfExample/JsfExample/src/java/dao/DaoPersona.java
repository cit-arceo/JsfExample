package dao;

import connection.Coneccion;
import idao.Idao;
import models.Personas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author citlalli
 */
public class DaoPersona implements Idao<Personas, String> {
    private String sentencia;
    private Coneccion con = Coneccion.getInstance();
    private Personas persona = new Personas();
    private List<Personas> lista = new ArrayList();
    
    @Override
    public boolean insertar(Personas t) {
        sentencia = "INSERT INTO persona VALUES (" + t.getId() + ",'" + t.getNombre() + "','" + t.getDireccion() + "');";
        return con.actulizar(sentencia);
    }

    @Override
    public boolean eliminar(String v) {
        sentencia = "DELETE FROM persona WHERE (id='" + v + "');";
        return con.actulizar(sentencia);
    }

    @Override
    public List<Personas> mostrarTodo() {
        sentencia = "SELECT * FROM persona;";
        ResultSet data = con.getData(sentencia);
        try {
            while(data.next()){
                lista.add(new Personas(data.getString(1),data.getString(2),data.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public boolean actualizar(Personas t, String v) {
        sentencia = "UPDATE persona SET nombre = '" + t.getNombre() + "',direccion='" + t.getDireccion() + 
                "' WHERE (id ='" + v + "');";
        return con.actulizar(sentencia);
    }

    @Override
    public Personas mostrar(String v) {
        sentencia = "SELECT * FROM persona WHERE (id = '"+ v +"');";
        ResultSet data = con.getData(sentencia);
        try {
            if(data.next()){
            persona.setId(data.getString("id"));
            persona.setNombre(data.getString("nombre"));
            persona.setDireccion(data.getString("direccion"));
        }else{
                System.out.println("No hay registros disponibles...");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persona;
    }
    
}
