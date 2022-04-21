/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.controller;

import gerenciadorDeEventos.dal.CriadorDAO;
import gerenciadorDeEventos.model.Criador;

/**
 *
 * @author lucas
 */
public class CriadorController {
    public int CadastrarCriador(String nomeCriador, String endereco, String cpf, String senha, String email, String sexo, String telefone){
        Criador criador = new Criador();
        criador.setNome(nomeCriador);
        criador.setEndereco(endereco);
        criador.setCpf(cpf);
        criador.setSenha(senha);
        criador.setEmail(email);
        criador.setSexo(sexo);
        CriadorDAO criadorDAO = new CriadorDAO();
        Criador criadorResult = criadorDAO.readCriador(cpf);
        
        if(criadorResult == null){
            criadorDAO.cadastrar(criador);
            return 1;
        }
        return 0;
    }
    
}
