package co.edu.ucentral.ingsf.springprime.bean;

import logica.CancionCtrl;
import lombok.Getter;
import lombok.Setter;
import modelo.Cancion;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class UsuarioBean implements Serializable {

}