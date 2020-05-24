/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.thinkcode.DAO.ProdutoDAO;
import com.thinkcode.models.ProdutoModel;
import java.util.List;

/**
 *
 * @author gusta
 */
public class ProdutoController {

    public boolean save(ProdutoModel produto) {
        return ProdutoDAO.cadastrarProduto(produto);
    }

    public boolean update(ProdutoModel produto) {
        return ProdutoDAO.atualizarProduto(produto);
    }

    public ProdutoModel produtoPropriedades(ProdutoModel produto) {
       return ProdutoDAO.consultarProduto(produto);
    }

    public List<ProdutoModel> ProdutosCadastrados(String filtroFilial, String filtroTipo, String filtroNome) {
        return ProdutoDAO.produtosCadastrados(filtroFilial, filtroTipo, filtroNome);
    }

    public boolean delete(int idProduto, int idUserExclusao) {
        return ProdutoDAO.excluirProduto(idProduto, idUserExclusao);
    }
}
