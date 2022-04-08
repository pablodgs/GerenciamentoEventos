/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static model.GerenciadorDeEventos.usuarioDAO;
import model.Usuario;

/**
 *
 * @author pablo
 */
public class UsuarioController {
    public void updateUsuario(String nome, String cpf, String sexo, String endereco, String email, String senha){
        Usuario usuario = new Usuario(nome, cpf, sexo, endereco, email, senha);
        ReturnSet rs = null;
        rs = usuarioDAO.updateUsuario(usuario);
    }
}
