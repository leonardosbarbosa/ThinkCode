package Controller;

import com.thinkcode.DAO.UsuarioDAO;
import com.thinkcode.models.UsuarioModel;

/**
 *
 * @author gusta
 */
public class UsuarioController {

    public boolean Save(UsuarioModel Usuario) {
        return UsuarioDAO.cadastrarUsuario(Usuario);

    }

    public boolean Login(UsuarioModel Usuario) {
        return UsuarioDAO.consultarUsuarioCadastrado(Usuario);
    }

    public UsuarioModel UsuarioPropriedades(UsuarioModel user) {
        UsuarioDAO.consultarUsuario(user);
        return user;
    }
}
