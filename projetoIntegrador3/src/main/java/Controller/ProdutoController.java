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

    public List<ProdutoModel> ProdutosCadastrados(String filtroFilial, String filtroPerfil) {
        return ProdutoDAO.produtosCadastrados(filtroFilial, filtroPerfil);
    }

    public boolean delete(ProdutoModel produto) {
        return ProdutoDAO.excluirProduto(produto);
    }
}
