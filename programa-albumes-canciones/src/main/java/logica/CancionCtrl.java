package logica;

import modelo.Cancion;
import persistencia.CancionDao;

import java.util.ArrayList;

public class CancionCtrl {
    private ArrayList<Cancion> listaCancion;

    public CancionCtrl() {

        cargarCancion();
    }

    public void cargarCancion(){
        CancionDao archivo=new CancionDao();
        listaCancion =archivo.abrirArchivo();
    }

    public void actualizarPersistencia(){
        CancionDao cann=new CancionDao();
        cann.guardarArchivo(listaCancion);
    }

    public boolean agregarCancion(Cancion cancion){
        if (cancion==null)
            return false;

        if (listaCancion ==null)
            listaCancion =new ArrayList<>();

        if (listaCancion.isEmpty())
            cargarCancion();
        else{
            for (int i = 0; i< listaCancion.size(); i++){
                if (cancion.getCalificar() == listaCancion.get(i).getCalificar())
                    return false;
            }
        }
        listaCancion.add(cancion);
        actualizarPersistencia();
        return true;
    }

    public boolean editarProducto(Cancion producto){
        return false;
    }

    public Cancion buscarProducto(int calificar){
        if(listaCancion ==null){
            cargarCancion();
            return null;
        }
        if (listaCancion.isEmpty())
            return null;

        for (int i = 0; i< listaCancion.size(); i++){
            if(calificar== listaCancion.get(i).getCalificar())
                return listaCancion.get(i);
        }
        return null;
    }
}
