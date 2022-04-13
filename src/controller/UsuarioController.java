/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static model.GerenciadorDeEventos.usuarioDAO;
import model.Usuario;
import java.sql.ResultSet;

/**
 *
 * @author pablo
 */
public class UsuarioController {
    public boolean updateUsuario(String nome, String cpf, String sexo, String endereco, String email, String senha){
//        System.out.println(nome);
//        System.out.println(cpf);
//        System.out.println(sexo);
//        System.out.println(endereco);
//        System.out.println(email);
//        System.out.println(senha);
        Usuario usuario = new Usuario(nome, cpf, sexo, endereco, email, senha);
        int rs;
        rs = usuarioDAO.updateUsuario(usuario);
        if(rs != 0){
            // chamada de função da TelaManutencaoUsuario
            System.out.println("Usuario ATUALIZADO!");
            return true;
        } else {
            // chamada de função da TelaManutencaoUsuario
            System.out.println("Usuario NAO ATUALIZADO!");
            return false;
        }
    }
    
    public boolean deleteUsuario(String cpf){
//        System.out.println(nome);
//        System.out.println(cpf);
//        System.out.println(sexo);
//        System.out.println(endereco);
//        System.out.println(email);
//        System.out.println(senha);
        Usuario usuario = new Usuario(cpf);
        boolean deleted;
        deleted = usuarioDAO.deleteUsuario(usuario);
        if(deleted){
            // chamada de função da TelaManutencaoUsuario
            System.out.println("Usuario DELETADO!");
            return true;
        } else {
            // chamada de função da TelaManutencaoUsuario
            System.out.println("Usuario NAO DELETADO!");
            return false;
        }
    }
}
