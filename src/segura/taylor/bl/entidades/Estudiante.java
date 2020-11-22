package segura.taylor.bl.entidades;

import segura.taylor.bl.enums.EnumCarrera;
import segura.taylor.bl.enums.EnumContrato;
import segura.taylor.bl.enums.EnumTipoUsuario;

import java.time.LocalDate;

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
    public Estudiante(){
        this.tipoUsuario = EnumTipoUsuario.ESTUDIANTE;
    }
    /**
     * Metodo constructor usado para crear una instancia basada en texto
     * @param datos array de String con los datos necesarios para crear la instancia
     */
    public Estudiante(String[] datos) {
        this.tipoUsuario = EnumTipoUsuario.ESTUDIANTE;
        this.id = datos[1];
        this.nombre = datos[2];
        this.apellido = datos[3];
        this.carrera = EnumCarrera.valueOf(datos[4]);
        this.creditos = Integer.parseInt(datos[5]);
    }

    /**
     * Metodo constructor
     * @param id String que define el id
     * @param nombre String que define el nombre
     * @param apellido String que define el apellido
     * @param carrera valor de EnumCarrera quq define la carrera
     * @param creditos int que define los creditos
     */
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
                ", carrera=" + carrera +
                ", creditos=" + creditos +
                '}';
    }

    @Override
    public String toCSV() {
        String datos = this.tipoUsuario + "," +
                this.id + "," +
                this.nombre + "," +
                this.apellido + "," +
                this.carrera.toString() + "," +
                this.creditos;
        return datos;
    }
}
