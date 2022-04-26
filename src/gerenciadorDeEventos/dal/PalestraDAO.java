/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.dal;

import gerenciadorDeEventos.model.Evento;
import gerenciadorDeEventos.model.Palestra;
import gerenciadorDeEventos.model.Palestrante;
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
public class PalestraDAO {
 
    private Palestra pegaDados(ResultSet rs) throws SQLException{
        PalestranteDAO palestranteDao = new PalestranteDAO();
        if(rs != null && rs.next()){
            int id = rs.getInt("id");
            Date data = rs.getDate("data");
            String descricao = rs.getString("descricao");
            String horario = rs.getString("horario");
            String local = rs.getString("local");
            String nome = rs.getString("nomePalestra");
            int vagas = rs.getInt("vagas");
            String cpfPalestrante = rs.getString("cpfPalestrante");
            
            Palestrante palestrante = palestranteDao.readPalestrante(cpfPalestrante);
            
            Palestra palestra = new Palestra(id, nome, descricao, vagas, local, horario, data, palestrante);
            return palestra;
        }
        return null;
    }
        
   
    public int pegarId(String nome){
        ModuloConexao conec = new ModuloConexao();
        Connection dao = conec.getInstance().sqlConnection;
        String sql = "select id from palestra where nomePalestra = '" + nome + "';";
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

    public boolean linkar(Evento evento, Palestra palestra){
        EventoDAO eventoDAO = new EventoDAO();
        int idPalestra = this.pegarId(palestra.getNomePalestra());
        int idEvento = eventoDAO.pegarId(evento.getNomeEvento());
        ModuloConexao conec = new ModuloConexao();
        Connection dao = conec.getInstance().sqlConnection;
        String sql = "INSERT INTO evento_palestra(Evento_id, palestras_id) values (" + idEvento + "," + idPalestra + ");";
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
    
    public boolean cadastraPalestra(Evento evento, Palestra palestra){
        ModuloConexao conec = new ModuloConexao();
        Connection dao = conec.getInstance().sqlConnection;
        String sql = "INSERT INTO palestra(data, descricao, horario, local, nomePalestra, vagas, cpfPalestrante) values ('" + palestra.getData()
                                                                                                                    + "', '" + palestra.getDescricao()
                                                                                                                    + "', '" + palestra.getHorario()
                                                                                                                    + "', '" + palestra.getLocal()
                                                                                                                    + "', '" + palestra.getNomePalestra()
                                                                                                                    + "', '" + palestra.getVagas()
                                                                                                                    + "', '" + LoginSession.cpf
                                                                                                                    +"');";
        try{
            Statement stmt = dao.createStatement();
            stmt.executeUpdate(sql);
            dao.close();
            boolean result = this.linkar(evento, palestra);
            if(result){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public ResultSet getPalestraPalestrante(){
        String sql = "select * from palestra where cpfPalestrante = '" + LoginSession.cpf + "';";
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
    
    public List<Palestra> listaPalestras(ResultSet rs){
        List<Palestra> palestras= new ArrayList<>();
        if(rs == null){
            return palestras;
        }
        try{
            if(rs != null){
                Palestra palestra = pegaDados(rs);
                while(palestra != null){
                    palestras.add(palestra);
                    palestra = pegaDados(rs);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return palestras;
    }
    
    public Palestra readPalestra(String nome){
        ModuloConexao conec = new ModuloConexao();
        String sql = "select * from palestra where nomePalestra = '" + nome + "';";
        ResultSet rs = null;
        try {
            Connection dao = conec.getInstance().sqlConnection;
            Statement stmt = dao.createStatement();
            rs = stmt.executeQuery(sql);
            Palestra palestra = pegaDados(rs);
            dao.close();
            return palestra;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean atualizarPalestra(Palestra palestra, String nome){
        int id = pegarId(nome);
        if(id != 0){
            ModuloConexao conec = new ModuloConexao();
            Connection dao = conec.getInstance().sqlConnection;
            String sql = "UPDATE palestra set data = '" + palestra.getData() +
                                            "', descricao = '" + palestra.getDescricao() + 
                                            "', horario = '" + palestra.getHorario() + 
                                            "', local = '" + palestra.getLocal() + 
                                            "', nomePalestra = '" + palestra.getNomePalestra() +
                                            "', vagas = '" + palestra.getVagas()+
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
}
