package Controller;

import com.thinkcode.DAO.PerfilDAO;
import com.thinkcode.models.PerfilModel;
import java.util.List;

/**
 *
 * @author gusta
 */
public class PerfilController {

    public boolean Save(PerfilModel perfil) {
        return PerfilDAO.cadastrarPerfil(perfil);
    }

    public boolean Update(PerfilModel perfil) {
        return PerfilDAO.atualizarPerfil(perfil);
    }

    public PerfilModel PerfilPropriedades(PerfilModel perfil) {
        return PerfilDAO.consultarPerfil(perfil);
    }

    public List<PerfilModel> PerfisCadastrados(String filtroDescricao, String filtroTipo) {
        return PerfilDAO.PerfisCadastrados(filtroDescricao, filtroTipo);
    }

}
