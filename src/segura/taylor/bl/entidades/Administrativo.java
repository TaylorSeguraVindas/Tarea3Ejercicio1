package segura.taylor.bl.entidades;

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
    public Administrativo(String id, String nombre, String apellido, EnumNombramiento tipoNombramiento, double horasAsignadas) {
        super(id, nombre, apellido);
        this.tipoNombramiento = tipoNombramiento;
        this.horasAsignadas = horasAsignadas;
    }

    //Metodos

    @Override
    public String toString() {
        return "Administrativo{" +
                super.toString() +
                "tipoNombramiento=" + tipoNombramiento +
                ", horasAsignadas=" + horasAsignadas +
                '}';
    }
}
