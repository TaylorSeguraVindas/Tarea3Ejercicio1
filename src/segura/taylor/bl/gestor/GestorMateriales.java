package segura.taylor.bl.gestor;

import segura.taylor.bl.entidades.Material;
import segura.taylor.bl.enums.EnumTipoMaterial;
import segura.taylor.bl.persistencia.MaterialFAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestorMateriales {
    MaterialFAO materialFAO = new MaterialFAO();

    public boolean guardarMaterial(Material pMaterial) {
        return materialFAO.guardarNuevoMaterial(pMaterial);
    }

    public List<Material> listarMateriales() {
        return materialFAO.listarTodos();
    }

    public List<Material> listarMaterialesPorTipo(EnumTipoMaterial tipo) {
        return materialFAO.listarPorTipo(tipo);
    }

    public Optional<Material> buscarPorId(String id) {
        return materialFAO.buscarPorId(id);
    }
}
