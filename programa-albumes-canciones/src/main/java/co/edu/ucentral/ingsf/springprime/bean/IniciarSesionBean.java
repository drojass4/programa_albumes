package co.edu.ucentral.ingsf.springprime.bean;

import logica.UsuariosCtrl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped

public class IniciarSesionBean implements Serializable {
    private String usuario;
    private String contraseña;
    private UsuariosCtrl userCtrl= new UsuariosCtrl();

    public String iniciarSesion(){
        if (usuario!=null && contraseña!=null){
            if (userCtrl.iniciarSesion(usuario,contraseña)==1)
                return "Album";
            if(userCtrl.iniciarSesion(usuario,contraseña)==2)
                return "usuario";
            if (userCtrl.iniciarSesion(usuario,contraseña)==0){
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Usuario incorrecto"));
                return "";
            }
        }
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Datos vacios"));
        return "";
    }


}

