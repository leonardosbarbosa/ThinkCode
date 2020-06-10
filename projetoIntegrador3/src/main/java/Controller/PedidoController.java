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

    public List<PedidoModel> todosPedidos(String _filtroFilial, String _filtroSolicitante, String _filtroStatus) {
        return PedidoDAO.consultarTodosPedido(_filtroFilial, _filtroSolicitante, _filtroStatus);
    }

    public boolean excluir(int id_pedido, int userExclusao) {
        return PedidoDAO.excluirPedido(id_pedido, userExclusao);
    }

    public boolean delete(int id_pedido) {
        return PedidoDAO.DeletePedido(id_pedido);
    }

    public int UltimoPedido(int Id_vendedor) {
        return PedidoDAO.consultarUltimoPedido(Id_vendedor);
    }

    public PedidoModel PropriedadesPedido(int id_pedido) {
        return PedidoDAO.consultaPedido(id_pedido);
    }

    public boolean update(PedidoModel _pedido) {
        return PedidoDAO.AtualizarPedido(_pedido);
    }
}
