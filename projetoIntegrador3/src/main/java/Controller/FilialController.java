package Controller;

import com.thinkcode.DAO.FiliaisDAO;
import com.thinkcode.DAO.ProdutoDAO;
import com.thinkcode.models.FilialModel;
import com.thinkcode.models.ProdutoModel;

/**
 *
 * @author gusta
 */
public class FilialController {

    public boolean Save(FilialModel filial) {
        return FiliaisDAO.cadastrarFilial(filial);
    }
}
