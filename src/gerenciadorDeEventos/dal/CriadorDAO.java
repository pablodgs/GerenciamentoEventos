/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.dal;

import gerenciadorDeEventos.model.Criador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class CriadorDAO {
        private Criador pegaDados(ResultSet rs) throws SQLException{
        if(rs != null && rs.next()){
            String nome = rs.getString("nome");
            String senha = rs.getString("senha");
            String cpf = rs.getString("cpf");
            String endereco = rs.getString("endereco");
            String email = rs.getString("email");
            String sexo = rs.getString("sexo");
            String telefone = rs.getString("telefone");
            
            Criador criador = new Criador(nome, cpf, sexo, endereco, email, senha, telefone);
            return criador;
        }
        return null;
    }
        
    public Criador readCriador(String cpf){
        ModuloConexao conec = new ModuloConexao();
        String sql = "select * from criador where cpf = '" + cpf + "';";
        ResultSet rs = null;
        try {
            Connection dao = conec.getInstance().sqlConnection;
            Statement stmt = dao.createStatement();
            rs = stmt.executeQuery(sql);
            Criador criador = pegaDados(rs);
            dao.close();
            return criador;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void cadastrar(Criador criador){
        ModuloConexao conec = new ModuloConexao();
        Connection dao = conec.getInstance().sqlConnection;
        String query = "INSERT INTO criador(nome, senha, cpf, endereco, email, sexo, telefone) values ('" + criador.getNome() + "', '" + criador.getSenha() + "', '" + criador.getCpf() + "', '" + criador.getEndereco() + "', '" + criador.getEmail() + "', '" + criador.getSexo() + "', '" + criador.getTelefone() +"');";
        try{
            Statement stmt = dao.createStatement();
            stmt.executeUpdate(query);
            dao.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void atualizar(Criador criador){
        ModuloConexao conec = new ModuloConexao();
        Connection dao = conec.getInstance().sqlConnection;
        String query = "UPDATE criador set nome = '" + criador.getNome() + "', senha = '" + criador.getSenha() + "', endereco = '" + criador.getEndereco() + "', email = '" + criador.getEmail() + "', sexo = '" + criador.getSexo() + "', telefone = '" + criador.getTelefone() + "' where cpf = '" + criador.getCpf() + "';";
        try{
            Statement stmt = dao.createStatement();
            stmt.executeUpdate(query);
            dao.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Criador pegarLogado(String email, String senha){
        String sql = "select * from criador where email = '" + email + "' and senha = '" + senha + "';";
        ResultSet rs = null;
        ModuloConexao conec = new ModuloConexao();
        try{
            Connection dao = conec.getInstance().sqlConnection;
            Statement stmt = dao.createStatement();
            rs = stmt.executeQuery(sql);
            Criador resultado = pegaDados(rs);
            if(resultado != null){
                return resultado;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
        
    
}
