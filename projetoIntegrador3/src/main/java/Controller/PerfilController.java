
package Controller;

import com.thinkcode.DAO.PerfilDAO;
import com.thinkcode.models.PerfilModel;

/**
 *
 * @author gusta
 */
public class PerfilController {
    public boolean Save(PerfilModel perfil) {
        return PerfilDAO.cadastrarPerfil(perfil);
    }
}
