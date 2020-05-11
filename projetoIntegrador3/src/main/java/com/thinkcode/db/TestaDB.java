/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkcode.db;

import com.thinkcode.DAO.ProdutoDAO;
import com.thinkcode.models.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo Silva
 */
public class TestaDB {

//Classse temporária para fins de teste 
    public static void main(String[] args) {
        Connection con;
        ProdutoModel produto = new ProdutoModel(1, 1, "Caminhão", "Banco", 500, "Banco para o caminhão do gutão", 200.99);
  //      ProdutoDAO.cadastrarProduto(produto);
        ProdutoDAO.consultarProdutoNome("roda");

        // Chamar Procedure
//        CallableStatement cStmt = con.prepareCall("{call demoSp(?, ?)}");
//            cStmt.setString(1, "Teste");
//            cStmt.setString(2, "Teste2");
        
    }
}
