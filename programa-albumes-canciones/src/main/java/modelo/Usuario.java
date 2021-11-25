package modelo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
public class Usuario implements Serializable {
    private String nombreUsuario;
    private String contraseña;
    private int tipoUsuario;


}
