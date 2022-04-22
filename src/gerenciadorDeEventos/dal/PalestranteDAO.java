/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.dal;

import gerenciadorDeEventos.model.Palestrante;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class PalestranteDAO {
    private Palestrante pegaDados(ResultSet rs) throws SQLException{
        if(rs != null && rs.next()){
            String nome = rs.getString("nome");
            String senha = rs.getString("senha");
            String cpf = rs.getString("cpf");
            String endereco = rs.getString("endereco");
            String email = rs.getString("email");
            String sexo = rs.getString("sexo");
            String experiencia = rs.getString("experiencias");
            String formacao = rs.getString("formacao");
            String telefone = rs.getString("telefone");
            
            Palestrante palestrante = new Palestrante(nome, cpf, sexo, endereco, email, senha, experiencia, formacao, telefone);
            return palestrante;
        }
        return null;
    }

    public Palestrante readPalestrante(String cpf){
        ModuloConexao conec = new ModuloConexao();
        String sql = "select * from palestrante where cpf = '" + cpf + "';";
        ResultSet rs = null;
        try {
            Connection dao = conec.getInstance().sqlConnection;
            Statement stmt = dao.createStatement();
            rs = stmt.executeQuery(sql);
            Palestrante palestrante = pegaDados(rs);
            dao.close();
            return palestrante;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void cadastrar(Palestrante palestrante){
        ModuloConexao conec = new ModuloConexao();
        Connection dao = conec.getInstance().sqlConnection;
        String query = "INSERT INTO palestrante(nome, senha, cpf, endereco, email, sexo, experiencias, formacao, telefone) values ('" + palestrante.getNome() + "', '" + palestrante.getSenha() + "', '" + palestrante.getCpf() + "', '" + palestrante.getEndereco() + "', '" + palestrante.getEmail() + "', '" + palestrante.getSexo() + "', '" + palestrante.getExperiencias() + "', '" + palestrante.getFormacao() + "', '" + palestrante.getTelefone() +"');";
        try{
            Statement stmt = dao.createStatement();
            stmt.executeUpdate(query);
            dao.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Palestrante pegarLogado(String email, String senha){
        String sql = "select * from palestrante where email = '" + email + "' and senha = '" + senha + "';";
        ResultSet rs = null;
        ModuloConexao conec = new ModuloConexao();
        try{
            Connection dao = conec.getInstance().sqlConnection;
            Statement stmt = dao.createStatement();
            rs = stmt.executeQuery(sql);
            Palestrante resultado = pegaDados(rs);
            if(resultado != null){
                return resultado;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void deletar(String cpf){
        ModuloConexao conec = new ModuloConexao();
        Connection dao = conec.getInstance().sqlConnection;
        String sql = "Delete from palestrante where cpf = '" + cpf + "';";
        try{
            Statement stmt = dao.createStatement();
            stmt.execute(sql);
            dao.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void atualizar(Palestrante palestrante){
        ModuloConexao conec = new ModuloConexao();
        Connection dao = conec.getInstance().sqlConnection;
        String query = "UPDATE palestrante set nome = '" + palestrante.getNome() + 
                       "', senha = '" + palestrante.getSenha() + 
                       "', endereco = '" + palestrante.getEndereco() + 
                       "', email = '" + palestrante.getEmail() + 
                       "', sexo = '" + palestrante.getSexo() + 
                       "', telefone = '" + palestrante.getTelefone() + 
                       "', formacao = '" + palestrante.getFormacao() +
                       "', experiencias = '" + palestrante.getExperiencias() +
                       "' where cpf = '" + palestrante.getCpf() +  "';";
        try{
            Statement stmt = dao.createStatement();
            stmt.executeUpdate(query);
            dao.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
