package segura.taylor.bl.entidades;

import java.time.LocalDate;

public abstract class Material {
    //Variables
    protected String signatura;
    protected LocalDate fechaCompra;
    protected boolean restringido;
    protected EnumTema tema;

    //Propiedades
    public String getSignatura() {
        return signatura;
    }
    public void setSignatura(String signatura) {
        this.signatura = signatura;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public boolean isRestringido() {
        return restringido;
    }
    public void setRestringido(boolean restringido) {
        this.restringido = restringido;
    }

    public EnumTema getTema() {
        return tema;
    }
    public void setTema(EnumTema tema) {
        this.tema = tema;
    }

    //Constructores
    public Material(String signatura, LocalDate fechaCompra, boolean restringido, EnumTema tema) {
        this.signatura = signatura;
        this.fechaCompra = fechaCompra;
        this.restringido = restringido;
        this.tema = tema;
    }

    //Metodos
    @Override
    public String toString() {
        return "Material{" +
                "signatura='" + signatura + '\'' +
                ", fechaCompra=" + fechaCompra +
                ", restringido=" + restringido +
                ", tema=" + tema +
                '}';
    }
}
