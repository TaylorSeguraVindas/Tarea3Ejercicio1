package segura.taylor.bl.entidades;

import segura.taylor.bl.enums.EnumContrato;
import segura.taylor.bl.enums.EnumTipoUsuario;

import java.time.LocalDate;

public class Profesor extends Usuario{
    //Variables
    private EnumContrato contrato;
    private LocalDate fechaContratacion;

    //Propiedades
    public EnumContrato getContrato() {
        return contrato;
    }
    public void setContrato(EnumContrato contrato) {
        this.contrato = contrato;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }
    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    //Constructores
    public Profesor(){
        this.tipoUsuario = EnumTipoUsuario.PROFESOR;
    }
    /**
     * Metodo constructor usado para crear una instancia basada en texto
     * @param datos array de String con los datos necesarios para crear la instancia
     */
    public Profesor(String[] datos) {
        this.tipoUsuario = EnumTipoUsuario.PROFESOR;
        this.id = datos[1];
        this.nombre = datos[2];
        this.apellido = datos[3];
        this.contrato = EnumContrato.valueOf(datos[4]);
        this.fechaContratacion = LocalDate.parse(datos[5]);
    }

    /**
     * Metodo constructor
     * @param id String que define el id
     * @param nombre String que define el nombre
     * @param apellido String que define el apellido
     * @param contrato valor de EnumContrato que define el contrato
     * @param fechaContratacion LocalDate que define la fecha de contratacion
     * @see EnumContrato
     */
    public Profesor(String id, String nombre, String apellido, EnumContrato contrato, LocalDate fechaContratacion) {
        super(id, nombre, apellido);
        this.tipoUsuario = EnumTipoUsuario.PROFESOR;
        this.contrato = contrato;
        this.fechaContratacion = fechaContratacion;
    }

    //Metodos
    @Override
    public String toString() {
        return "Profesor{" +
                super.toString() +
                ", contrato=" + contrato +
                ", fechaContratacion=" + fechaContratacion +
                '}';
    }

    @Override
    public String toCSV() {
        String datos = this.tipoUsuario + "," +
                this.id + "," +
                this.nombre + "," +
                this.apellido + "," +
                this.contrato.toString() + "," +
                this.fechaContratacion.toString();
        return datos;
    }
}
