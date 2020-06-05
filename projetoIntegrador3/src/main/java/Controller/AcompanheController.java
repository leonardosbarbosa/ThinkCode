/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.thinkcode.DAO.AcompanheDAO;
import com.thinkcode.models.AcompanheModel;
import java.util.List;

public class AcompanheController {
    
     public boolean save(AcompanheModel acompanhe) {
        return AcompanheDAO.cadastrarAcompanhe(acompanhe);
    }

     public List<AcompanheModel> todosAcompanhes() {
        return AcompanheDAO.consultarTodosAcompanhe();
     }

    public boolean excluir(int id_acompanhe, int userExclusao) {
       return AcompanheDAO.excluirAcompanhe(id_acompanhe, userExclusao);
    }

    public boolean delete(int id_acompanhe) {
        return AcompanheDAO.DeleteAcompanhe(id_acompanhe);
    }
}
