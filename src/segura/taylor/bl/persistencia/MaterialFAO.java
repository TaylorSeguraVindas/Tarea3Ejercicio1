package segura.taylor.bl.persistencia;

import segura.taylor.bl.entidades.*;
import segura.taylor.bl.enums.EnumTipoMaterial;

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
public class MaterialFAO {
    private final String directorioMateriales = "c:\\dev\\Materiales.csv";

    /**
     * Metodo para guardar un nuevo material en el archivo
     * @param nuevoMaterial instancia de la clase Material que será almacenado
     * @return true si se realiza correctamente, false si ocurre un error
     * @see Material
     */
    public boolean guardarNuevoMaterial(Material nuevoMaterial) {
        boolean idRepetido = buscarPorId(nuevoMaterial.getSignatura()).isPresent();

        if(!idRepetido) {
            ArrayList<String> lines = new ArrayList<>();
            lines.add(nuevoMaterial.toCSV());

            try {
                Files.write(Paths.get(directorioMateriales), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }

        return false;
    }

    /**
     * Metodo usado para leer todos los materiales del archivo
     * @return una lista con todos los materiales almacenados
     * @see List
     * @see Material
     */
    public List<Material> listarTodos() {
        ArrayList<Material> result = new ArrayList<>();
        BufferedReader reader;

        File archivoMateriales = new File(directorioMateriales);
        if(archivoMateriales.exists()) {
            try {
                reader = new BufferedReader(new FileReader(directorioMateriales));
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    String[] datos = currentLine.split(",");
                    result.add(leerMaterialCSV(datos));

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
     * Metodo usado si se quiere realizar una lista de materiales filtrado por tipo
     * @param tipo valor del EnumTipoMaterial que define el tipo que se debe mostrar
     * @return lista que contiene instancias de la clase Material del tipo especificado
     * @see EnumTipoMaterial
     * @see Material
     */
    public List<Material> listarPorTipo(EnumTipoMaterial tipo) {
        ArrayList<Material> result = new ArrayList<>();
        BufferedReader reader;

        File archivoMateriales = new File(directorioMateriales);
        if(archivoMateriales.exists()) {
            try {
                reader = new BufferedReader(new FileReader(directorioMateriales));
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    String[] datos = currentLine.split(",");
                    //Filtrar por tipo.
                    if (EnumTipoMaterial.valueOf(datos[0]).equals(tipo)) {
                        result.add(leerMaterialCSV(datos));
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
     * Metodo usado para buscar un material usando como filtro el id especificado
     * @param id identificador del material que se busca
     * @return instancia de la clase material que coincide con el identificador enviado
     * @see Material
     */
    public Optional<Material> buscarPorId(String id) {
        BufferedReader reader;

        File archivoMateriales = new File(directorioMateriales);
        if(archivoMateriales.exists()) {
            try {
                reader = new BufferedReader(new FileReader(directorioMateriales));
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    String[] datos = currentLine.split(",");
                    //Filtrar por signatura o id.
                    if (datos[1].equals(id)) {
                        return Optional.of(leerMaterialCSV(datos));
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
     * Metodo usado para generar instancias de la clase material usando datos leidos de un archivo
     * @param datosLinea un arreglo de String con los datos necesarios para inicializar la clase
     * @return una instancia de la clase Material
     * @see Material
     */
    private Material leerMaterialCSV(String[] datosLinea) {
        EnumTipoMaterial tipoMaterial = EnumTipoMaterial.valueOf(datosLinea[0]);    //El primer atributo siempre define el tipo de material

        if(EnumTipoMaterial.AUDIO.equals(tipoMaterial)) {
            return new Audio(datosLinea);
        }
        if(EnumTipoMaterial.OTRO.equals(tipoMaterial)) {
            return new Otro(datosLinea);
        }
        if(EnumTipoMaterial.TEXTO.equals(tipoMaterial)) {
            return new Texto(datosLinea);
        }
        if(EnumTipoMaterial.VIDEO.equals(tipoMaterial)) {
            return new Video(datosLinea);
        }
        return null;
    }
}
