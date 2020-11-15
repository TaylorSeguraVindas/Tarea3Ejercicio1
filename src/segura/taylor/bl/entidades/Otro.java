package segura.taylor.bl.entidades;

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
    public Otro(String signatura, LocalDate fechaCompra, boolean restringido, EnumTema tema, String descripcion) {
        super(signatura, fechaCompra, restringido, tema);
        this.descripcion = descripcion;
    }

    //Metodos

    @Override
    public String toString() {
        return "Otro{" +
                super.toString() +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}
