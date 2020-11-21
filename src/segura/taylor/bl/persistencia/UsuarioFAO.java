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

public class UsuarioFAO {
    private final String directorioUsuarios = "c:\\dev\\Usuarios.csv";

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
