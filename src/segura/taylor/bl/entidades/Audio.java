package segura.taylor.bl.entidades;

import java.time.LocalDate;

public class Audio extends Multimedia{
    //Variables
    //Propiedades
    //Constructores
    public Audio(String signatura, LocalDate fechaCompra, boolean restringido, EnumTema tema, EnumFormato formato, double duracion, String idioma) {
        super(signatura, fechaCompra, restringido, tema, formato, duracion, idioma);
    }

    //Metodos
    @Override
    public String toString() {
        return "Audio{}" + super.toString();
    }
}
