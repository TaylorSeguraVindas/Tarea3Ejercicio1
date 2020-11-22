package segura.taylor.bl.gestor;

import segura.taylor.bl.entidades.Prestamo;
import segura.taylor.bl.persistencia.PrestamoFAO;

import java.util.List;
import java.util.Optional;

public class GestorPrestamos {
    segura.taylor.bl.persistencia.PrestamoFAO PrestamoFAO = new PrestamoFAO();

    public boolean guardarPrestamo(Prestamo pPrestamo) {
        return PrestamoFAO.guardarNuevoPrestamo(pPrestamo);
    }

    public List<Prestamo> listarPrestamos() {
        return PrestamoFAO.listarTodos();
    }

    public Optional<Prestamo> buscarPorId(String id) {
        return PrestamoFAO.buscarPorId(id);
    }

    public Optional<Prestamo> buscarPendiente(String idUsuario) {
        return PrestamoFAO.buscarPendiente(idUsuario);
    }

    public boolean completarDevolucion(Prestamo prestamo) {
        prestamo.setCompletado(true);
        return PrestamoFAO.modificarPrestamo(prestamo);
    }
}
