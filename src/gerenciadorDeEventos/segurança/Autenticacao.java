/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.segurança;

import gerenciadorDeEventos.dal.CriadorDAO;
import gerenciadorDeEventos.dal.PalestranteDAO;
import gerenciadorDeEventos.dal.UsuarioDAO;
import gerenciadorDeEventos.model.Criador;
import gerenciadorDeEventos.model.Palestrante;
import gerenciadorDeEventos.model.Usuario;

/**
 *
 * @author lucas
 */
public class Autenticacao {
    UsuarioDAO usuarioDao = new UsuarioDAO();
    CriadorDAO criadorDao = new CriadorDAO();
    PalestranteDAO palestranteDao = new PalestranteDAO();

    public Usuario loginUsuario(String email, String senha){
        Usuario usuario = usuarioDao.pegarLogado(email, senha);
        if(usuario != null){
            return usuario;
        }
        return null;
    }
    
    public Criador loginCriador(String email, String senha){
        Criador criador = criadorDao.pegarLogado(email, senha);
        if(criador != null){
            return criador;
        }
        return null;
    }
    
    public Palestrante loginPalestrante(String email, String senha){
        Palestrante palestrante = palestranteDao.pegarLogado(email, senha);
        if(palestrante != null){
            return palestrante;
        }
        return null;
    }
}
