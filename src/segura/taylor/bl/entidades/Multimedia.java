package segura.taylor.bl.entidades;

import java.time.LocalDate;

public abstract class Multimedia extends Material{
    //Variables
    protected EnumFormato formato;
    protected double duracion;
    protected String idioma;

    //Propiedades
    public EnumFormato getFormato() {
        return formato;
    }
    public void setFormato(EnumFormato formato) {
        this.formato = formato;
    }

    public double getDuracion() {
        return duracion;
    }
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    //Constructores
    public Multimedia(String signatura, LocalDate fechaCompra, boolean restringido, EnumTema tema, EnumFormato formato, double duracion, String idioma) {
        super(signatura, fechaCompra, restringido, tema);
        this.formato = formato;
        this.duracion = duracion;
        this.idioma = idioma;
    }

    //Metodos
    @Override
    public String toString() {
        return "Multimedia{" +
                super.toString() +
                "formato=" + formato +
                ", duracion=" + duracion +
                ", idioma='" + idioma + '\'' +
                '}';
    }
}
