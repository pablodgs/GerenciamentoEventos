package gerenciadorDeEventos.controller;

import static gerenciadorDeEventos.model.GerenciadorDeEventos.usuarioDAO;
import gerenciadorDeEventos.model.Usuario;
import java.util.List;

public class UsuarioController {
    public void updateUsuario(String nome, int cpf, int sexo, String endereco, String email, String senha) {
//        System.out.println(nome);
//        System.out.println(cpf);
//        System.out.println(sexo);
//        System.out.println(endereco);
//        System.out.println(email);
//        System.out.println(senha);
        Usuario usuario = new Usuario(nome, cpf, sexo, endereco, email, senha);
        int rs = usuarioDAO.updateUsuario(usuario);
        if (rs != 0) { 
            // chamada de função da tela
            System.out.println("Usuario ATUALIZADO!");
            System.out.println(rs);
        }
    }

    @SuppressWarnings("empty-statement")
    public int CadastrarUsuario(String nomeUsuario, String endereco, int cpf, String senha, String email, String sexo){
        Usuario usuario = new Usuario(nomeUsuario, cpf, endereco, email, senha);
        if(sexo == "Masculino"){
            usuario.setSexo(0);
        }else{
            usuario.setSexo(1);
        }
        
        int rs = usuarioDAO.updateUsuario(usuario);
        if (rs != 0) { 
            // chamada de função da tela
            System.out.println("Usuario ATUALIZADO!");
            System.out.println(rs);
        }
        
        List<Usuario> usuarios = usuarioDAO.buscarTodos();
        
        for(Usuario usuario2: usuarios){
            if(usuario2.getCpf() == (usuario.getCpf())){
                return 0;
            }
        }
        
        usuarioDAO.createUsuario(usuario);
        return 1;
    }
}
