package segura.taylor.bl.entidades;

import segura.taylor.bl.enums.EnumCarrera;
import segura.taylor.bl.enums.EnumTipoUsuario;

public class Estudiante extends Usuario {
    //Variables
    private EnumCarrera carrera;
    private int creditos;

    //Propiedades
    public EnumCarrera getCarrera() {
        return carrera;
    }
    public void setCarrera(EnumCarrera carrera) {
        this.carrera = carrera;
    }

    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    //Constructores
    public Estudiante(String id, String nombre, String apellido, EnumCarrera carrera, int creditos) {
        super(id, nombre, apellido);
        this.tipoUsuario = EnumTipoUsuario.ESTUDIANTE;
        this.carrera = carrera;
        this.creditos = creditos;
    }

    //Metodos
    @Override
    public String toString() {
        return "Estudiante{" +
                super.toString() +
                "carrera=" + carrera +
                ", creditos=" + creditos +
                '}';
    }
}
