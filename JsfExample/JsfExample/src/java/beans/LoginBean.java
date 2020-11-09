package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author citlalli
 */
@ManagedBean (name="loginBean")
@RequestScoped
public class LoginBean {
    private String nombre;
    private String contraseña;
    private boolean logeado = false;
    
    public LoginBean() {
    }
    
}
