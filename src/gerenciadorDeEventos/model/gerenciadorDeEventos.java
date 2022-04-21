/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.model;

import gerenciadorDeEventos.controller.PalestranteController;
import java.sql.Connection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import gerenciadorDeEventos.controller.UsuarioController;
import gerenciadorDeEventos.dal.ModuloConexao;
import gerenciadorDeEventos.dal.UsuarioDAO;
import gerenciadorDeEventos.view.TelaPrincipal;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;


/**
 *
 * @author lucas
 */
public class gerenciadorDeEventos {
    public static Connection conexao = ModuloConexao.getInstance().sqlConnection;
    public static UsuarioDAO usuarioDAO = new UsuarioDAO();
    public static UsuarioController usuarioController = new UsuarioController();
    public static PalestranteController palestranteController = new PalestranteController();

    public static void main(String[] args){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("GerenciadorDeEventosDb");
        EntityManager gerente = fabrica.createEntityManager();
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
//        try {
//            conexao.close();
//            System.out.println("Conexao com BD FECHADA!");
//        } catch (SQLException ex) {
//            Logger.getLogger(GerenciadorDeEventos.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
