package segura.taylor.bl.entidades;

import segura.taylor.bl.enums.EnumTema;
import segura.taylor.bl.enums.EnumTipoMaterial;
import segura.taylor.bl.interfaces.SerializableCSV;

import java.time.LocalDate;

public abstract class Material implements SerializableCSV {
    //Variables
    protected EnumTipoMaterial tipoMaterial;
    protected String signatura;
    protected LocalDate fechaCompra;
    protected boolean restringido;
    protected EnumTema tema;

    //Propiedades
    public EnumTipoMaterial getMaterial() { return tipoMaterial; }
    public String getSignatura() {
        return signatura;
    }
    public void setSignatura(String signatura) {
        this.signatura = signatura;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public boolean isRestringido() {
        return restringido;
    }
    public void setRestringido(boolean restringido) {
        this.restringido = restringido;
    }

    public EnumTema getTema() {
        return tema;
    }
    public void setTema(EnumTema tema) {
        this.tema = tema;
    }

    //Constructores
    public Material(){}
    /**
     * Metodo constructor usado para crear una instancia basada en texto
     * @param datos array de String con los datos necesarios para crear la instancia
     */
    public Material(String[] datos){}

    /**
     * Metodo constructor
     * @param signatura String que define la signatura
     * @param fechaCompra LocalDate que define la fecha de compra
     * @param restringido boolean que define si es restringido o no
     * @param tema valor de EnumTema que define el tema
     * @see EnumTema
     */
    public Material(String signatura, LocalDate fechaCompra, boolean restringido, EnumTema tema) {
        this.signatura = signatura;
        this.fechaCompra = fechaCompra;
        this.restringido = restringido;
        this.tema = tema;
    }

    //Metodos
    @Override
    public String toString() {
        return "tipo= '" + tipoMaterial + "\'" +
                ", signatura='" + signatura + '\'' +
                ", fechaCompra=" + fechaCompra +
                ", restringido=" + restringido +
                ", tema=" + tema +
                '}';
    }
}
