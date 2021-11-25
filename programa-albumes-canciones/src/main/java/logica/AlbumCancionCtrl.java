package logica;

import modelo.AlbumCancion;
import persistencia.AlbumCancionDao;

import java.util.ArrayList;

public class AlbumCancionCtrl {
    private ArrayList<AlbumCancion> listaAlbumCancion;
    private AlbumCancionDao albumCancionDao;
    private AlbumCancion tienda;

    public AlbumCancionCtrl(){
        cargarTiendas();

    }

    public void cargarTiendas(){
        albumCancionDao =new AlbumCancionDao();
        listaAlbumCancion = albumCancionDao.abrirArchivo();
    }

    public void actualizarPersistencia(){
        albumCancionDao =new AlbumCancionDao();
        albumCancionDao.guardarArchivo(listaAlbumCancion);
    }

    public boolean agregarTienda(AlbumCancion albumCancion){
        if (albumCancion==null)
            return false;

        if (listaAlbumCancion ==null)
            listaAlbumCancion =new ArrayList<AlbumCancion>();

        if (listaAlbumCancion.isEmpty())
            cargarTiendas();
        else{
            for (int i = 0; i< listaAlbumCancion.size(); i++){
                if (albumCancion.getId()== listaAlbumCancion.get(i).getId())
                    return false;
            }
        }
        listaAlbumCancion.add(albumCancion);
        actualizarPersistencia();
        return true;
    }
}

