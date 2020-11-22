package segura.taylor.bl.entidades;

import segura.taylor.bl.enums.EnumFormato;
import segura.taylor.bl.enums.EnumTema;
import segura.taylor.bl.enums.EnumTipoMaterial;

import java.time.LocalDate;

public class Otro extends Material{
    //Variables
    private String descripcion;

    //Propiedades
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Constructores
    public Otro() {
        this.tipoMaterial = EnumTipoMaterial.OTRO;
    }
    /**
     * Metodo constructor usado para crear una instancia basada en texto
     * @param datos array de String con los datos necesarios para crear la instancia
     */
    public Otro(String[] datos){
        this.tipoMaterial = EnumTipoMaterial.OTRO;

        this.signatura = datos[1];
        this.fechaCompra = LocalDate.parse(datos[2]);
        this.restringido = Boolean.parseBoolean(datos[3]);
        this.tema = EnumTema.valueOf(datos[4]);
        this.descripcion = datos[5];
    }

    /**
     * Metodo constructor
     * @param signatura String que define la signatura
     * @param fechaCompra LocalDate que define la fecha de compra
     * @param restringido boolean que define si es restringido o no
     * @param tema valor de EnumTema que define el tema
     * @param descripcion String que define la descripcion
     * @see EnumTema
     */
    public Otro(String signatura, LocalDate fechaCompra, boolean restringido, EnumTema tema, String descripcion) {
        super(signatura, fechaCompra, restringido, tema);
        this.tipoMaterial = EnumTipoMaterial.OTRO;
        this.descripcion = descripcion;
    }

    //Metodos
    @Override
    public String toString() {
        return "Otro{" +
                "signatura='" + signatura + '\'' +
                ", tipoMaterial=" + tipoMaterial +
                ", descripcion='" + descripcion + '\'' +
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
                this.descripcion;
        return datos;
    }
}
