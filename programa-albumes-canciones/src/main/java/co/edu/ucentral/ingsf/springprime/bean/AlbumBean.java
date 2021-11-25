package co.edu.ucentral.ingsf.springprime.bean;

import logica.AlbumCtrl;
import lombok.Getter;
import lombok.Setter;
import modelo.Album;
import modelo.Cancion;
import org.springframework.stereotype.Component;
import persistencia.CancionDao;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class AlbumBean implements Serializable {

    private  int id;
    private String nombreAlbum;
    private String añoAlbum;
    private String duracionAlbum;
    private String nombreArtista;
    private String cantidadCanciones;


public void guardarAlbumCancion(){
    Album al = new Album();
    ArrayList<Cancion> array;
    CancionDao canDao = new CancionDao();
    al.setId(id);
    al.setNombreAlbum(nombreAlbum);
    al.setDuracionAlbum(duracionAlbum);
    al.setAñoAlbum(añoAlbum);
    al.setCantidadCanciones(cantidadCanciones);
    al.setNombreArtista(nombreArtista);
    array=canDao.abrirArchivo();
    al.setCan(array);

    if (id!=0 && nombreAlbum!="" && duracionAlbum!="" && añoAlbum!="" && cantidadCanciones!="" && nombreArtista!=""){
        AlbumCtrl ctrl = new AlbumCtrl();
        if(ctrl.agregarAlbum(al)){
            id=0;
            nombreAlbum="";
            duracionAlbum="";
            añoAlbum="";
            cantidadCanciones="";
            nombreArtista="";

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Album creado"));
        }else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Compruebe la información suministrada"));
        }
    }else {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Rellene los campos, por favor."));
    }

}


}
