/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadorDeEventos.dal;


import java.sql.Connection;
import gerenciadorDeEventos.model.Usuario;
import static gerenciadorDeEventos.model.gerenciadorDeEventos.conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author pablo
 */
public class UsuarioDAO {
    private Usuario pegaDados(ResultSet rs) throws SQLException{
        if(rs != null && rs.next()){
            String nome = rs.getString("nome");
            String senha = rs.getString("senha");
            String cpf = rs.getString("cpf");
            String endereco = rs.getString("endereco");
            String email = rs.getString("email");
            String sexo = rs.getString("sexo");
            
            Usuario usuario = new Usuario(nome, cpf, sexo, endereco, email, senha);
            return usuario;
        }
        return null;
    }

    public Usuario readUsuario(String cpf){
        ModuloConexao conec = new ModuloConexao();
        String sql = "select * from usuario where cpf = '" + cpf + "';";
        ResultSet rs = null;
        try {
            Connection dao = conec.getInstance().sqlConnection;
            Statement stmt = dao.createStatement();
            rs = stmt.executeQuery(sql);
            Usuario usuario = pegaDados(rs);
            return usuario;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public Usuario readUsuarioEmail(String email){
        ModuloConexao conec = new ModuloConexao();
        String sql = "select * from usuario where email = '" + email + "';";
        ResultSet rs = null;
        try {
            Connection dao = conec.getInstance().sqlConnection;
            Statement stmt = dao.createStatement();
            rs = stmt.executeQuery(sql);
            Usuario usuario = pegaDados(rs);
            return usuario;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateUsuario(Usuario usuario){
        ModuloConexao conec = new ModuloConexao();
        String query = "UPDATE usuario SET "
                + "nome='" + usuario.getNome() + "', "
                + "sexo='" + usuario.getSexo() + "', "
                + "endereco='" + usuario.getEndereco() + "', "
                + "email='" + usuario.getEmail() + "', "
                + "senha='" + usuario.getSenha() + "' "
                + "WHERE cpf='" + usuario.getCpf() + "'";
        try{
            Connection dao = conec.getInstance().sqlConnection;
            Statement stmt = dao.createStatement();
            return stmt.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public boolean deleteUsuario(String cpf){
        String query = "DELETE FROM usuario WHERE cpf='" + cpf  + "'";
        ModuloConexao conec = new ModuloConexao();
        try {
            Connection dao = conec.getInstance().sqlConnection;
            Statement stmt = dao.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private List<Usuario> listaUsuario(ResultSet rs){
        List<Usuario> usuarios = new ArrayList<>();
        if(rs == null){
            return usuarios;
        }
        try{
            while(rs.next()){
                Usuario usuario = pegaDados(rs);
                usuarios.add(usuario);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }

    public ResultSet listaPorSql(String sql){
        ModuloConexao conec = new ModuloConexao();
        try{
            Connection dao = conec.getInstance().sqlConnection;
            Statement stmt = dao.createStatement();
            return stmt.executeQuery(sql);
        }catch(SQLException e){
            return null;
        }
    }

    public List<Usuario> BuscarTodos(){
        String sql = "Select * from usuario;";
        ResultSet rs = this.listaPorSql(sql);
        return listaUsuario(rs);
    }

    public void cadastrar(Usuario usuario){
        ModuloConexao conec = new ModuloConexao();
        Connection dao = conec.getInstance().sqlConnection;
        String query = "INSERT INTO usuario(nome, senha, cpf, endereco, email, sexo) values ('" + usuario.getNome() + "', '" + usuario.getSenha() + "', '" + usuario.getCpf() + "', '" + usuario.getEndereco() + "', '" + usuario.getEmail() + "', '" + usuario.getSexo() + "');";
        try{
            Statement stmt = dao.createStatement();
            stmt.executeUpdate(query);
            dao.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Usuario pegarLogado(String email, String senha){
        String sql = "select * from usuario where email = '" + email + "' and senha = '" + senha + "';";
        ResultSet rs = null;
        ModuloConexao conec = new ModuloConexao();
        try{
            Connection dao = conec.getInstance().sqlConnection;
            Statement stmt = dao.createStatement();
            rs = stmt.executeQuery(sql);
            Usuario resultado = pegaDados(rs);
            if(resultado != null){
                return resultado;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
