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

public class MaterialFAO {
    private final String directorioMateriales = "c:\\dev\\Materiales.csv";

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