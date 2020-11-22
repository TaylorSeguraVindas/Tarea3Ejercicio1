package segura.taylor.controlador;

import segura.taylor.bl.entidades.*;
import segura.taylor.bl.enums.*;
import segura.taylor.bl.gestor.GestorMateriales;
import segura.taylor.bl.gestor.GestorPrestamos;
import segura.taylor.bl.gestor.GestorUsuarios;
import segura.taylor.ui.UI;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * La clase Controlador se usa para realizar la comunicación entre
 * el UI y los Gestores
 *
 * @author Taylor Segura Vindas
 * @version 1.0
 * @since 2020-11-22
 */
public class Controlador {
    GestorMateriales gestorMateriales = new GestorMateriales();
    GestorUsuarios gestorUsuarios = new GestorUsuarios();
    GestorPrestamos gestorPrestamos = new GestorPrestamos();

    UI ui = new UI();

    /**
     * Metodo usado para iniciar la ejecucion del programa
     */
    public void iniciarPrograma() {
        //Pruebas
        //pruebaGuardarMateriales();
        //pruebaGuardarUsuarios();

        int opcion;

        do {
            opcion = mostrarMenu();
            procesarOpcion(opcion);
        } while (opcion != 8);
    }

    /**
     * Metodo usado para obtener la accion que desea realizar el usuario
     * @return la opcion seleccionada por el usuario
     */
    private int mostrarMenu() {
        ui.imprimirLinea("Bienvenido, seleccione una opción");
        ui.imprimirLinea("1. Registrar material");
        ui.imprimirLinea("2. Listar materiales");
        ui.imprimirLinea("3. Registrar usuario");
        ui.imprimirLinea("4. Listar usuarios");
        ui.imprimirLinea("5. Realizar prestamo");
        ui.imprimirLinea("6. Realizar devolucion");
        ui.imprimirLinea("7. Listar prestamos");
        ui.imprimirLinea("8. Salir");
        ui.imprimir("Su opcion: ");
        int opcion = ui.leerEntero();
        return opcion;
    }

