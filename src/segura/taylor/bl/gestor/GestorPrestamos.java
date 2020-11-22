package segura.taylor.bl.gestor;

import segura.taylor.bl.entidades.Prestamo;
import segura.taylor.bl.persistencia.PrestamoFAO;

import java.util.List;
import java.util.Optional;

/**
 * La clase Gestor se encarga de realizar la comunicación entre FAO y el Controlador
 *
 * @author Taylor Segura Vindas
 * @version 1.0
 * @since 2020-11-22
 */
public class GestorPrestamos {
    segura.taylor.bl.persistencia.PrestamoFAO PrestamoFAO = new PrestamoFAO();

    /**
     * Metodo usado para guardar prestamos
     * @param pPrestamo instancia de la clase Prestamo que se desea guardar
     * @return true si se hace correctamente, false si ocurre un error
     * @see Prestamo
     */
    public boolean guardarPrestamo(Prestamo pPrestamo) {
        return PrestamoFAO.guardarNuevoPrestamo(pPrestamo);
    }

    /**
     * Metodo usado para listar prestamos
     * @return una lista con todos los materiales almacenados
     * @see Prestamo
     */
    public List<Prestamo> listarPrestamos() {
        return PrestamoFAO.listarTodos();
    }

    /**
     * Metod usado para buscar un Prestamo basado en su id
     * @param id el id del prestamo que se desea encontrar
     * @return instancia de la clase Prestamo que posee el id especificado
     * @see Prestamo
     */
    public Optional<Prestamo> buscarPorId(String id) {
        return PrestamoFAO.buscarPorId(id);
    }

    /**
     * Metodo usado para buscar prestamos que estén pendientes
     * @param idUsuario id del usuario al que pertenece el prestamo
     * @return instancia de la clase Prestamo que posee el idUsuario especificado y además está pendiente
     * @see Prestamo
     */
    public Optional<Prestamo> buscarPendiente(String idUsuario) {
        return PrestamoFAO.buscarPendiente(idUsuario);
    }

    /**
     * Metodo usado para cerrar prestamos
     * @param prestamo instancia de la clase Prestamo que se desea modificar
     * @return true si se hace correctamente, false si ocurre un error
     * @see Prestamo
     */
    public boolean completarDevolucion(Prestamo prestamo) {
        prestamo.setCompletado(true);
        return PrestamoFAO.modificarPrestamo(prestamo);
    }
}
