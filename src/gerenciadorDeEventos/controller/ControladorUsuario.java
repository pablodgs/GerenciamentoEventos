/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.controller;

import java.util.List;
import gerenciadorDeEventos.model.Usuario;
import gerenciadorDeEventos.dal.UsuarioDAO;


/**
 *
 * @author lucas
 */
public class ControladorUsuario {
 
    @SuppressWarnings("empty-statement")
    public int CadastrarUsuario(String nomeUsuario, String endereco, String cpf, String senha, String email, String sexo){
        Usuario usuario = new Usuario();
        usuario.setNome(nomeUsuario);
        usuario.setEndereco(endereco);
        usuario.setCpf(cpf);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        if(sexo == "Masculino"){
            usuario.setSexo(0);
        }else{
            usuario.setSexo(1);
        }
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.BuscarTodos();
        
        for(Usuario usuario2: usuarios){
            if(usuario2.getCpf().compareTo(usuario.getCpf()) == 0){
                return 0;
            }
        }
        
        usuarioDAO.cadastrar(usuario);;
        return 1;
    }
    
}
