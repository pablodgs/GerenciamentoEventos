/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.controller;

import gerenciadorDeEventos.dal.PalestranteDAO;
import gerenciadorDeEventos.dal.UsuarioDAO;
import gerenciadorDeEventos.model.Palestrante;
import gerenciadorDeEventos.model.Usuario;
import gerenciadorDeEventos.segurança.LoginSession;

/**
 *
 * @author lucas
 */
public class PalestranteController {
    public int CadastrarPalestrante(String nome, String endereco, String cpf, String senha, String email, String sexo, String experiencia, String formacao, String telefone){
    Palestrante palestrante = new Palestrante(nome, cpf, sexo, endereco, email, senha, experiencia, formacao, telefone);
    PalestranteDAO palestranteDAO = new PalestranteDAO();
    Palestrante palestranteResult = palestranteDAO.readPalestrante(cpf);
    
    if(palestranteResult == null){
            palestranteDAO.cadastrar(palestrante);
            return 1;
        }
        return 0;
    }
    
    public void atualizarPalestrante(String nome, String endereco, String senha, String email, String sexo, String telefone, String formacao, String experiencia){
        Palestrante palestrante = new Palestrante(nome, LoginSession.cpf, sexo, endereco, email, senha, experiencia, formacao, telefone);
        
        PalestranteDAO palestranteDAO = new PalestranteDAO();
        palestranteDAO.atualizar(palestrante);
    }
    
    public void deletarPalestrante(){
        PalestranteDAO criadorDAO = new PalestranteDAO();
        criadorDAO.deletar(LoginSession.cpf);
    }
}