    /**
     * Metodo usado para determinar la siguiente accion que debe realizar el programa
     * @param opcion entero que define la siguiente accion del programa
     */
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
                registrarPrestamo();
                break;
            case 6:
                realizarDevolucion();
                break;
            case 7:
                listarPrestamos();
                break;
            case 8:
                ui.imprimirLinea("Adios");
                break;
            default:
                ui.imprimirLinea("Opcion invalida");
                break;
        }
    }

    /**
     * Metodo usado para registrar materiales
     */
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
    /**
     * Metodo usado para listar materiales
     */
    private void listarMateriales() {
        List<Material> materiales = gestorMateriales.listarMateriales();

        for (Material material : materiales) {
            ui.imprimirLinea(material.toString());
        }
    }

    /**
     * Metodo usado para registrar usuarios
     */
    private void registrarUsuario() {
        boolean resultado = false;

        //Tipo
        int opcionTipoUsuario;
        do {
            ui.imprimirLinea("Seleccione un tipo de usuario");
            ui.imprimirLinea("1. Estudiante");
            ui.imprimirLinea("2. Profesor");
            ui.imprimirLinea("3. Administrativo");
            ui.imprimir("Su opcion: ");
            opcionTipoUsuario = ui.leerEntero();

            if(opcionTipoUsuario < 1 || opcionTipoUsuario > 3) {
                ui.imprimirLinea("Opcion invalida\n\n");
            }
        } while (opcionTipoUsuario < 1 || opcionTipoUsuario > 3);

        //Datos generales
        ui.imprimir("Id: ");
        String id = ui.leerLinea();
        ui.imprimir("Nombre: ");
        String nombre = ui.leerLinea();
        ui.imprimir("Apellido: ");
        String apellido = ui.leerLinea();

        //Datos especializados para cada tipo de usuario
        switch (opcionTipoUsuario) {
            case 1:
                int opcionCarrera;
                EnumCarrera carrera = EnumCarrera.ARTE;

                do {
                    ui.imprimirLinea("Seleccione una carrera");
                    ui.imprimirLinea("1. Arte");
                    ui.imprimirLinea("2. Administracion de empresas");
                    ui.imprimirLinea("3. Ingenieria de software");
                    ui.imprimirLinea("4. Ingles");
                    ui.imprimirLinea("5. Contabilidad");
                    ui.imprimirLinea("6. Periodismo");
                    ui.imprimir("Su opcion: ");
                    opcionCarrera = ui.leerEntero();

                    if (opcionCarrera < 1 || opcionCarrera > 6) {
                        ui.imprimirLinea("Opcion invalida");
                    }
                } while (opcionCarrera < 1 || opcionCarrera > 6);
                switch (opcionCarrera) {
                    case 1:
                        carrera = EnumCarrera.ARTE;
                        break;
                    case 2:
                        carrera = EnumCarrera.ADMIN_EMPRESAS;
                        break;
                    case 3:
                        carrera = EnumCarrera.ING_SOFTWARE;
                        break;
                    case 4:
                        carrera = EnumCarrera.INGLES;
                        break;
                    case 5:
                        carrera = EnumCarrera.CONTABILIDAD;
                        break;
                    case 6:
                        carrera = EnumCarrera.PERIODISMO;
                        break;
                }

                ui.imprimir("Creditos: ");
                int creditos = ui.leerEntero();

                Estudiante nuevoEstudiante = new Estudiante(id, nombre, apellido, carrera, creditos);
                resultado = gestorUsuarios.guardarUsuario(nuevoEstudiante);
                break;
            case 2:
                int opcionContrato;
                EnumContrato contrato = EnumContrato.COMPLETO;

                do {
                    ui.imprimirLinea("Seleccione un contrato");
                    ui.imprimirLinea("1. Tiempo");
                    ui.imprimirLinea("2. Completo");
                    ui.imprimirLinea("3. Medio tiempo");
                    ui.imprimir("Su opcion: ");
                    opcionContrato = ui.leerEntero();

                    if(opcionContrato < 1 || opcionContrato > 3) {
                        ui.imprimirLinea("Opcion invalida");
                    }
                } while (opcionContrato < 1 || opcionContrato > 3);
                switch (opcionContrato) {
                    case 1:
                        contrato = EnumContrato.TIEMPO;
                        break;
                    case 2:
                        contrato = EnumContrato.COMPLETO;
                        break;
                    case 3:
                        contrato = EnumContrato.MEDIO_TIEMPO;
                        break;
                }

                ui.imprimir("Fecha contratacion(yyyy-mm-dd): ");
                LocalDate fechaContratacion = LocalDate.parse(ui.leerLinea());

                Profesor nuevoProfesor = new Profesor(id, nombre, apellido, contrato, fechaContratacion);
                resultado = gestorUsuarios.guardarUsuario(nuevoProfesor);
                break;
            case 3:
                int opcionNombramiento;
                EnumNombramiento nombramiento = EnumNombramiento.A;

                do {
                    ui.imprimirLinea("Seleccione un nombramiento");
                    ui.imprimirLinea("1. A");
                    ui.imprimirLinea("2. B");
                    ui.imprimirLinea("3. C");
                    ui.imprimir("Su opcion: ");
                    opcionContrato = ui.leerEntero();

                    if(opcionContrato < 1 || opcionContrato > 3) {
                        ui.imprimirLinea("Opcion invalida");
                    }
                } while (opcionContrato < 1 || opcionContrato > 3);
                switch (opcionContrato) {
                    case 1:
                        nombramiento = EnumNombramiento.A;
                        break;
                    case 2:
                        nombramiento = EnumNombramiento.B;
                        break;
                    case 3:
                        nombramiento = EnumNombramiento.C;
                        break;
                }

                ui.imprimir("Horas asignadas: ");
                int horasAsignadas = ui.leerEntero();

                Administrativo nuevoAdministrativo = new Administrativo(id, nombre, apellido, nombramiento, horasAsignadas);
                resultado = gestorUsuarios.guardarUsuario(nuevoAdministrativo);
                break;
        }

        if(resultado) {
            ui.imprimirLinea("Usuario registrado correctamente");
        } else {
            ui.imprimirLinea("Ya existe un usuario con el id especificado");
        }
    }
    /**
     * Metodo usado para listar usuarios
     */
    private void listarUsuarios() {
        List<Usuario> usuarios = gestorUsuarios.listarUsuarios();

        for (Usuario usuario : usuarios) {
            ui.imprimirLinea(usuario.toString());
        }
    }

    /**
     * Metodo usado para registrar prestamos
     */
    private void registrarPrestamo() {
        ui.imprimir("Ingrese el id del usuario que realiza el prestamo: ");
        String idUsuario = ui.leerLinea();

        Optional<Usuario> usuario = gestorUsuarios.buscarPorId(idUsuario);

        if(usuario.isPresent()) {
            if (!gestorPrestamos.buscarPendiente(idUsuario).isPresent()) {
                ui.imprimir("ID prestamo: ");
                String id = ui.leerLinea();
                ui.imprimirLinea("Fecha devolucion(yyyy-mm-dd): ");
                LocalDate fechaDevolucion = LocalDate.parse(ui.leerLinea());

                LocalDate fechaCreacion = LocalDate.now();
                boolean completado = false;

                //Materiales
                ArrayList<Material> items = new ArrayList<>();
                boolean agregarMateriales = true;

                do {
                    listarMateriales();
                    ui.imprimirLinea("Ingrese el id del material que desea incluir: ");
                    String idMaterial = ui.leerLinea();

                    Optional<Material> material = gestorMateriales.buscarPorId(idMaterial);
                    if(material.isPresent()) {
                        items.add(material.get());
                        ui.imprimirLinea("Material agregado correctamente");
                    } else {
                        ui.imprimirLinea("No se encontró el material");
                    }

                    ui.imprimirLinea("\n\nDesea agregar otro material?");
                    ui.imprimirLinea("1. Si");
                    ui.imprimirLinea("2. No");

                    agregarMateriales = (ui.leerEntero() == 1);
                } while (agregarMateriales);

                Prestamo nuevoPrestamo = new Prestamo(id, usuario.get(), items, fechaCreacion, fechaDevolucion, false);
                boolean resultado = gestorPrestamos.guardarPrestamo(nuevoPrestamo);

                if(resultado) {
                    ui.imprimirLinea("Prestamo registrado correctamente");
                } else {
                    ui.imprimirLinea("Ocurrió un problema al registrar el prestamo");
                }
            } else {
                ui.imprimirLinea("El usuario no puede realizar el prestamo porque ya tiene uno pendiente");
            }
        } else {
            ui.imprimirLinea("El usuario no existe");
        }
    }
    /**
     * Metodo usado para completar prestamos
     */
    private void realizarDevolucion() {
        ui.imprimir("Ingrese el id del usuario que realiza la devolucion: ");
        String idUsuario = ui.leerLinea();

        Optional<Usuario> usuario = gestorUsuarios.buscarPorId(idUsuario);

        if(usuario.isPresent()) {
            Optional<Prestamo> prestamo = gestorPrestamos.buscarPendiente(idUsuario);
            if (prestamo.isPresent()) {
                boolean resultado = gestorPrestamos.completarDevolucion(prestamo.get());

                Period period = Period.between(prestamo.get().getFechaDevolucion(), LocalDate.now());

                if(period.getDays() > 0) {
                    ui.imprimirLinea("La entrega está atrasada por lo que debe pagar la multa.");
                }

                if(resultado) {
                    ui.imprimirLinea("Devolucion realizada correctamente");
                } else {
                    ui.imprimirLinea("Ocurrió un problema al realizar la devolucion");
                }
            } else {
                ui.imprimirLinea("El usuario no tiene prestamos pendientes");
            }
        } else {
            ui.imprimirLinea("El usuario no existe");
        }
    }
    /**
     * Metodo usado para listar prestamos
     */
    private void listarPrestamos() {
        List<Prestamo> prestamos = gestorPrestamos.listarPrestamos();

        for (Prestamo prestamo : prestamos) {
            ui.imprimirLinea(prestamo.toString());
        }
    }
}
