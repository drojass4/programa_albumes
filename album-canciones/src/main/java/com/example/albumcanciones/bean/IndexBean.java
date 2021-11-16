package com.example.albumcanciones.bean;



import com.example.albumcanciones.dto.AlbumesCanciones;
import com.example.albumcanciones.operaciones.OperacionesAlbCan;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
public class IndexBean implements Serializable {
    private String cadena;
    private Integer conteo;
    private Object Vehiculo;
    private Object AlbumesCanciones;


    @PostConstruct
    public void init() {

    }
    public void validar(){
        System.out.println("xxxxx   xxxx");

        if (cadena.isEmpty()){
            conteo = 0;
        }else{
            conteo = cadena.length();
        }

    }
    public String ir(){
        System.out.println("- - - - - - CLICK "+cadena);
        if (cadena.equals("IR"))
            return "principal";
        else
            return "";
    }
    public String guardar(){
        OperacionesAlbCan oper =new OperacionesAlbCan();
        AlbumesCanciones  = new AlbumesCanciones ();
       // oper.crear(cadena.equals("ir"));
        return "";

    }

}
