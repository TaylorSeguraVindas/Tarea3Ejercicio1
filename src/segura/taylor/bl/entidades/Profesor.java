package segura.taylor.bl.entidades;

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
    public Profesor(String id, String nombre, String apellido, EnumContrato contrato, LocalDate fechaContratacion) {
        super(id, nombre, apellido);
        this.contrato = contrato;
        this.fechaContratacion = fechaContratacion;
    }

    //Metodos

    @Override
    public String toString() {
        return "Profesor{" +
                super.toString() +
                "contrato=" + contrato +
                ", fechaContratacion=" + fechaContratacion +
                '}';
    }
}
