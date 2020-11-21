package segura.taylor.controlador;

import segura.taylor.bl.entidades.*;
import segura.taylor.bl.enums.*;
import segura.taylor.bl.gestor.GestorMateriales;
import segura.taylor.bl.gestor.GestorUsuarios;
import segura.taylor.ui.UI;

import java.time.LocalDate;
import java.util.List;

public class Controlador {
    GestorMateriales gestorMateriales = new GestorMateriales();
    GestorUsuarios gestorUsuarios = new GestorUsuarios();

    UI ui = new UI();

    public void iniciarPrograma() {
        //Pruebas
        //pruebaGuardarMateriales();
        //pruebaGuardarUsuarios();

        int opcion;

        do {
            opcion = mostrarMenu();
            procesarOpcion(opcion);
        } while (opcion != 5);
    }

    private int mostrarMenu() {
        ui.imprimirLinea("Bienvenido, seleccione una opción");
        ui.imprimirLinea("1. Registrar material");
        ui.imprimirLinea("2. Listar materiales");
        ui.imprimirLinea("3. Registrar usuario");
        ui.imprimirLinea("4. Listar usuarios");
        ui.imprimirLinea("5. Salir");
        ui.imprimir("Su opcion: ");
        int opcion = ui.leerEntero();
        return opcion;
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarMaterial();
                break;
            case 2:
                listarMateriales();
                break;
            case 3:
                registrarUsuario();
                break;
            case 4:
                listarUsuarios();
                break;
            case 5:
                ui.imprimirLinea("Adios");
                break;
            default:
                ui.imprimirLinea("Opcion invalida");
                break;
        }
    }
    private void registrarMaterial() {
        //Tipo
        int opcionTipoMaterial;
        do {
            ui.imprimirLinea("Seleccione un tipo de material");
            ui.imprimirLinea("1. Texto");
            ui.imprimirLinea("2. Audio");
            ui.imprimirLinea("3. Video");
            ui.imprimirLinea("4. Otro");
            ui.imprimir("Su opcion: ");
            opcionTipoMaterial = ui.leerEntero();

            if(opcionTipoMaterial < 1 || opcionTipoMaterial > 4) {
                ui.imprimirLinea("Opcion invalida\n\n");
            }
        } while (opcionTipoMaterial < 1 || opcionTipoMaterial > 4);

        //Datos generales para material
        ui.imprimir("Signatura: ");
        String signatura = ui.leerLinea();

        ui.imprimir("Fecha de compra(yyyy-mm-dd): ");
        LocalDate fechaCompra = LocalDate.parse(ui.leerLinea());

        //Restringido
        int opcionRestringido;
        do {
            ui.imprimirLinea("Es restringido?");
            ui.imprimirLinea("1. Si");
            ui.imprimirLinea("2. No");
            ui.imprimir("Su opcion: ");
            opcionRestringido = ui.leerEntero();

            if((opcionRestringido < 1 || opcionRestringido > 2)) {
                ui.imprimirLinea("Opcion invalida\n\n");
            }
        } while (opcionRestringido < 1 || opcionRestringido > 2);

        boolean restringido = (opcionRestringido == 1);

        //Tema
        int opcionTema;
        EnumTema tema = EnumTema.INDEFINIDO;
        do {
            ui.imprimirLinea("Seleccione un tema");
            ui.imprimirLinea("1. Ciencias");
            ui.imprimirLinea("2. Letra");
            ui.imprimirLinea("3. Ingenieria");
            ui.imprimirLinea("4. Arte");
            ui.imprimir("Su opcion: ");
            opcionTema = ui.leerEntero();

            if(opcionTema < 1 || opcionTema > 4) {
                ui.imprimirLinea("Opcion invalida\n\n");
            }
        } while (opcionTema < 1 || opcionTema > 4);

        switch (opcionTema) {
            case 1:
                tema = EnumTema.CIENCIAS;
                break;
            case 2:
                tema = EnumTema.LETRA;
                break;
            case 3:
                tema = EnumTema.INGENIERIA;
                break;
            case 4:
                tema = EnumTema.ARTE;
                break;
        }

        //Datos especializados para cada tipo de material
        String idioma;
        int opcionFormato;
        double duracion;
        EnumFormato formato = EnumFormato.INDEFINIDO;
        String director;

        boolean resultado = false;

        switch (opcionTipoMaterial) {
            case 1:
                ui.imprimir("Titulo: ");
                String titulo = ui.leerLinea();
                ui.imprimir("Autor: ");
                String nombreAutor = ui.leerLinea();
                ui.imprimir("Fecha publicacion(yyyy-mm-dd): ");
                LocalDate fechaPublicacion = LocalDate.parse(ui.leerLinea());
                ui.imprimir("Cantidad de paginas: ");
                int cantPaginas = ui.leerEntero();
                ui.imprimir("Idioma: ");
                idioma = ui.leerLinea();

                Texto nuevoTexto = new Texto(signatura, fechaCompra, restringido, tema, titulo, nombreAutor, fechaPublicacion, cantPaginas, idioma);
                resultado = gestorMateriales.guardarMaterial(nuevoTexto);
                break;
            case 2:
                //Formato
                do {
                    ui.imprimirLinea("Seleccione un tema");
                    ui.imprimirLinea("1. Casete");
                    ui.imprimirLinea("2. CD");
                    ui.imprimirLinea("3. DVD");
                    ui.imprimir("Su opcion: ");
                    opcionTema = ui.leerEntero();

                    if(opcionTema < 1 || opcionTema > 3) {
                        ui.imprimirLinea("Opcion invalida\n\n");
                    }
                } while (opcionTema < 1 || opcionTema > 4);

                switch (opcionTema) {
                    case 1:
                        formato = EnumFormato.CASETE;
                        break;
                    case 2:
                        formato = EnumFormato.CD;
                        break;
                    case 3:
                        formato = EnumFormato.DVD;
                        break;
                }

                ui.imprimir("Duracion: ");
                duracion = ui.leerDouble();
                ui.imprimir("Idioma: ");
                idioma = ui.leerLinea();

                Audio nuevoAudio = new Audio(signatura, fechaCompra, restringido, tema, formato, duracion, idioma);
                resultado = gestorMateriales.guardarMaterial(nuevoAudio);
                break;
            case 3:
                //Formato
                do {
                    ui.imprimirLinea("Seleccione un tema");
                    ui.imprimirLinea("1. DVD");
                    ui.imprimirLinea("2. VHS");
                    ui.imprimirLinea("3. VCD");
                    ui.imprimir("Su opcion: ");
                    opcionTema = ui.leerEntero();

                    if(opcionTema < 1 || opcionTema > 3) {
                        ui.imprimirLinea("Opcion invalida\n\n");
                    }
                } while (opcionTema < 1 || opcionTema > 4);
                switch (opcionTema) {
                    case 1:
                        formato = EnumFormato.DVD;
                        break;
                    case 2:
                        formato = EnumFormato.VHS;
                        break;
                    case 3:
                        formato = EnumFormato.VCD;
                        break;
                }

                ui.imprimir("Duracion: ");
                duracion = ui.leerDouble();
                ui.imprimir("Idioma: ");
                idioma = ui.leerLinea();
                ui.imprimir("Director: ");
                director = ui.leerLinea();

                Video nuevoVideo = new Video(signatura, fechaCompra, restringido, tema, formato, duracion, idioma, director);
                resultado = gestorMateriales.guardarMaterial(nuevoVideo);
                break;
            case 4:
                ui.imprimir("Descripcion: ");
                String descripcion = ui.leerLinea();
                Otro nuevoMaterial = new Otro(signatura, fechaCompra, restringido, tema, descripcion);
                resultado = gestorMateriales.guardarMaterial(nuevoMaterial);
                break;
        }

        if(resultado) {
            ui.imprimirLinea("Material registrado correctamente");
        } else {
            ui.imprimirLinea("Ya existe un material con el id especificado");
        }
    }
    private void listarMateriales() {
        List<Material> materiales = gestorMateriales.listarMateriales();

        for (Material material : materiales) {
            ui.imprimirLinea(material.toString());
        }
    }

    private void registrarUsuario() {

    }
    private void listarUsuarios() {
        List<Usuario> usuarios = gestorUsuarios.listarUsuarios();

        for (Usuario usuario : usuarios) {
            ui.imprimirLinea(usuario.toString());
        }
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
    private void pruebaGuardarUsuarios(){
        Estudiante estudiante = new Estudiante("001", "Fred", "Perez", EnumCarrera.ARTE, 12);
        Profesor profesor = new Profesor("002", "Raul", "Vindas", EnumContrato.MEDIO_TIEMPO, LocalDate.parse("2010-10-23"));
        Administrativo administrativo = new Administrativo("003", "Gabriel", "Zuñiga", EnumNombramiento.A, 16.2);

        if(gestorUsuarios.guardarUsuario(estudiante)) System.out.println("1 Registrado correctamente");
        if(gestorUsuarios.guardarUsuario(profesor)) System.out.println("2 Registrado correctamente");
        if(gestorUsuarios.guardarUsuario(administrativo)) System.out.println("3 Registrado correctamente");
    }
}
