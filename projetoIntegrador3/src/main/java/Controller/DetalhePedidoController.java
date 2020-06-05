/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.thinkcode.DAO.DetalhePedidoDAO;
import com.thinkcode.models.DetalhePedidoModel;
import java.util.List;

public class DetalhePedidoController {
        public boolean save(DetalhePedidoModel detalhe) {
        return DetalhePedidoDAO.cadastrarDetalhePedido(detalhe);
    }

     public List<DetalhePedidoModel> todosDetalhe(int idpedido) {
        return DetalhePedidoDAO.consultarTodosDetalhePedido(idpedido);
     }

    public boolean excluir(int id_detalhe, int userExclusao) {
       return DetalhePedidoDAO.excluirDetalhePedido(id_detalhe, userExclusao);
    }

    public boolean delete(int id_detalhe) {
        return DetalhePedidoDAO.DeleteDetalhePedido(id_detalhe);
    }
}
