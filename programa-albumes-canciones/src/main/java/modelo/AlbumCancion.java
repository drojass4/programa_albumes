package modelo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class AlbumCancion implements Serializable {
    private  int id;
    private String nombreAlbum;
    private String añoAlbum;
    private String duracionAlbum;
    private String nombreArtista;
    private String cantidadCanciones;
    private String nombreCancion;
    private String productor;
    private String colaboradores;
    private String duracionCancion;
    private boolean favorito;
    private String calificar;
    public String generoAlbum;


}
