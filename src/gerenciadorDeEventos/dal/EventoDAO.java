/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.dal;

import gerenciadorDeEventos.model.Evento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author lucas
 */
public class EventoDAO {
    public boolean cadastrarEvento(Evento evento){
        ModuloConexao conec = new ModuloConexao();
        Connection dao = conec.getInstance().sqlConnection;
        String sql = "INSERT INTO evento(contato, data, descricao, horario, local, nomeEvento, preco, ingressos) values ('" + evento.getContato() 
                                                                                                                            + "', '" + evento.getData() 
                                                                                                                            + "', '" + evento.getDescricao() 
                                                                                                                            + "', '" + evento.getHorario() 
                                                                                                                            + "', '" + evento.getLocal() 
                                                                                                                            + "', '" + evento.getNomeEvento() 
                                                                                                                            + "', '" + evento.getPreco()
                                                                                                                            + "', '" + evento.getIngressos()
                                                                                                                            +"');";
        try{
            Statement stmt = dao.createStatement();
            stmt.executeUpdate(sql);
            dao.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public int pegarId(String nome){
        ModuloConexao conec = new ModuloConexao();
        Connection dao = conec.getInstance().sqlConnection;
        String sql = "select id from evento where nomeEvento = '" + nome + "';";
        ResultSet rs = null;
        try{
            Statement stmt = dao.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            int id = rs.getInt("id");
            dao.close();
            return id;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public boolean atualizarEvento(Evento evento, String nome){
        int id = pegarId(nome);
        System.out.println(id);
        if(id != 0){
            ModuloConexao conec = new ModuloConexao();
            Connection dao = conec.getInstance().sqlConnection;
            String sql = "UPDATE evento set contato = '" + evento.getContato() +
                                            "', data = '" + evento.getData() + 
                                            "', descricao = '" + evento.getDescricao() + 
                                            "', horario = '" + evento.getHorario() + 
                                            "', local = '" + evento.getLocal() + 
                                            "', nomeEvento = '" + evento.getNomeEvento() +
                                            "', preco = '" + evento.getPreco() +
                                            "', ingressos = '" + evento.getIngressos() +
                                            "' where id = '" + id + "';";
            try{
                Statement stmt = dao.createStatement();
                stmt.executeUpdate(sql);
                dao.close();
                return true;
            }catch(Exception e){
                e.printStackTrace();
            }
             
        }else{
            return false;
        }
        return false;
    }
    
    private Evento pegaDados(ResultSet rs) throws SQLException{
        if(rs != null && rs.next()){
            String nome = rs.getString("nomeEvento");
            String contato = rs.getString("contato");
            String descricao = rs.getString("descricao");
            String horario = rs.getString("horario");
            int ingressos = rs.getInt("ingressos");
            String local = rs.getString("local");
            float preco = rs.getFloat("preco");
            Date data = rs.getDate("data");
            
            Evento evento = new Evento(nome, ingressos, data, preco, local, contato, descricao, horario);
            return evento;
        }
        return null;
    }
    
    public Evento readEvento(String nome){
        ModuloConexao conec = new ModuloConexao();
        String sql = "select * from evento where nomeEvento = '" + nome + "';";
        ResultSet rs = null;
        try {
            Connection dao = conec.getInstance().sqlConnection;
            Statement stmt = dao.createStatement();
            rs = stmt.executeQuery(sql);
            Evento evento = pegaDados(rs);
            dao.close();
            return evento;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}

