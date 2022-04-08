/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.ModuloConexao;
import dal.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.TelaManutencaoUsuario;

/**
 *
 * @author pablo
 */
public class GerenciadorDeEventos {
    public static Connection conexao = null;
    public static UsuarioDAO usuarioDAO = null;

    public static void main(String[] args){
        usuarioDAO = new UsuarioDAO();
        conexao = ModuloConexao.getInstance().sqlConnection;
        TelaManutencaoUsuario telaManutencaoUsuario = new TelaManutencaoUsuario();
        telaManutencaoUsuario.setVisible(true);
//        try {
//            conexao.close();
//            System.out.println("Conexao com BD FECHADA!");
//        } catch (SQLException ex) {
//            Logger.getLogger(GerenciadorDeEventos.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
