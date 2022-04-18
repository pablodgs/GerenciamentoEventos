package gerenciadorDeEventos.model;

import gerenciadorDeEventos.controller.UsuarioController;
import gerenciadorDeEventos.dal.ModuloConexao;
import gerenciadorDeEventos.dal.UsuarioDAO;
import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import gerenciadorDeEventos.view.TelaManutencaoUsuario;

public class GerenciadorDeEventos {
    public static Connection conexao = null;
    public static UsuarioDAO usuarioDAO = null;
    public static UsuarioController usuarioController = new UsuarioController();

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
