/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.beans;

import com.sutechbian.facturacion.Usuario;
import com.sutechbian.facturacion.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dell_
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    private String name;
    private String password;
    
    @EJB
    private UsuarioFacade userFacade;
    
    private Usuario user;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

      
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
 
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    public String authenticate(){
         if(userFacade.findUserToLogin(this.getName(), this.getPassword()) != null){
            return "start";  
        } 
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Contraseña o Usuario equivocado", "Contraseña o Usuario equivocado"));
        return null;  
    }
}
