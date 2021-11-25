package modelo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
public class Album implements Serializable {
    private  int id;
    private String nombreAlbum;
    private String añoAlbum;
    private String duracionAlbum;
    private String nombreArtista;
    private String cantidadCanciones;
    private ArrayList<Cancion> can;
}
