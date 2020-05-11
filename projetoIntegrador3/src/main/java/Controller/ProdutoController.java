/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.thinkcode.DAO.ProdutoDAO;
import com.thinkcode.models.ProdutoModel;

/**
 *
 * @author gusta
 */
public class ProdutoController {
     public boolean Save(ProdutoModel produto) {
        return ProdutoDAO.cadastrarProduto(produto);
    }
}
