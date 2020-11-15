package segura.taylor.bl.entidades;

import java.time.LocalDate;

public class Texto extends Material{
    //Variables
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
    private int cantPaginas;
    private String idioma;

    //Propiedades
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }
    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    //Constructores
    public Texto(String signatura, LocalDate fechaCompra, boolean restringido, EnumTema tema, String titulo, String nombreAutor, LocalDate fechaPublicacion, int cantPaginas, String idioma) {
        super(signatura, fechaCompra, restringido, tema);
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
        this.cantPaginas = cantPaginas;
        this.idioma = idioma;
    }

    //Metodos
    @Override
    public String toString() {
        return "Texto{" +
                "titulo='" + titulo + '\'' +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", cantPaginas=" + cantPaginas +
                ", idioma='" + idioma + '\'' +
                '}';
    }
}
