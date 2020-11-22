package segura.taylor.bl.entidades;

import segura.taylor.bl.interfaces.SerializableCSV;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prestamo implements SerializableCSV {
    //Variables
    private String id;
    private Usuario usuario;
    private ArrayList<Material> items = new ArrayList<>();
    private LocalDate fechaCreacion;
    private LocalDate fechaDevolucion;
    private boolean completado;

    //Propiedades
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Material> getItems() {
        return items;
    }
    public void setItems(ArrayList<Material> items) {
        this.items = items;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean isCompletado() {
        return completado;
    }
    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    //Constructores
    public Prestamo(){}
    public Prestamo(String[] datos) {
        this.id = datos[0];
        this.fechaCreacion = LocalDate.parse(datos[2]);
        this.fechaDevolucion = LocalDate.parse(datos[3]);
        this.completado = Boolean.parseBoolean(datos[4]);
        //Usuario y items se asignan desde el FAO.
        this.items = new ArrayList<>();
    }
    public Prestamo(String id, Usuario usuario, ArrayList<Material> items, LocalDate fechaCreacion, LocalDate fechaDevolucion, boolean completado) {
        this.id = id;
        this.usuario = usuario;
        this.items = items;
        this.fechaCreacion = fechaCreacion;
        this.fechaDevolucion = fechaDevolucion;
        this.completado = completado;
    }

    //Metodos
    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaDevolucion=" + fechaDevolucion +
                ", completado=" + completado +
                ", usuario=" + usuario +
                ", items=" + items +
                '}';
    }

    @Override
    public String toCSV() {
        String datos = this.id + "," +
                this.usuario.getId() + "," +
                this.fechaCreacion.toString() + "," +
                this.fechaDevolucion.toString() + "," +
                this.completado;

        //Todos los materiales se guardan al final
        for (Material material : items) {
            datos += "," + material.getSignatura();
        }

        return datos;
    }
}
