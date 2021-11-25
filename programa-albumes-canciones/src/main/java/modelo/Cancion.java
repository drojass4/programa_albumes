package modelo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Cancion implements Serializable {
    private String nombreCancion;
    private String productor;
    private String colaboradores;
    private String duracionCancion;
    private String favorito;
    private int calificar;
    public String generoAlbum;
}
