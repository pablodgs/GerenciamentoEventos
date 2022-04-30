/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.dal;

import gerenciadorDeEventos.model.Inscricao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class InscricaoDAO {
    
    private Inscricao pegaDados(ResultSet rs) throws SQLException{
        UsuarioDAO usuarioDao = new UsuarioDAO();
        EventoDAO eventoDao = new EventoDAO();
        if(rs != null && rs.next()){
            int id = rs.getInt("id");
            
            Inscricao inscricao = new Inscricao(id);

            return inscricao;
        }
        return null;
    }
    public Inscricao readInscricao(String cpf, String nome){
        EventoDAO eventoDao = new EventoDAO();
        int id = eventoDao.pegarId(nome);
        ModuloConexao conec = new ModuloConexao();
        String sql = "select * from inscricao where idEvento = " + id + " and cpfUsuario = '" + cpf  + "';";
        ResultSet rs = null;
        try {
            Connection dao = conec.getInstance().sqlConnection;
            Statement stmt = dao.createStatement();
            rs = stmt.executeQuery(sql);
            Inscricao inscricao = pegaDados(rs);
            dao.close();
            return inscricao;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean inscrever(String cpf, String nome){
        EventoDAO eventoDao = new EventoDAO();
        int id = eventoDao.pegarId(nome);
        ModuloConexao conec = new ModuloConexao();
        Connection dao = conec.getInstance().sqlConnection;
        String sql = "INSERT INTO INSCRICAO(idEvento, cpfUsuario) values (" + id + ",'" + cpf + "');";
        try{
            Statement stmt = dao.createStatement();
            stmt.executeUpdate(sql);
            dao.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
