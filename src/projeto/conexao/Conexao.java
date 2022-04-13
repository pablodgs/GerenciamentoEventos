/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pablo
 */
public class Conexao {

    //objeto estático para guardar uma instância de minha conexão
    public static Conexao conexao = null;

    //método estático para criar uma instância do objeto
    //MinhaConexao
    public static Conexao getInstance() {
        try {
            //verifica se ja existe uma conexão. Isso é feito verificando
            //se há algum objeto atribuido à conexao ou se a conexao sql
            //atribuída à ele está fechada.
            if (conexao == null || conexao.sqlConnection.isClosed()) {
                conexao = new Conexao(); //cria uma nova conexão caso não
                //exista uma.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexao;
    }

    //cria um objeto Connection chamado sqlConnection
    public Connection sqlConnection;

    //construtor para inicializar a conexão
    public Conexao() {
        try {
            //cria uma nova instancia utilizando o driver que foi adicionado
            //à biblioteca atraves do arquivo .jar
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //define a string de conexão com o banco de dados MySQL.
            //Lembrando que meuUsuario e minhaSenha devem ser substituídos
            //pelo usuário e senha utilizados para conectar com o banco de dados.
            String textoConexao = "jdbc:mysql://root@localhost:3306//venda?user=root&password=1212";

            //adquire a conexão
            sqlConnection = DriverManager.getConnection(textoConexao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
