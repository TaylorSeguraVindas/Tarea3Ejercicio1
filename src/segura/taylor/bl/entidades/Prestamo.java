package segura.taylor.bl.entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prestamo {
    //Variables
    private Usuario usuario;
    private ArrayList<Material> items = new ArrayList<>();
    private LocalDate fechaDevolucion;
    private boolean completado;

    //Propiedades
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
    public Prestamo(Usuario usuario, ArrayList<Material> items, LocalDate fechaDevolucion, boolean completado) {
        this.usuario = usuario;
        this.items = items;
        this.fechaDevolucion = fechaDevolucion;
        this.completado = completado;
    }

    //Metodos
    @Override
    public String toString() {
        return "Prestamo{" +
                "usuario=" + usuario +
                ", items=" + items +
                ", fechaDevolucion=" + fechaDevolucion +
                ", completado=" + completado +
                '}';
    }
}
