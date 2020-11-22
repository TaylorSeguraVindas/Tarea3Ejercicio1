package segura.taylor.bl.entidades;

import segura.taylor.bl.enums.EnumFormato;
import segura.taylor.bl.enums.EnumTema;
import segura.taylor.bl.enums.EnumTipoMaterial;

import java.time.LocalDate;

public class Video extends Multimedia{
    //Variables
    private String director;

    //Propiedades
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    //Constructores
    public Video() {
        this.tipoMaterial = EnumTipoMaterial.VIDEO;
    }
    /**
     * Metodo constructor usado para crear una instancia basada en texto
     * @param datos array de String con los datos necesarios para crear la instancia
     */
    public Video(String[] datos){
        this.tipoMaterial = EnumTipoMaterial.VIDEO;

        this.signatura = datos[1];
        this.fechaCompra = LocalDate.parse(datos[2]);
        this.restringido = Boolean.parseBoolean(datos[3]);
        this.tema = EnumTema.valueOf(datos[4]);
        this.formato = EnumFormato.valueOf(datos[5]);
        this.duracion = Double.parseDouble(datos[6]);
        this.idioma = datos[7];
        this.director = datos[8];
    }

    /**
     * Metodo constructor
     * @param signatura String que define la signatura
     * @param fechaCompra LocalDate que define la fecha de compra
     * @param restringido boolean que define si es restringido o no
     * @param tema valor de EnumTema que define el tema
     * @param formato valor de EnumFormato que define el formato
     * @param duracion double que define la duracion
     * @param idioma String que define el idioma
     * @param director String que define el director
     */
    public Video(String signatura, LocalDate fechaCompra, boolean restringido, EnumTema tema, EnumFormato formato, double duracion, String idioma, String director) {
        super(signatura, fechaCompra, restringido, tema, formato, duracion, idioma);
        this.director = director;
        this.tipoMaterial = EnumTipoMaterial.VIDEO;
    }

    //Metodos
    @Override
    public String toString() {
        return "Video{" +
                "signatura='" + signatura + '\'' +
                ", tipoMaterial=" + tipoMaterial +
                ", director='" + director + '\'' +
                ", formato=" + formato +
                ", duracion=" + duracion +
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
                this.formato.toString() + "," +
                this.duracion + "," +
                this.idioma + "," +
                this.director;
        return datos;
    }
}
