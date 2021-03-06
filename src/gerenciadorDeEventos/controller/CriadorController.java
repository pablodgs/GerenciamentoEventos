/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.controller;

import gerenciadorDeEventos.dal.CriadorDAO;
import gerenciadorDeEventos.model.Criador;
import gerenciadorDeEventos.model.Evento;
import gerenciadorDeEventos.segurança.LoginSession;
import java.util.Date;

/**
 *
 * @author lucas
 */
public class CriadorController {
    
    public int cadastrarCriador(String nomeCriador, String endereco, String cpf, String senha, String email, String sexo, String telefone){
        Criador criador = new Criador(nomeCriador, cpf, sexo, endereco, email, senha, telefone);
        CriadorDAO criadorDAO = new CriadorDAO();
        Criador criadorResult = criadorDAO.readCriador(cpf);
        Criador criadorResult2 = criadorDAO.readCriadorEmail(email);
        
        if(criadorResult == null && criadorResult2 == null){
            criadorDAO.cadastrar(criador);
            return 1;
        }
        return 0;
    }
    
    public boolean atualizarCriador(String nome, String endereco, String senha, String email, String sexo, String telefone){
        Criador criador = new Criador(nome, LoginSession.cpf, sexo, endereco, email, senha, telefone);
        
        CriadorDAO criadorDAO = new CriadorDAO();
        boolean update = criadorDAO.atualizar(criador);
        if(update){
            return true;
        }
        return false;

    }
    
    public void deletarCriador(){
        CriadorDAO criadorDAO = new CriadorDAO();
        criadorDAO.deletar(LoginSession.cpf);
    }
    

}
