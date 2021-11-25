package persistencia;

import modelo.Album;
import modelo.Cancion;

import java.io.*;
import java.util.ArrayList;

public class CancionDao{
        private final String NOMBREAP = "Cancion.p";
        private ArrayList<Cancion> listaCancions;

        public CancionDao() {
            if(abrirArchivo()==null){
                nuevoArchivo();
            }
        }

        private void nuevoArchivo(){
            listaCancions =new ArrayList();
            FileOutputStream fo = null;

            try {
                fo = new FileOutputStream("Cancion.p");
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(listaCancions);
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

    public boolean guardarArchivo (ArrayList<Cancion> lista) {
        FileOutputStream fo = null;
        this.listaCancions= lista;
        try {
            fo = new FileOutputStream("Cancion.p");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(this.listaCancions);
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
        public ArrayList<Cancion> abrirArchivo() {
            FileInputStream fi = null;
            try {
                try {
                    fi = new FileInputStream("Cancion.p");
                    ObjectInputStream oi = new ObjectInputStream(fi);
                    this.listaCancions = (ArrayList<Cancion>)oi.readObject();
                    oi.close();
                    fi.close();
                    return listaCancions;
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