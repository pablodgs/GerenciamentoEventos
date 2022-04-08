/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pablo
 */
public class ModuloConexao {
    //objeto estático para guardar uma instância de módulo conexão
    public static ModuloConexao conexao = null;

    //método estático para criar uma instância do objeto
    //ModuloConexao
    public static ModuloConexao getInstance(){
        try{
            //verifica se ja existe uma conexão. Isso é feito verificando
            //se há algum objeto atribuido à conexao ou se a conexao sql
            //atribuída à ele está fechada.
            if(conexao==null || conexao.sqlConnection.isClosed()){
               conexao = new ModuloConexao(); //cria uma nova conexão caso não
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
    private ModuloConexao()
    {
        try{
            //cria uma nova instancia utilizando o driver que foi adicionado
            //à biblioteca atraves do arquivo .jar
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            //define a string de conexão com o banco de dados MySQL.
            String textoConexao = "jdbc:mysql://localhost/evento?user=admin&password=admin";

            //adquire a conexão
            sqlConnection = DriverManager.getConnection(textoConexao);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
