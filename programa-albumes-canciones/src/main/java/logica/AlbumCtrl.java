package logica;

import modelo.Album;
import modelo.AlbumCancion;
import persistencia.AlbumDao;

import java.util.ArrayList;

public class AlbumCtrl {
        private ArrayList<Album> listaAlbumCancion;
        private AlbumDao albumCancionDao;
        private AlbumCancion tienda;

        public AlbumCtrl(){
            cargaralbum();

        }

        public void cargaralbum(){
            albumCancionDao =new AlbumDao();
            listaAlbumCancion = albumCancionDao.abrirArchivo();
        }

        public void actualizarPersistencia(){
            albumCancionDao =new AlbumDao();
            albumCancionDao.guardarArchivo(listaAlbumCancion);
        }

        public boolean agregarAlbum(Album album){
            if (album==null)
                return false;

            if (listaAlbumCancion ==null)
                listaAlbumCancion =new ArrayList<Album>();

            if (listaAlbumCancion.isEmpty())
                cargaralbum();
            else{
                for (int i = 0; i< listaAlbumCancion.size(); i++){
                    if (album.getId()== listaAlbumCancion.get(i).getId())
                        return false;
                }
            }
            listaAlbumCancion.add(album);
            actualizarPersistencia();
            return true;
        }
}