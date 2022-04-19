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
    

    //objeto estático para guardar uma instância de minha conexão
    public static UsuarioDAO conexao = null;

    //método estático para criar uma instância do objeto
    //MinhaConexao
    public static UsuarioDAO getInstance(){
        try{
            //verifica se ja existe uma conexão. Isso é feito verificando
            //se há algum objeto atribuido à conexao ou se a conexao sql
            //atribuída à ele está fechada.
            if(conexao==null || conexao.sqlConnection.isClosed()){
               conexao = new UsuarioDAO(); //cria uma nova conexão caso não
                                             //exista uma.
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return conexao;
    }

    //cria um objeto Connection chamado sqlConnection
    public Connection sqlConnection;

    //construtor para inicializar a conexão
    public UsuarioDAO()
    {
        try{
            //cria uma nova instancia utilizando o driver que foi adicionado
            //à biblioteca atraves do arquivo .jar
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            //define a string de conexão com o banco de dados MySQL.
            //Lembrando que meuUsuario e minhaSenha devem ser substituídos
            //pelo usuário e senha utilizados para conectar com o banco de dados.
            String textoConexao = "jdbc:mysql://localhost/GerenciadordeEventosDb?user=root&password=1212";

            //adquire a conexão
            sqlConnection = DriverManager.getConnection(textoConexao);
        }catch(Exception e){
            e.printStackTrace();
        }
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
        try{
            Connection dao = UsuarioDAO.getInstance().sqlConnection;
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
        Connection dao = UsuarioDAO.getInstance().sqlConnection;
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
        try{
            Connection dao = UsuarioDAO.getInstance().sqlConnection;
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