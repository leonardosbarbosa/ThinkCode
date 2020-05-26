/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.thinkcode.DAO.VendaDAO;
import com.thinkcode.models.VendaModel;
import java.util.List;

/**
 *
 * @author gusta
 */
public class VendaController {

   public boolean save(VendaModel venda) {
        return VendaDAO.cadastraraVenda(venda);
    }
    
    public List<VendaModel> consult(String id_venda) {
        return VendaDAO.consultarVendaCompleta(id_venda);
    }

    public boolean delete(String id_venda) {
        return VendaDAO.Delete(id_venda);
    }
    
   public int consultaUltimoId(){
     return VendaDAO.consultarUltimoIdVenda();
    }
}
