package com.example.albumcanciones.operaciones;

import com.example.albumcanciones.archivopersistencia.Operaciones;
import com.example.albumcanciones.dto.AlbumesCanciones ;

import java.util.ArrayList;
import java.util.List;

public class OperacionesVehiculoA implements Operacion<AlbumesCanciones >{

    private final String archivo = "vehiculos.app";
    private List<AlbumesCanciones > albumes;

    public OperacionesVehiculoA() {
        this.albumes = new ArrayList<>();
    }

    // 5 caracteristicas
    //1. Mismo nombre de la clase
    //2. No tiene retorno
    //3. Es un método
    //4. Tiene parametros
    //5. Solamente se instancia 1 vez con new

    @Override
    public boolean crear(AlbumesCanciones  dato) {
        Operaciones oper = new Operaciones();
        this.albumes.add(dato);

        return oper.guardar(this.albumes, this.archivo);

    }

    @Override
    public boolean modificar(AlbumesCanciones  dato) {
        return false;
    }

    @Override
    public boolean borrar(AlbumesCanciones  dato) {
        return false;
    }

    @Override
    public AlbumesCanciones  consulta(String pk) {
        return null;
    }

    @Override
    public List<AlbumesCanciones > consultar() {
        return null;
    }
}
