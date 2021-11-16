package com.example.albumcanciones.archivopersistencia;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Operaciones {

    public boolean guardar(Object dato , String nombrearchivo){
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream(nombrearchivo);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(dato);
            //se cierra archivo
            oo.close();
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fo.close();
            } catch (IOException ex) {

            }
        }
        return false;

    }
}
