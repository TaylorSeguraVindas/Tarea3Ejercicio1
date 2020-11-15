package segura.taylor.bl.entidades;

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
    public Video(String signatura, LocalDate fechaCompra, boolean restringido, EnumTema tema, EnumFormato formato, double duracion, String idioma, String director) {
        super(signatura, fechaCompra, restringido, tema, formato, duracion, idioma);
        this.director = director;
    }

    //Metodos
    @Override
    public String toString() {
        return "Video{" +
                super.toString() +
                "director='" + director + '\'' +
                '}';
    }
}
