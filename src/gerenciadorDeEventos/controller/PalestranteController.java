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

/**
 *
 * @author lucas
 */
public class PalestranteController {
    public int CadastrarPalestrante(String nome, String endereco, String cpf, String senha, String email, String sexo, String experiencia, String formacao, String telefone){
    Palestrante palestrante = new Palestrante();
    palestrante.setNome(nome);
    palestrante.setEndereco(endereco); 
    palestrante.setCpf(cpf);
    palestrante.setSenha(senha);
    palestrante.setEmail(email);
    palestrante.setSexo(sexo); 
    palestrante.setExperiencias(experiencia);
    palestrante.setFormacao(formacao);
    palestrante.setTelefone(telefone);
    PalestranteDAO palestranteDAO = new PalestranteDAO();
    Palestrante palestranteResult = palestranteDAO.readPalestrante(cpf);
    
    if(palestranteResult == null){
            palestranteDAO.cadastrar(palestrante);
            return 1;
        }
        return 0;
    }
}
