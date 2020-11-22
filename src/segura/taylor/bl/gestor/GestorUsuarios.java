package segura.taylor.bl.gestor;

import segura.taylor.bl.entidades.Usuario;
import segura.taylor.bl.enums.EnumTipoUsuario;
import segura.taylor.bl.persistencia.UsuarioFAO;

import java.util.List;
import java.util.Optional;

/**
 * La clase Gestor se encarga de realizar la comunicación entre FAO y el Controlador
 *
 * @author Taylor Segura Vindas
 * @version 1.0
 * @since 2020-11-22
 */
public class GestorUsuarios {
    UsuarioFAO UsuarioFAO = new UsuarioFAO();

    /**
     * Metodo usado para guardar un usuario
     * @param pUsuario instancia de la clase Usuario que se desea guardar
     * @return true si se hace correctamente, false si ocurre un error
     * @see Usuario
     */
    public boolean guardarUsuario(Usuario pUsuario) {
        return UsuarioFAO.guardarNuevoUsuario(pUsuario);
    }

    /**
     * Metodo usado para listar usuarios
     * @return lista de todos los usuarios almacenados
     * @see Usuario
     */
    public List<Usuario> listarUsuarios() {
        return UsuarioFAO.listarTodos();
    }

    /**
     * Metodo usado para listar usuarios usando como filtro su tipo
     * @param tipo el tipo de usuario que se desea mostrar
     * @return lista de todos los usuarios almacenados que poseen el tipo especificado
     * @see EnumTipoUsuario
     */
    public List<Usuario> listarUsuariosPorTipo(EnumTipoUsuario tipo) {
        return UsuarioFAO.listarPorTipo(tipo);
    }

    /**
     * Metodo usado para buscar un usuario en especifico basado en su id
     * @param id el id del usuario que se desea encontrar
     * @return instancia de la clase Usuario que posee el id especificado
     * @see Usuario
     */
    public Optional<Usuario> buscarPorId(String id) {
        return UsuarioFAO.buscarPorId(id);
    }
}
