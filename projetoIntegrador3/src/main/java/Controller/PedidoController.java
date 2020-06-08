/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.thinkcode.DAO.PedidoDAO;
import com.thinkcode.models.PedidoModel;
import java.util.List;
public class PedidoController {
      public boolean save(PedidoModel pedido) {
        return PedidoDAO.cadastrarPedido(pedido);
    }
     public List<PedidoModel> todosPedidos() {
        return PedidoDAO.consultarTodosPedido();
     }

    public boolean excluir(int id_pedido, int userExclusao) {
       return PedidoDAO.excluirPedido(id_pedido, userExclusao);
    }

    public boolean delete(int id_pedido) {
        return PedidoDAO.DeletePedido(id_pedido);
    }
    
    public int UltimoPedido(int Id_vendedor){
        return PedidoDAO.consultarUltimoPedido(Id_vendedor);
    }
}