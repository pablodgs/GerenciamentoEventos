/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.dal;

import com.sun.rowset.CachedRowSetImpl;
import gerenciadorDeEventos.model.Criador;
import gerenciadorDeEventos.model.Evento;
import gerenciadorDeEventos.segurança.LoginSession;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class EventoDAO {
    public boolean cadastrarEvento(Evento evento){
        ModuloConexao conec = new ModuloConexao();
        Connection dao = conec.getInstance().sqlConnection;
        String sql = "INSERT INTO evento(contato, dataInicio, dataFim, descricao, horario, local, nomeEvento, preco, ingressos, cpfCriador) values ('" + evento.getContato() 
                                                                                                                            + "', '" + evento.getDataInicio() 
                                                                                                                            + "', '" + evento.getDataFim() 
                                                                                                                            + "', '" + evento.getDescricao() 
                                                                                                                            + "', '" + evento.getHorario() 
                                                                                                                            + "', '" + evento.getLocal() 
                                                                                                                            + "', '" + evento.getNomeEvento() 
                                                                                                                            + "', '" + evento.getPreco()
                                                                                                                            + "', '" + evento.getIngressos()
                                                                                                                            + "', '" + LoginSession.cpf
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
        if(id != 0){
            ModuloConexao conec = new ModuloConexao();
            Connection dao = conec.getInstance().sqlConnection;
            String sql = "UPDATE evento set contato = '" + evento.getContato() +
                                            "', dataInicio = '" + evento.getDataInicio() + 
                                            "', dataFim = '" + evento.getDataFim() + 
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
        CriadorDAO criadorDao = new CriadorDAO();
        if(rs != null && rs.next()){
            int id = rs.getInt("id");
            String nomeEvento = rs.getString("nomeEvento");
            int ingressos = rs.getInt("ingressos");
            Date dataInicio = rs.getDate("dataInicio");
            Date dataFinal = rs.getDate("dataFim");
            float preco = rs.getFloat("preco");
            String local = rs.getString("local");
            String contato = rs.getString("contato");
            String descricao = rs.getString("descricao");
            String horario = rs.getString("horario");
            String cpfCriador = rs.getString("cpfCriador");
            
            Criador criador = criadorDao.readCriador(cpfCriador);
            
            Evento evento = new Evento(id, nomeEvento, ingressos, dataInicio, dataFinal, preco, local, contato, descricao, horario, criador);
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
            return evento;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ResultSet getEventosUsuario(){
        String sql = "select * from inscricao inner join evento on inscricao.idEvento = evento.id where cpfUsuario = '" + LoginSession.cpf + "';";
        ResultSet rs;
        Connection dao = ModuloConexao.getInstance().sqlConnection;
        try {
            Statement stmt = dao.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet getEventosCriador(){
        String sql = "select * from evento where cpfCriador = '" + LoginSession.cpf + "';";
        ResultSet rs;
        Connection dao = ModuloConexao.getInstance().sqlConnection;
        try {
            Statement stmt = dao.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet getTodosEventos(){
        String sql = "select * from evento;";
        ResultSet rs;
        Connection dao = ModuloConexao.getInstance().sqlConnection;
        try {
            Statement stmt = dao.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Evento> listaEventos(ResultSet rs){
        List<Evento> eventos = new ArrayList<>();
        if(rs == null){
            return eventos;
        }
        try{
            if(rs != null){
                Evento evento = pegaDados(rs);
                while(evento != null){
                    eventos.add(evento);
                    evento = pegaDados(rs);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return eventos;
    }
}
