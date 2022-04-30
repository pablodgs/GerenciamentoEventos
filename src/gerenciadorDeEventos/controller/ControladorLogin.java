/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.controller;

import gerenciadorDeEventos.model.Criador;
import gerenciadorDeEventos.model.Palestrante;
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
                LoginSession.sexo = usuario.getSexo();
                LoginSession.endereco = usuario.getEndereco();
                LoginSession.email = usuario.getEmail();
                LoginSession.senha = usuario.getSenha();
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
                LoginSession.sexo = criador.getSexo();
                LoginSession.endereco = criador.getEndereco();
                LoginSession.email = criador.getEmail();
                LoginSession.senha = criador.getSenha();
                LoginSession.telefone = criador.getTelefone();
                LoginSession.dadosPagamento = criador.getDadosPagamento();
                LoginSession.estalogado = true;
                return 2;
            }else{
                return 0;
            }
        }else if(tipo.compareTo("Palestrante") == 0){
            Palestrante palestrante = autenticacao.loginPalestrante(email,senha);
            if(palestrante != null){
                LoginSession.cpf = palestrante.getCpf();
                LoginSession.nome = palestrante.getNome();
                LoginSession.sexo = palestrante.getSexo();
                LoginSession.endereco = palestrante.getEndereco();
                LoginSession.email = palestrante.getEmail();
                LoginSession.senha = palestrante.getSenha();
                LoginSession.telefone = palestrante.getTelefone();
                LoginSession.formacao = palestrante.getFormacao();
                LoginSession.experiencias = palestrante.getExperiencias();
                LoginSession.estalogado = true;
                return 3;
            }else{
                return 0;
            }
        }
        return 0;
    }
}
