package ucentral.guardaralbumescanciones.logica;

import java.util.List;

public interface Operacion<T> {
    public boolean crear(T dato);
    public boolean modificar(T dato);
    public boolean borrar(T dato);
    public T consulta(String pk);
    public List<T> consultar();

}
