/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.controller;

import java.util.List;
import gerenciadorDeEventos.model.Usuario;
import gerenciadorDeEventos.dal.UsuarioDAO;


/**
 *
 * @author lucas
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

    @SuppressWarnings("empty-statement")
    public int CadastrarUsuario(String nomeUsuario, String endereco, String cpf, String senha, String email, String sexo){
        Usuario usuario = new Usuario();
        usuario.setNome(nomeUsuario);
        usuario.setEndereco(endereco);
        usuario.setCpf(cpf);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        if(sexo == "Masculino"){
            usuario.setSexo(0);
        }else{
            usuario.setSexo(1);
        }
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.BuscarTodos();
        
        for(Usuario usuario2: usuarios){
            if(usuario2.getCpf().compareTo(usuario.getCpf()) == 0){
                return 0;
            }
        }
        
        usuarioDAO.cadastrar(usuario);;
        return 1;
    }
}
