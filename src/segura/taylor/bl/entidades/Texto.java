package segura.taylor.bl.entidades;

import segura.taylor.bl.enums.EnumTema;
import segura.taylor.bl.enums.EnumTipoMaterial;

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
    public Texto() {
        this.tipoMaterial = EnumTipoMaterial.TEXTO;
    }

    /**
     * Metodo constructor usado para crear una instancia basada en texto
     * @param datos array de String con los datos necesarios para crear la instancia
     */
    public Texto(String[] datos){
        this.tipoMaterial = EnumTipoMaterial.OTRO;

        this.signatura = datos[1];
        this.fechaCompra = LocalDate.parse(datos[2]);
        this.restringido = Boolean.parseBoolean(datos[3]);
        this.tema = EnumTema.valueOf(datos[4]);
        this.titulo = datos[5];
        this.nombreAutor = datos[6];
        this.fechaPublicacion = LocalDate.parse(datos[7]);
        this.cantPaginas = Integer.parseInt(datos[8]);
        this.idioma = datos[9];
    }

    /**
     * Metodo constructor
     * @param signatura String que define la signatura
     * @param fechaCompra LocalDate que define la fecha de compra
     * @param restringido boolean que define si es restringido o no
     * @param tema valor de EnumTema que define el tema
     * @param titulo String que define el titulo
     * @param nombreAutor String que define el nombre del autor
     * @param fechaPublicacion LocalDate que define la fecha de publicacion
     * @param cantPaginas int que define la cantidad de paginas
     * @param idioma String que define el idioma
     */
    public Texto(String signatura, LocalDate fechaCompra, boolean restringido, EnumTema tema, String titulo, String nombreAutor, LocalDate fechaPublicacion, int cantPaginas, String idioma) {
        super(signatura, fechaCompra, restringido, tema);
        this.tipoMaterial = EnumTipoMaterial.TEXTO;
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
                "signatura='" + signatura + '\'' +
                ", tipoMaterial=" + tipoMaterial +
                ", titulo='" + titulo + '\'' +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", cantPaginas=" + cantPaginas +
                ", idioma='" + idioma + '\'' +
                ", fechaCompra=" + fechaCompra +
                ", restringido=" + restringido +
                ", tema=" + tema +
                '}';
    }

    @Override
    public String toCSV() {
        String datos = this.tipoMaterial + "," +
                this.signatura + "," +
                this.fechaCompra.toString() + "," +
                this.restringido + "," +
                this.tema.toString() + "," +
                this.titulo + "," +
                this.nombreAutor + "," +
                this.fechaPublicacion.toString() + "," +
                this.cantPaginas + "," +
                this.idioma;
        return datos;
    }
}
