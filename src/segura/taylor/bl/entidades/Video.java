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
    public Video(String signatura, LocalDate fechaCompra, boolean restringido, EnumTema tema, EnumFormato formato, double duracion, String idioma, String director) {
        super(signatura, fechaCompra, restringido, tema, formato, duracion, idioma);
        this.director = director;
        this.tipoMaterial = EnumTipoMaterial.VIDEO;
    }

    //Metodos
    @Override
    public String toString() {
        return "Video{" +
                super.toString() +
                "director='" + director + '\'' +
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
