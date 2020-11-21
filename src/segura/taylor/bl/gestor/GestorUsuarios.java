package segura.taylor.bl.gestor;

import segura.taylor.bl.entidades.Usuario;
import segura.taylor.bl.enums.EnumTipoUsuario;
import segura.taylor.bl.persistencia.UsuarioFAO;

import java.util.List;
import java.util.Optional;

public class GestorUsuarios {
    UsuarioFAO UsuarioFAO = new UsuarioFAO();

    public boolean guardarUsuario(Usuario pUsuario) {
        return UsuarioFAO.guardarNuevoUsuario(pUsuario);
    }

    public List<Usuario> listarUsuarios() {
        return UsuarioFAO.listarTodos();
    }

    public List<Usuario> listarUsuariosPorTipo(EnumTipoUsuario tipo) {
        return UsuarioFAO.listarPorTipo(tipo);
    }

    public Optional<Usuario> buscarPorId(String id) {
        return UsuarioFAO.buscarPorId(id);
    }
}
