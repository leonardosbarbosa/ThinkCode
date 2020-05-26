/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import com.thinkcode.DAO.ItensVendaDAO;
import com.thinkcode.models.ItensVenda;

/**
 *
 * @author AlexSandey
 */
public class ItensVendaController {
    public boolean save(ItensVenda itens){
        return ItensVendaDAO.cadastrarProduto(itens);
    }
}
