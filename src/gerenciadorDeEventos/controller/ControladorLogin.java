/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.controller;

import gerenciadorDeEventos.dal.UsuarioDAO;
import gerenciadorDeEventos.model.Usuario;
import gerenciadorDeEvetnos.segurança.Autenticacao;
import gerenciadorDeEvetnos.segurança.LoginSession;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class ControladorLogin {
    public Usuario logar(String email, String senha, String tipo){
        Autenticacao autenticacao = new Autenticacao();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        if(tipo.compareTo("Usuário") == 0){
            Usuario usuario = autenticacao.loginUsuario(email, senha);
            if(usuario != null){ 
                LoginSession.cpf = usuario.getCpf();
                LoginSession.nome = usuario.getNome();
                LoginSession.estalogado = true;
                return usuario;
            }else{
                return null;
            }
        }
        return null;
    }
}
