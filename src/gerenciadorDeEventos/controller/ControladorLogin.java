/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.controller;

import gerenciadorDeEventos.model.Usuario;
import gerenciadorDeEventos.segurança.Autenticacao;
import gerenciadorDeEventos.segurança.LoginSession;

/**
 *
 * @author lucas
 */
public class ControladorLogin {
    public Usuario logar(String email, String senha, String tipo){
        Autenticacao autenticacao = new Autenticacao();
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
