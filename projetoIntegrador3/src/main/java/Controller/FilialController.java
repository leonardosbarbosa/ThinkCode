package Controller;

import com.thinkcode.DAO.FilialDAO;
import com.thinkcode.DAO.ProdutoDAO;
import com.thinkcode.models.FilialModel;
import com.thinkcode.models.ProdutoModel;
import java.util.List;

/**
 *
 * @author gusta
 */
public class FilialController {

    public boolean Save(FilialModel filial) {
        return FilialDAO.cadastrarFilial(filial);
    }
    
     public boolean Update(FilialModel Filial) {
        return FilialDAO.atualizarFilial(Filial);

    }
     
     public boolean Delete (int idFilial, int idUser) {
     
     return FilialDAO.excluirFilial(idFilial, idUser);
     }
    
  public List<FilialModel> FiliaisCadastradas(String filtroFilial, String filtroPerfil){
        return FilialDAO.FiliaisCadastradas(filtroFilial, filtroPerfil);
    }
  
  public  FilialModel FilialPropriedades(FilialModel filial){
      FilialDAO.consultarFilial(filial);
      return filial;
  }
}
