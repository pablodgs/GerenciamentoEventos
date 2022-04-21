/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.segurança;

import gerenciadorDeEventos.dal.UsuarioDAO;
import gerenciadorDeEventos.model.Usuario;

/**
 *
 * @author lucas
 */
public class Autenticacao {
    UsuarioDAO usuarioDao = new UsuarioDAO();

    public Usuario loginUsuario(String email, String senha){
        Usuario usuario = usuarioDao.pegarLogado(email, senha);
        if(usuario != null){
            return usuario;
        }
        return null;
    }
}
