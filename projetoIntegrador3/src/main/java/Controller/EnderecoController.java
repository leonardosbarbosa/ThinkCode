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

    public EnderecoModel EnderecoUsuario(int Id_Usuario) {
        return EnderecoDAO.consultarEndrecoIdUsuario(Id_Usuario);
    }
    
      public boolean Update(EnderecoModel endereco) {
        return EnderecoDAO.atualizarEndereco(endereco);
    }
}
