package ucentral.guardaralbumescanciones.logica;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ucentral.guardaralbumescanciones.util.Coneccion;
import ucentral.guardaralbumescanciones.datos.AlbumesCanciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Repertorio implements Operacion<AlbumesCanciones>{
    private static Logger log = LogManager.getLogger(Repertorio.class.getName());

    private final String sqlCrear= "INSERT INTO AlbumesCanciones() VALUES (?, ?, ?)";
    private final String sqlModificar= "UPDATE AlbumesCanciones SET ";
    private final String sqlConsultaPK= "select * from AlbumesCanciones  WHERE id = ?";
    private final String sqlConsultaALL= "select * from AlbumesCanciones  ";
    private final String sqlBorrar= "delete from AlbumesCanciones  WHERE id = ?";



    @Override
    public boolean crear(AlbumesCanciones  dato) {
        if (dato == null){
            return false;
        }else if (dato.getId() == null){
            return false;

        }
        Coneccion mc = new Coneccion();
        Connection conexActiva = mc.conectarseSQL();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlCrear);

                ps.setString(1, dato.getAñoAlbum());
                ps.setInt(2, dato.getCalificar());
                ps.setString(3, dato.getColaboradores());
                ps.setString(4, dato.getNombreAlbum());
                ps.setString(5, dato.getNombreArtista());
                ps.setString(6, dato.getProductor());
                ps.setInt(7, dato.getCantidadCanciones());
                ps.setInt(8, dato.getDuracionAlbum());
                ps.setInt(9, dato.getDuracionCancion());
                ps.setInt(10, dato.getId());
                ps.setBoolean(11, dato.isFavorito());
                ps.setString(12, dato.getNombreCancion());



                int modificados = ps.executeUpdate();
                if (modificados >0 ){
                    return true;
                }

            } catch (SQLException throwables) {
                log.error("Mensaje ", throwables);
            } finally {
                mc.desconexion(conexActiva);

            }
        }

        return false;
    }

    @Override
    public boolean modificar(AlbumesCanciones  dato) {
        if (dato == null){
            return false;
        }else if (dato.getId() == null){
            return false;

        }
        Coneccion mc = new Coneccion();
        Connection conexActiva = mc.conectarseSQL();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlModificar);

                ps.setString(1, dato.getAñoAlbum());
                ps.setInt(2, dato.getCalificar());
                ps.setString(3, dato.getColaboradores());
                ps.setString(4, dato.getNombreAlbum());
                ps.setString(5, dato.getNombreArtista());
                ps.setString(6, dato.getProductor());
                ps.setInt(7, dato.getCantidadCanciones());
                ps.setInt(8, dato.getDuracionAlbum());
                ps.setInt(9, dato.getDuracionCancion());
                ps.setInt(10, dato.getId());
                ps.setBoolean(11, dato.isFavorito());
                ps.setString(12, dato.getNombreCancion());

                int modificados = ps.executeUpdate();
                if (modificados >0 ){
                    return true;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                mc.desconexion(conexActiva);

            }
        }
        return false;
    }

    @Override
    public boolean borrar(AlbumesCanciones  dato) {
        if (dato == null){
            return false;
        }else if (dato.getId() == null){
            return false;

        }
        Coneccion mc = new Coneccion();
        Connection conexActiva = mc.conectarseSQL();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlBorrar);

                ps.setInt(1, dato.getId());

                int modificados = ps.executeUpdate();
                if (modificados >0 ){
                    return true;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                mc.desconexion(conexActiva);

            }
        }
        return false;
    }

    @Override
    public AlbumesCanciones  consulta(String pk) {
        if (pk == null){
            return null;
        }
        Coneccion mc = new Coneccion();
        Connection conexActiva = mc.conectarseSQL();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlConsultaPK);

                ps.setString(1, pk);

                ResultSet resultado = ps.executeQuery();
                if (resultado.next()){
                    AlbumesCanciones  elalbum = new AlbumesCanciones ();
                    elalbum.setAñoAlbum(resultado.getString("año del album "));
                    elalbum.setCalificar(resultado.getInt("calificar cancion "));
                    elalbum.setColaboradores(resultado.getString("Colaboradores"));
                    elalbum.setNombreAlbum(resultado.getString("nombre del album "));
                    elalbum.setNombreArtista(resultado.getString("nombre del artista"));
                    elalbum.setProductor(resultado.getString("Productor"));
                    elalbum.setCantidadCanciones(resultado.getInt("Cantidad de canciones"));
                    elalbum.setDuracionAlbum(resultado.getInt("duracion de album"));
                    elalbum.setDuracionCancion(resultado.getInt("duracion de la cancion"));
                    elalbum.setId(resultado.getInt("ID"));
                    elalbum.setFavorito(resultado.getBoolean("Favorito"));
                    elalbum.setNombreCancion(resultado.getString("nombre de cancion "));
                    return elalbum;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                mc.desconexion(conexActiva);

            }
        }
        return null;
    }

    @Override
    public List<AlbumesCanciones > consultar() {
        Coneccion mc = new Coneccion();
        Connection conexActiva = mc.conectarseSQL();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlConsultaALL);

                ResultSet resultado = ps.executeQuery();
                List<AlbumesCanciones > datos = new ArrayList<>();
                while (resultado.next()){
                    AlbumesCanciones  elalbum = new AlbumesCanciones ();
                    elalbum.setAñoAlbum(resultado.getString("año del album "));
                    elalbum.setCalificar(resultado.getInt("calificar cancion "));
                    elalbum.setColaboradores(resultado.getString("Colaboradores"));
                    elalbum.setNombreAlbum(resultado.getString("nombre del album "));
                    elalbum.setNombreArtista(resultado.getString("nombre del artista"));
                    elalbum.setProductor(resultado.getString("Productor"));
                    elalbum.setCantidadCanciones(resultado.getInt("Cantidad de canciones"));
                    elalbum.setDuracionAlbum(resultado.getInt("duracion de album"));
                    elalbum.setDuracionCancion(resultado.getInt("duracion de la cancion"));
                    elalbum.setId(resultado.getInt("ID"));
                    elalbum.setFavorito(resultado.getBoolean("Favorito"));
                    elalbum.setNombreCancion(resultado.getString("nombre de cancion "));
                    datos.add(elalbum);
                }
                return datos;

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                mc.desconexion(conexActiva);

            }
        }
        return new ArrayList<>();
    }
}
