/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Statement;
import java.sql.ResultSet;
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

    public ResultSet updateUsuario(Usuario usuario){
        String query = "UPDATE usuario SET nome='" + usuario.getNome() + "', sexo='" + usuario.getSexo() + "', endereco='" + usuario.getEndereco() + "', email='" + usuario.getEmail() + "', senha='" + usuario.getSenha() + "' WHERE cpf='" + usuario.getCpf() + "'";
        try{
            Statement stmt = conexao.createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery(query);
            return rs;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
