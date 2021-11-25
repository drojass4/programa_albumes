package co.edu.ucentral.ingsf.springprime.bean;

import lombok.Getter;
import lombok.Setter;
import modelo.Album;
import org.springframework.stereotype.Component;
import persistencia.AlbumDao;

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
public class ListaAlbumesBean implements Serializable {
    List<Album> album;
    AlbumDao abrirAlbumes;

    public ListaAlbumesBean(){
        abrirAlbumes = new AlbumDao();
        album = abrirAlbumes.abrirArchivo();
    }

    @PostConstruct
    public void init() throws IOException {
        album = abrirAlbumes.abrirArchivo();

    }
}
