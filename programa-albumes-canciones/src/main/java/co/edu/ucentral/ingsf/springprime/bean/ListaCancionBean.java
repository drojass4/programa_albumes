package co.edu.ucentral.ingsf.springprime.bean;

import lombok.Getter;
import lombok.Setter;
import modelo.Cancion;
import org.springframework.stereotype.Component;
import persistencia.CancionDao;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class ListaCancionBean implements Serializable {
    List<Cancion> can;
    CancionDao abrirCancion;

    public ListaCancionBean(){
        abrirCancion =new CancionDao();
        can = abrirCancion.abrirArchivo();
    }

    @PostConstruct
    public void init() throws IOException {
        can = abrirCancion.abrirArchivo();

    }

}
