package segura.taylor.bl.entidades;

import segura.taylor.bl.enums.EnumFormato;
import segura.taylor.bl.enums.EnumTema;
import segura.taylor.bl.enums.EnumTipoMaterial;

import java.time.LocalDate;

public class Audio extends Multimedia{
    //Variables
    //Propiedades
    //Constructores
    public Audio(){
        this.tipoMaterial = EnumTipoMaterial.AUDIO;
    }
    public Audio(String[] datos){
        this.tipoMaterial = EnumTipoMaterial.AUDIO;

        this.signatura = datos[1];
        this.fechaCompra = LocalDate.parse(datos[2]);
        this.restringido = Boolean.parseBoolean(datos[3]);
        this.tema = EnumTema.valueOf(datos[4]);
        this.formato = EnumFormato.valueOf(datos[5]);
        this.duracion = Double.parseDouble(datos[6]);
        this.idioma = datos[7];
    }
    public Audio(String signatura, LocalDate fechaCompra, boolean restringido, EnumTema tema, EnumFormato formato, double duracion, String idioma) {
        super(signatura, fechaCompra, restringido, tema, formato, duracion, idioma);
        this.tipoMaterial = EnumTipoMaterial.AUDIO;
    }

    //Metodos
    @Override
    public String toString() {
        return "Audio{" +
                "signatura='" + signatura + '\'' +
                ", tipoMaterial=" + tipoMaterial +
                ", formato=" + formato +
                ", duracion=" + duracion +
                ", idioma='" + idioma + '\'' +
                ", fechaCompra=" + fechaCompra +
                ", restringido=" + restringido +
                ", tema=" + tema +
                '}';
    }

    @Override
    public String toCSV() {
        String datos = this.tipoMaterial + "," +
                this.signatura + "," +
                this.fechaCompra.toString() + "," +
                this.restringido + "," +
                this.tema.toString() + "," +
                this.formato.toString() + "," +
                this.duracion + "," +
                this.idioma;
        return datos;
    }
}
