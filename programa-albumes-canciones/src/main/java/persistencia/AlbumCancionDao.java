package persistencia;

import modelo.AlbumCancion;

import java.io.*;
import java.util.ArrayList;

public class AlbumCancionDao {
    private final String NOMBREAP = "Albumf.p";
    private ArrayList<AlbumCancion> listaAlbums;

    public AlbumCancionDao() {
        if(abrirArchivo()==null){
            nuevoArchivo();
        }
    }

    private void nuevoArchivo(){
        listaAlbums =new ArrayList();
        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream("Albumf.p");
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

    public boolean guardarArchivo(ArrayList<AlbumCancion> listaTiendas) {
        FileOutputStream fo = null;
        this.listaAlbums =listaTiendas;
        try {
            fo = new FileOutputStream("Albumf.p");
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

    public ArrayList<AlbumCancion> abrirArchivo() {
        FileInputStream fi = null;
        try {
            try {
                fi = new FileInputStream("Albumf.p");
                ObjectInputStream oi = new ObjectInputStream(fi);
                this.listaAlbums = (ArrayList<AlbumCancion>)oi.readObject();
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
