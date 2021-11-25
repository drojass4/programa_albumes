package ucentral.guardaralbumescanciones.datos;

public class AlbumesCanciones {
    private Integer id;
    private String nombreAlbum;
    private  String añoAlbum;
    private int cantidadCanciones;
    private int duracionAlbum;
    private String nombreArtista;
    private String nombreCancion;
    private String productor;
    private String colaboradores;
    private int duracionCancion;
    private boolean favorito;
    private int calificar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getAñoAlbum() {
        return añoAlbum;
    }

    public void setAñoAlbum(String añoAlbum) {
        this.añoAlbum = añoAlbum;
    }

    public int getCantidadCanciones() {
        return cantidadCanciones;
    }

    public void setCantidadCanciones(int cantidadCanciones) {
        this.cantidadCanciones = cantidadCanciones;
    }

    public int getDuracionAlbum() {
        return duracionAlbum;
    }

    public void setDuracionAlbum(int duracionAlbum) {
        this.duracionAlbum = duracionAlbum;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(String colaboradores) {
        this.colaboradores = colaboradores;
    }

    public int getDuracionCancion() {
        return duracionCancion;
    }

    public void setDuracionCancion(int duracionCancion) {
        this.duracionCancion = duracionCancion;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public int getCalificar() {
        return calificar;
    }

    public void setCalificar(int calificar) {
        this.calificar = calificar;
    }


    @Override
    public String toString() {
        return "AlbumesCanciones{" +
                "id=" + id +
                ", nombreAlbum='" + nombreAlbum + '\'' +
                ", añoAlbum='" + añoAlbum + '\'' +
                ", cantidadCanciones=" + cantidadCanciones +
                ", duracionAlbum=" + duracionAlbum +
                ", nombreArtista='" + nombreArtista + '\'' +
                ", nombreCancion='" + nombreCancion + '\'' +
                ", productor='" + productor + '\'' +
                ", colaboradores='" + colaboradores + '\'' +
                ", duracionCancion=" + duracionCancion +
                ", favorito=" + favorito +
                ", calificar=" + calificar +
                '}';
    }


}
