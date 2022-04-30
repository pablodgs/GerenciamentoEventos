/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.controller;

import gerenciadorDeEventos.dal.InscricaoDAO;
import gerenciadorDeEventos.model.Inscricao;

/**
 *
 * @author lucas
 */
public class InscricaoController {
    public boolean inscrever(String cpf, String nome){
        InscricaoDAO inscricaoDao = new InscricaoDAO();
        boolean inscricao = inscricaoDao.inscrever(cpf, nome);
        return inscricao;
    }
    public Inscricao lerInscricao(String cpf, String nome){
        Inscricao inscricao;
        InscricaoDAO inscricaoDao = new InscricaoDAO();
        inscricao = inscricaoDao.readInscricao(cpf, nome);
        return inscricao;
    }
}
