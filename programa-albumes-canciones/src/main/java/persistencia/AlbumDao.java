package persistencia;

import modelo.Album;
import modelo.AlbumCancion;

import java.io.*;
import java.util.ArrayList;

public class AlbumDao {
    private final String NOMBREAP = "Album.p";
    private ArrayList<Album> listaAlbums;

    public AlbumDao() {
        if(abrirArchivo()==null){
            nuevoArchivo();
        }
    }

    private void nuevoArchivo(){
        listaAlbums =new ArrayList();
        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream("Album.p");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(listaAlbums);
            oo.close();
        } catch (FileNotFoundException var16) {
            var16.printStackTrace();
        } catch (IOException var17) {
            var17.printStackTrace();
        } finally {
            try {
                fo.close();
            } catch (IOException var15) {
            }
        }
    }

    public boolean guardarArchivo(ArrayList<Album> lista) {
        FileOutputStream fo = null;
        this.listaAlbums =lista;
        try {
            fo = new FileOutputStream("Album.p");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(this.listaAlbums);
            oo.close();
            return true;
        } catch (FileNotFoundException var16) {
            var16.printStackTrace();
        } catch (IOException var17) {
            var17.printStackTrace();
        } finally {
            try {
                fo.close();
            } catch (IOException var15) {
            }
        }
        return false;
    }

    public ArrayList<Album> abrirArchivo() {
        FileInputStream fi = null;
        try {
            try {
                fi = new FileInputStream("Album.p");
                ObjectInputStream oi = new ObjectInputStream(fi);
                this.listaAlbums = (ArrayList<Album>)oi.readObject();
                oi.close();
                fi.close();
                return listaAlbums;
            } catch (FileNotFoundException var10) {
                nuevoArchivo();
            } catch (IOException var11) {
                var11.printStackTrace();
            } catch (ClassNotFoundException var12) {
                var12.printStackTrace();
            }
            return null;
        } finally {

        }
    }
}