package test;

import logica.AlbumCtrl;
import logica.CancionCtrl;
import logica.UsuariosCtrl;
import modelo.Album;
import modelo.Cancion;
import persistencia.CancionDao;
import persistencia.UsuarioDao;
import modelo.Usuario;
import org.junit.jupiter.api.Test;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

class PruebasTest {

    @Test
    void crearUsuario() {
        Usuario user = new Usuario();
        UsuariosCtrl userCtrl = new UsuariosCtrl();
        user.setNombreUsuario("rojas");
        user.setContraseña("asd");
        user.setTipoUsuario(1);
        userCtrl.crearUsuario(user);
    }
    @Test
    void agregarAlbum() {
        AlbumCtrl allll=new AlbumCtrl();
        Album al= new Album();
        ArrayList<Cancion> array = new ArrayList();
        CancionDao cann= new CancionDao();
        al.setId(1);
        al.setNombreArtista("oscar");
        al.setCantidadCanciones("42");
        al.setNombreAlbum("prueba");
        al.setAñoAlbum("1999");
        al.setDuracionAlbum("50");
        array=cann.abrirArchivo();
        al.setCan(array);
        allll.agregarAlbum(al);

    }



    @Test
    void agregarCancion() {
        CancionCtrl cancion=new CancionCtrl();
        Cancion al= new Cancion();
        al.setDuracionCancion("50");
        al.setColaboradores("juan");
        al.setProductor("jose");
        al.setNombreCancion("prueba");
        al.setGeneroAlbum("prueba");
        al.setCalificar(5);
        al.setFavorito("si");
        cancion.agregarCancion(al);


    }


}

