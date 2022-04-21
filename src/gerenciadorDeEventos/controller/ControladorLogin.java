/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.controller;

import gerenciadorDeEventos.model.Criador;
import gerenciadorDeEventos.model.Usuario;
import gerenciadorDeEventos.segurança.Autenticacao;
import gerenciadorDeEventos.segurança.LoginSession;

/**
 *
 * @author lucas
 */
public class ControladorLogin {
    public int logar(String email, String senha, String tipo){
        Autenticacao autenticacao = new Autenticacao();
        if(tipo.compareTo("Usuário") == 0){
            Usuario usuario = autenticacao.loginUsuario(email, senha);
            if(usuario != null){ 
                LoginSession.cpf = usuario.getCpf();
                LoginSession.nome = usuario.getNome();
                LoginSession.estalogado = true;
                return 1;
            }else{
                return 0;
            }
        }else if(tipo.compareTo("Criador") == 0){
            Criador criador = autenticacao.loginCriador(email, senha);
            if(criador != null){
                LoginSession.cpf = criador.getCpf();
                LoginSession.nome = criador.getNome();
                LoginSession.estalogado = true;
                return 2;
            }else{
                return 0;
            }
        }
        return 0;
    }
}
