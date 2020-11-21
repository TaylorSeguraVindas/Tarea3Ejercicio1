package segura.taylor.controlador;

import segura.taylor.bl.entidades.*;
import segura.taylor.bl.enums.*;
import segura.taylor.bl.gestor.GestorMateriales;
import segura.taylor.bl.gestor.GestorUsuarios;

import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

public class Controlador {
    GestorMateriales gestorMateriales = new GestorMateriales();
    GestorUsuarios gestorUsuarios = new GestorUsuarios();

    public void iniciarPrograma() {
        //pruebaGuardarMateriales();
        //pruebaListarMateriales();

        //pruebaGuardarUsuarios();
        pruebaListarUsuarios();
    }

    private void pruebaGuardarMateriales(){
        Audio nuevoAudio = new Audio("001", LocalDate.parse("2020-01-01"), false, EnumTema.ARTE, EnumFormato.CD, 1.48, "Ingles");
        Video nuevoVideo = new Video("002", LocalDate.parse("2020-02-01"), false, EnumTema.LETRA, EnumFormato.DVD, 2.44, "Frances", "Niko Bellic");
        Texto nuevoTexto = new Texto("003", LocalDate.parse("2020-02-01"), true, EnumTema.LETRA, "Las aves del más allá", "Taylor Segura", LocalDate.parse("1980-01-05"), 400, "Español");
        Otro nuevoOtro = new Otro("004", LocalDate.parse("2018-04-07"), false, EnumTema.ARTE, "Lo que sea");

        if(gestorMateriales.guardarMaterial(nuevoAudio)) System.out.println("1 Guardado correctamente");
        if(gestorMateriales.guardarMaterial(nuevoVideo)) System.out.println("2 Guardado correctamente");
        if(gestorMateriales.guardarMaterial(nuevoTexto)) System.out.println("3 Guardado correctamente");
        if(gestorMateriales.guardarMaterial(nuevoOtro)) System.out.println("4 Guardado correctamente");
    }

    private void pruebaListarMateriales(){
        List<Material> materiales = gestorMateriales.listarMateriales();

        for (Material material : materiales) {
            System.out.println(material);
        }
    }

    private void pruebaGuardarUsuarios(){
        Estudiante estudiante = new Estudiante("001", "Fred", "Perez", EnumCarrera.ARTE, 12);
        Profesor profesor = new Profesor("002", "Raul", "Vindas", EnumContrato.MEDIO_TIEMPO, LocalDate.parse("2010-10-23"));
        Administrativo administrativo = new Administrativo("003", "Gabriel", "Zuñiga", EnumNombramiento.A, 16.2);

        if(gestorUsuarios.guardarUsuario(estudiante)) System.out.println("1 Registrado correctamente");
        if(gestorUsuarios.guardarUsuario(profesor)) System.out.println("2 Registrado correctamente");
        if(gestorUsuarios.guardarUsuario(administrativo)) System.out.println("3 Registrado correctamente");
    }

    private void pruebaListarUsuarios(){
        List<Usuario> usuarios = gestorUsuarios.listarUsuarios();

        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}
