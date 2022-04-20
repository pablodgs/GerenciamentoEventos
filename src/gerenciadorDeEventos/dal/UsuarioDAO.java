/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadorDeEventos.dal;


import java.sql.Connection;
import java.sql.DriverManager;
import gerenciadorDeEventos.model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author pablo
 */
public class UsuarioDAO {

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
    
    private Usuario pegaDados(ResultSet rs) throws SQLException{
        String nome = rs.getString("nome");
        String senha = rs.getString("senha");
        String cpf = rs.getString("cpf");
        String endereco = rs.getString("endereco");
        String email = rs.getString("email");
        int sexo = rs.getInt("sexo");
       
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setCpf(cpf);
        usuario.setEndereco(endereco);
        usuario.setEmail(email);
        usuario.setSexo(sexo);
        return usuario;
    }
    
    public Usuario pegarLogado(String email, String senha){
        String sql = "select * from usuario where email = '" + email + "' and senha = '" + senha + "';";
        ResultSet rs = null;
        ModuloConexao conec = new ModuloConexao();
        try{
            Connection dao = conec.getInstance().sqlConnection;
            Statement stmt = dao.createStatement();
            rs = stmt.executeQuery(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
        List<Usuario> logado = listaUsuario(rs);
        if(logado.size() > 0){
            return logado.get(0);
        }
        
        return  null;
    }
}