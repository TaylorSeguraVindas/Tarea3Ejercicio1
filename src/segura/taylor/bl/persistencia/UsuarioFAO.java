package segura.taylor.bl.persistencia;

import segura.taylor.bl.entidades.*;
import segura.taylor.bl.enums.EnumTipoUsuario;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * La clase FAO se encarga de toda la lógica de acceso a los archivos ya sea para lectura o escritura
 *
 * @author Taylor Segura Vindas
 * @version 1.0
 * @since 2020-11-22
 */
public class UsuarioFAO {
    private final String directorioUsuarios = "c:\\dev\\Usuarios.csv";

    /**
     * Metodo para guardar un nuevo Usuario en el archivo
     * @param nuevoUsuario instancia de la clase Usuario que será almacenado
     * @return true si se realiza correctamente, false si ocurre un error
     * @see Usuario
     */
    public boolean guardarNuevoUsuario(Usuario nuevoUsuario) {
        boolean idRepetido = buscarPorId(nuevoUsuario.getId()).isPresent();

        if(!idRepetido) {
            ArrayList<String> lines = new ArrayList<>();
            lines.add(nuevoUsuario.toCSV());

            try {
                Files.write(Paths.get(directorioUsuarios), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    /**
     * Metodo usado para leer todos los Usuarios almacenados
     * @return lista con instancias de la clase Usuario
     * @see Usuario
     */
    public List<Usuario> listarTodos() {
        ArrayList<Usuario> result = new ArrayList<>();
        BufferedReader reader;

        File archivoUsuarios = new File(directorioUsuarios);
        if(archivoUsuarios.exists()) {
            try {
                reader = new BufferedReader(new FileReader(directorioUsuarios));
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    String[] datos = currentLine.split(",");
                    result.add(leerUsuarioCSV(datos));

                    currentLine = reader.readLine();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * Metodo usado si se quiere realizar una lista de Usuarioes filtrado por tipo
     * @param tipo valor del EnumTipoUsuario que define el tipo que se debe mostrar
     * @return lista que contiene instancias de la clase Usuario del tipo especificado
     * @see EnumTipoUsuario
     * @see Usuario
     */
    public List<Usuario> listarPorTipo(EnumTipoUsuario tipo) {
        ArrayList<Usuario> result = new ArrayList<>();
        BufferedReader reader;

        File archivoUsuarios = new File(directorioUsuarios);
        if(archivoUsuarios.exists()) {
            try {
                reader = new BufferedReader(new FileReader(directorioUsuarios));
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    String[] datos = currentLine.split(",");
                    //Filtrar por tipo.
                    if (EnumTipoUsuario.valueOf(datos[0]).equals(tipo)) {
                        result.add(leerUsuarioCSV(datos));
                    }

                    currentLine = reader.readLine();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Metodo usado para buscar un Usuario usando como filtro el id especificado
     * @param id identificador del Usuario que se busca
     * @return instancia de la clase Usuario que coincide con el identificador enviado
     * @see Usuario
     */
    public Optional<Usuario> buscarPorId(String id) {
        BufferedReader reader;

        File archivoUsuarios = new File(directorioUsuarios);
        if(archivoUsuarios.exists()) {
            try {
                reader = new BufferedReader(new FileReader(directorioUsuarios));
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    String[] datos = currentLine.split(",");
                    //Filtrar por signatura o id.
                    if (datos[1].equals(id)) {
                        return Optional.of(leerUsuarioCSV(datos));
                    }

                    currentLine = reader.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    /**
     * Metodo para crear instancias de la clase Usuario usando datos leidos de un archivo
     * @param datosLinea arreglo de String con los datos necesarios para inicializar la clase
     * @return una instancia de la clase Usuario
     * @see Usuario
     */
    private Usuario leerUsuarioCSV(String[] datosLinea) {
        EnumTipoUsuario tipoUsuario = EnumTipoUsuario.valueOf(datosLinea[0]);    //El primer atributo siempre define el tipo de Usuario

        if(EnumTipoUsuario.ESTUDIANTE.equals(tipoUsuario)) {
            return new Estudiante(datosLinea);
        }
        if(EnumTipoUsuario.PROFESOR.equals(tipoUsuario)) {
            return new Profesor(datosLinea);
        }
        if(EnumTipoUsuario.ADMINISTRATIVO.equals(tipoUsuario)) {
            return new Administrativo(datosLinea);
        }
        return null;
    }
}
