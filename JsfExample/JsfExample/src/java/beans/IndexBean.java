package beans;

import dao.DaoPersona;
import models.Personas;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author citlalli
 */
@ManagedBean (name="beanPersona")
@RequestScoped
public class IndexBean {
    private String id;
    private Personas persona;
    private List<Personas> personas;
    private DaoPersona dao;
    
    public IndexBean() {
        persona = new Personas();
        personas = new ArrayList();
        dao = new DaoPersona();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }

    public List<Personas> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Personas> personas) {
        this.personas = personas;
    }

    public DaoPersona getDao() {
        return dao;
    }

    public void setDao(DaoPersona dao) {
        this.dao = dao;
    }
    
    public void saveData(){
        this.dao.insertar(persona);
    }
    
    public void deleteRecord(){
        this.dao.eliminar(id);
    }
    
    public void updateRecord(){
        this.dao.actualizar(persona, id);
    }

    
}
