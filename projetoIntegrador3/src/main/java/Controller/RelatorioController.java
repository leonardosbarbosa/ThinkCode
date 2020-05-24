package Controller;

import com.thinkcode.DAO.RelatorioDAO;
import com.thinkcode.models.RelatorioModel;
import java.util.List;

/**
 *
 * @author Gustavo Nascimento
 */
public class RelatorioController {

    public List<RelatorioModel> ProdutosCadastrados(RelatorioModel _filtros) {
        return RelatorioDAO.VendasEfetuadas(_filtros);
    }
}
