package segura.taylor.bl.entidades;

import segura.taylor.bl.enums.EnumFormato;
import segura.taylor.bl.enums.EnumTema;

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
    public Multimedia(){}

    /**
     * Metodo constructor
     * @param signatura String que define la signatura
     * @param fechaCompra LocalDate que define la fecha de compra
     * @param restringido boolean que define si es restringido o no
     * @param tema valor de EnumTema que define el tema
     * @param formato valor de EnumFormato que define el formato
     * @param duracion double que define la duracion
     * @param idioma String que define el idioma
     * @see EnumTema
     * @see EnumFormato
     */
    public Multimedia(String signatura, LocalDate fechaCompra, boolean restringido, EnumTema tema, EnumFormato formato, double duracion, String idioma) {
        super(signatura, fechaCompra, restringido, tema);
        this.formato = formato;
        this.duracion = duracion;
        this.idioma = idioma;
    }

    //Metodos
    @Override
    public String toString() {
        return super.toString() +
                ", formato=" + formato +
                ", duracion=" + duracion +
                ", idioma='" + idioma + '\'' +
                '}';
    }
}
