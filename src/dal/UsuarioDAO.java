/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.GerenciadorDeEventos.conexao;
import model.Usuario;

/**
 *
 * @author pablo
 */
public class UsuarioDAO {
    public void createUsuario(Usuario usuario){
        String query = "INSERT INTO cliente (nome, cpf) VALUES ('" + usuario.getNome() + "', '" + usuario.getCpf() + "')";
        try{
            Statement stmt = conexao.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet readUsuario(){
        String query = "";
        try {
            Statement stmt = conexao.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int updateUsuario(Usuario usuario){
        String query = "UPDATE usuario SET "
                + "nome='" + usuario.getNome() + "', "
                + "sexo='" + usuario.getSexo() + "', "
                + "endereco='" + usuario.getEndereco() + "', "
                + "email='" + usuario.getEmail() + "', "
                + "senha='" + usuario.getSenha() + "' "
                + "WHERE cpf='" + usuario.getCpf() + "'";
//        System.out.println(query);
        try{
            Statement stmt = conexao.createStatement();
            return stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public boolean deleteUsuario(Usuario usuario){
        String query = "DELETE FROM usuario WHERE cpf='" + usuario.getCpf() + "'";
        try {
            Statement stmt = conexao.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
