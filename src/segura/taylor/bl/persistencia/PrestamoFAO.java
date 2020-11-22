package segura.taylor.bl.persistencia;

import segura.taylor.bl.entidades.Material;
import segura.taylor.bl.entidades.Prestamo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PrestamoFAO {
    private final String directorioPrestamos = "c:\\dev\\Prestamos.csv";

    private UsuarioFAO usuarioFAO = new UsuarioFAO();
    private MaterialFAO materialFAO = new MaterialFAO();

    public boolean guardarNuevoPrestamo(Prestamo nuevoPrestamo) {
        boolean idRepetido = buscarPorId(nuevoPrestamo.getId()).isPresent();

        if(!idRepetido) {
            ArrayList<String> lines = new ArrayList<>();
            lines.add(nuevoPrestamo.toCSV());

            try {
                Files.write(Paths.get(directorioPrestamos), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
    public boolean modificarPrestamo(Prestamo prestamo) {
        ArrayList<String> result = new ArrayList<>();
        BufferedReader reader;

        File archivoPrestamos = new File(directorioPrestamos);
        if(archivoPrestamos.exists()) {
            try {
                int indicePrestamo = -1;
                int cont = 0;

                reader = new BufferedReader(new FileReader(directorioPrestamos));
                String currentLine = reader.readLine();

                while (currentLine != null) {
                    String[] datos = currentLine.split(",");
                    result.add(currentLine);

                    //Guardar el indice del prestamo que se va a modificar.
                    if(datos[0].equals(prestamo.getId())) {
                        indicePrestamo = cont;
                    }

                    currentLine = reader.readLine();
                    cont++;
                }

                //Si el prestamo se encontró
                if(indicePrestamo != -1) {
                    //Se actualiza la informacion
                    result.set(indicePrestamo, prestamo.toCSV());

                    //Y se sobreescribe todo el archivo para aplicar el cambio.
                    try {
                        Files.write(Paths.get(directorioPrestamos), result, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                                StandardOpenOption.WRITE);
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public List<Prestamo> listarTodos() {
        ArrayList<Prestamo> result = new ArrayList<>();
        BufferedReader reader;

        File archivoPrestamos = new File(directorioPrestamos);
        if(archivoPrestamos.exists()) {
            try {
                reader = new BufferedReader(new FileReader(directorioPrestamos));
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    //Aveces se crean lineas en blanco por alguna razon.
                    if(currentLine.length() > 0) {
                        String[] datos = currentLine.split(",");
                        if(datos.length > 0){
                            result.add(leerPrestamoCSV(datos));
                        }
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

    public Optional<Prestamo> buscarPorId(String id) {
        BufferedReader reader;

        File archivoPrestamos = new File(directorioPrestamos);
        if(archivoPrestamos.exists()) {
            try {
                reader = new BufferedReader(new FileReader(directorioPrestamos));
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    String[] datos = currentLine.split(",");
                    //Filtrar por id.
                    if (datos[0].equals(id)) {
                        return Optional.of(leerPrestamoCSV(datos));
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
    public Optional<Prestamo> buscarPendiente(String idUsuario) {
        BufferedReader reader;

        File archivoPrestamos = new File(directorioPrestamos);
        if(archivoPrestamos.exists()) {
            try {
                reader = new BufferedReader(new FileReader(directorioPrestamos));
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    //Aveces se crean lineas en blanco por alguna razon.
                    if(currentLine.length() > 0) {
                        String[] datos = currentLine.split(",");

                        //Filtrar por id.
                        if (datos[1].equals(idUsuario) && datos[4].equals("false")) {
                            return Optional.of(leerPrestamoCSV(datos));
                        }
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

    private Prestamo leerPrestamoCSV(String[] datosLinea) {
        Prestamo prestamo = new Prestamo(datosLinea);

        //Buscar usuario
        prestamo.setUsuario(usuarioFAO.buscarPorId(datosLinea[1]).get());

        if(datosLinea.length > 5) {
            //Buscar materiales asignados
            for (int i = 5; i < datosLinea.length; i++) {
                prestamo.getItems().add(materialFAO.buscarPorId(datosLinea[i]).get());
            }
        }

        return prestamo;
    }
}
