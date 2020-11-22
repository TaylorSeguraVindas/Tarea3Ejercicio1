package segura.taylor.bl.entidades;

import segura.taylor.bl.enums.EnumTipoUsuario;
import segura.taylor.bl.interfaces.SerializableCSV;

public abstract class Usuario implements SerializableCSV {
    //Variables
    protected EnumTipoUsuario tipoUsuario;
    protected String id;
    protected String nombre;
    protected String apellido;

    //Propiedades
    public EnumTipoUsuario getTipoUsuario() { return tipoUsuario; }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //Constructores
    public Usuario() {}
    /**
     * Metodo constructor usado para crear una instancia basada en texto
     * @param datos array de String con los datos necesarios para crear la instancia
     */
    public Usuario(String[] datos){}

    /**
     * Metodo constructor
     * @param id String que define el id
     * @param nombre String que define el nombre
     * @param apellido String que define el apellido
     */
    public Usuario(String id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Metodos
    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", tipo= '" + tipoUsuario + "\'" +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
