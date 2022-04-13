/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Statement;
import static model.GerenciadorDeEventos.conexao;

/**
 *
 * @author kari
 */
public class Database {
    
    public static void createTables() {
        String query = "CREATE TABLE IF NOT EXISTS usuario ("
                + "id integer not null auto_increment, "
                + "nome varchar(200), "
                + "cpf varchar(12) not null, "
                + "sexo varchar(1) not null, "
                + "endereco varchar(100) not null, "
                + "email varchar(50) not null, "
                + "senha varchar(20) not null,"
                + "constraint id_usuario primary key (id));";
        try {
            Statement stmt = conexao.createStatement();
            stmt.executeUpdate(query);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
