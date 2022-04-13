/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import projeto.modelo.Usuario;
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
public class UsuarioDao {
    

    //objeto estático para guardar uma instância de minha conexão
    public static UsuarioDao conexao = null;

    //método estático para criar uma instância do objeto
    //MinhaConexao
    public static UsuarioDao getInstance(){
        try{
            //verifica se ja existe uma conexão. Isso é feito verificando
            //se há algum objeto atribuido à conexao ou se a conexao sql
            //atribuída à ele está fechada.
            if(conexao==null || conexao.sqlConnection.isClosed()){
               conexao = new UsuarioDao(); //cria uma nova conexão caso não
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
    public UsuarioDao()
    {
        try{
            //cria uma nova instancia utilizando o driver que foi adicionado
            //à biblioteca atraves do arquivo .jar
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //define a string de conexão com o banco de dados MySQL.
            //Lembrando que meuUsuario e minhaSenha devem ser substituídos
            //pelo usuário e senha utilizados para conectar com o banco de dados.
            String textoConexao = "jdbc:mysql://localhost/venda?user=root&password=1212";

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
    
    public ResultSet listaPorSql(){
        try{
            Connection dao = UsuarioDao.getInstance().sqlConnection;
            String sql = "Select * from usuario;";
            Statement stmt = dao.createStatement();
            return stmt.executeQuery(sql);
        }catch(SQLException e){
            return null;
        }
    }
    
    public List<Usuario> BuscarTodos(){
        ResultSet rs = this.listaPorSql();
        return listaUsuario(rs);
    }
    
    public void cadastrar(Usuario usuario){
        Connection dao = UsuarioDao.getInstance().sqlConnection;
        String query = "INSERT INTO usuario(nome, senha, cpf, enderco, email) values ('" + usuario.getNome() + "', '" + usuario.getSenha() + "', '" + usuario.getCpf() + "', '" + usuario.getEndereco() + "', '" + usuario.getEmail() + "');";
        try{
            Statement stmt = dao.createStatement();
            stmt.executeUpdate(query);
            dao.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private Usuario pegaDados(ResultSet rs) throws SQLException{
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        String senha = rs.getString("senha");;
        int cpf = rs.getInt("cpf");;
        String endereco = rs.getString("enderco");;
        String email = rs.getString("email");;
        int sexo = rs.getInt("sexo");;
        
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setCpf(cpf);
        usuario.setEndereco(endereco);
        usuario.setEmail(email);
        usuario.setSexo(sexo);
        return usuario;
    }
}