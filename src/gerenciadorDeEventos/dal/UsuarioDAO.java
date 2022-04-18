package gerenciadorDeEventos.dal;

import gerenciadorDeEventos.model.Criador;
import java.sql.Statement;
import java.sql.ResultSet;
import static gerenciadorDeEventos.model.GerenciadorDeEventos.conexao;
import gerenciadorDeEventos.model.Palestrante;
import gerenciadorDeEventos.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void createUsuario(Usuario usuario) {
        String query = "INSERT INTO cliente (nome, cpf) VALUES ('" + usuario.getNome() + "', '" + usuario.getCpf() + "')";
        try {
            Statement stmt = conexao.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int updateUsuario(Usuario usuario) {
        String query = "UPDATE usuario SET nome='" + usuario.getNome() + "', sexo='" + usuario.getSexo() + "', endereco='" + usuario.getEndereco() + "', email='" + usuario.getEmail() + "', senha='" + usuario.getSenha() + "' WHERE cpf='" + usuario.getCpf() + "'";
//        System.out.println(query);
        try {
            Statement stmt = conexao.createStatement();
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Usuario> buscarTodos() {
        String query = "SELECT * FROM usuario";
        List<Usuario> data = new ArrayList<Usuario>();
//        System.out.println(query);
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String nome = rs.getString("nome");
                int cpf = rs.getInt("cpf");
                int sexo = rs.getInt("sexo");
                String endereco = rs.getString("endereco");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                // FIX ME 
                int palestrante = rs.getInt("palestrante");
                int criador = rs.getInt("criador");
                data.add(new Usuario(nome, cpf, sexo, endereco, email, senha));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
