package segura.taylor.bl.gestor;

import segura.taylor.bl.entidades.Material;
import segura.taylor.bl.enums.EnumTipoMaterial;
import segura.taylor.bl.persistencia.MaterialFAO;

import java.util.List;
import java.util.Optional;

/**
 * La clase Gestor se encarga de realizar la comunicación entre FAO y el Controlador
 *
 * @author Taylor Segura Vindas
 * @version 1.0
 * @since 2020-11-22
 */
public class GestorMateriales {
    MaterialFAO materialFAO = new MaterialFAO();

    /**
     * Metodo usado para guardar materiales
     * @param pMaterial instancia de la clase Material que se desea guardar
     * @return true si se hace correctamente, false si ocurre un error
     * @see Material
     */
    public boolean guardarMaterial(Material pMaterial) {
        return materialFAO.guardarNuevoMaterial(pMaterial);
    }

    /**
     * Metodo usado para listar materiales
     * @return lista con todos los materiales almacenados
     * @see Material
     */
    public List<Material> listarMateriales() {
        return materialFAO.listarTodos();
    }

    /**
     * Metodo usado para listar materiales por tipo
     * @param tipo tipo que se usa para realizar el filtro
     * @return lista de materiales del mismo tipo especificado
     * @see Material
     */
    public List<Material> listarMaterialesPorTipo(EnumTipoMaterial tipo) {
        return materialFAO.listarPorTipo(tipo);
    }

    /**
     * Metodo usado para buscar un material basado en su id
     * @param id id del material que se desea encontrar
     * @return instancia de la clase material
     * @see Material
     */
    public Optional<Material> buscarPorId(String id) {
        return materialFAO.buscarPorId(id);
    }
}
