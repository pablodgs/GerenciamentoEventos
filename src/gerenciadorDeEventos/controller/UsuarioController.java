/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.controller;

import gerenciadorDeEventos.model.Usuario;
import gerenciadorDeEventos.dal.UsuarioDAO;
import gerenciadorDeEventos.segurança.LoginSession;


/**
 *
 * @author lucas
 */
public class UsuarioController {
 
    @SuppressWarnings("empty-statement")
    public int CadastrarUsuario(String nomeUsuario, String endereco, String cpf, String senha, String email, String sexo){
        Usuario usuario = new Usuario(nomeUsuario, cpf, sexo, endereco, email, senha);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioResult = usuarioDAO.readUsuario(cpf);
        
        if(usuarioResult == null){
            usuarioDAO.cadastrar(usuario);
            return 1;
        }
        return 0;
    }
    public boolean updateUsuario(String nome, String cpf, String sexo, String endereco, String email, String senha){
        Usuario usuario = new Usuario(nome, cpf, sexo, endereco, email, senha);
        UsuarioDAO usuarioDao = new UsuarioDAO();
        int update = usuarioDao.updateUsuario(usuario);
        if(update == 0){
            return false;
        }
        return true;
    }
    public void deletarUsuario(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.deleteUsuario(LoginSession.cpf);
    }
    
}
