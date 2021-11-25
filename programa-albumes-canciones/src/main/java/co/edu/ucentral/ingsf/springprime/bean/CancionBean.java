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
public class CancionBean implements Serializable {
    private String nombreCancion;
    private String productor;
    private String colaboradores;
    private String duracionCancion;
    private String favorito;
    private int calificar;
    public String generoAlbum;

    public void agregarCancion(){
        Cancion cann= new Cancion();
        cann.setNombreCancion(nombreCancion);
        cann.setProductor(productor);
        cann.setColaboradores(colaboradores);
        cann.setDuracionCancion(duracionCancion);
        cann.setFavorito(favorito);
        cann.setCalificar(calificar);
        cann.setGeneroAlbum(generoAlbum);

        if (nombreCancion!="" && productor!="" && colaboradores!="" && duracionCancion!="" && favorito !="" && calificar!=0 && generoAlbum!=""){
            CancionCtrl ctrl= new CancionCtrl();
            if (ctrl.agregarCancion(cann)){
                nombreCancion="";
                productor="";
                colaboradores="";
                duracionCancion="";
                favorito="";
                calificar=0;
                generoAlbum="";
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Cancion agregada"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Cancion agregada"));
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Rellene los campos, por favor."));
        }
    }
}