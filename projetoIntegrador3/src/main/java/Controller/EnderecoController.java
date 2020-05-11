package Controller;

import com.thinkcode.DAO.EnderecoDAO;
import com.thinkcode.models.EnderecoModel;

/**
 *
 * @author gusta
 */
public class EnderecoController {

    public boolean Save(EnderecoModel endereco) {
        return EnderecoDAO.cadastrarEndereco(endereco);
    }
}
