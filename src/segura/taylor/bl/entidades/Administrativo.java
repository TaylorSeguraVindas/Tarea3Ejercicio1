package segura.taylor.bl.entidades;

import segura.taylor.bl.enums.EnumContrato;
import segura.taylor.bl.enums.EnumNombramiento;
import segura.taylor.bl.enums.EnumTipoUsuario;

import java.time.LocalDate;

public class Administrativo extends Usuario{
    //Variables
    private EnumNombramiento tipoNombramiento;
    private double horasAsignadas;

    //Propiedades
    public EnumNombramiento getTipoNombramiento() {
        return tipoNombramiento;
    }
    public void setTipoNombramiento(EnumNombramiento tipoNombramiento) {
        this.tipoNombramiento = tipoNombramiento;
    }

    public double getHorasAsignadas() {
        return horasAsignadas;
    }
    public void setHorasAsignadas(double horasAsignadas) {
        this.horasAsignadas = horasAsignadas;
    }

    //Constructores
    public Administrativo(){
        this.tipoUsuario = EnumTipoUsuario.ADMINISTRATIVO;
    }

    /**
     * Metodo constructor usado para crear una instancia basada en texto
     * @param datos array de String con los datos necesarios para crear la instancia
     */
    public Administrativo(String[] datos) {
        this.tipoUsuario = EnumTipoUsuario.ADMINISTRATIVO;
        this.id = datos[1];
        this.nombre = datos[2];
        this.apellido = datos[3];
        this.tipoNombramiento = EnumNombramiento.valueOf(datos[4]);
        this.horasAsignadas = Double.parseDouble(datos[5]);
    }

    /**
     * Metodo constructor
     * @param id String que define el id
     * @param nombre String que define el nombre
     * @param apellido String que define los apellidos
     * @param tipoNombramiento valor del EnumNombramiento que define el tipo de nombramiento
     * @param horasAsignadas double que define las horas asignadas
     * @see EnumNombramiento
     */
    public Administrativo(String id, String nombre, String apellido, EnumNombramiento tipoNombramiento, double horasAsignadas) {
        super(id, nombre, apellido);
        this.tipoUsuario = EnumTipoUsuario.ADMINISTRATIVO;
        this.tipoNombramiento = tipoNombramiento;
        this.horasAsignadas = horasAsignadas;
    }

    //Metodos
    @Override
    public String toString() {
        return "Administrativo{" +
                super.toString() +
                ", tipoNombramiento=" + tipoNombramiento +
                ", horasAsignadas=" + horasAsignadas +
                '}';
    }

    @Override
    public String toCSV() {
        String datos = this.tipoUsuario + "," +
                this.id + "," +
                this.nombre + "," +
                this.apellido + "," +
                this.tipoNombramiento.toString() + "," +
                this.horasAsignadas;
        return datos;
    }
}
