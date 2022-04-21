/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.controller;

import java.util.List;
import gerenciadorDeEventos.model.Usuario;
import gerenciadorDeEventos.dal.UsuarioDAO;
import static gerenciadorDeEventos.model.gerenciadorDeEventos.usuarioDAO;


/**
 *
 * @author lucas
 */
public class UsuarioController {
 
    @SuppressWarnings("empty-statement")
    public int CadastrarUsuario(String nomeUsuario, String endereco, String cpf, String senha, String email, String sexo){
        Usuario usuario = new Usuario();
        usuario.setNome(nomeUsuario);
        usuario.setEndereco(endereco);
        usuario.setCpf(cpf);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        usuario.setSexo(sexo);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioResult = usuarioDAO.readUsuario(cpf);

        
        if(usuarioResult == null){
            usuarioDAO.cadastrar(usuario);
            return 1;
        }
        return 0;
    }
    
}
