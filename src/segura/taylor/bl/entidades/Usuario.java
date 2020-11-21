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
    public Usuario(String[] datos){}
    public Usuario(String id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Metodos
    @Override
    public String toString() {
        return "Usuario{" +
                "tipo= '" + tipoUsuario + "\'" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
