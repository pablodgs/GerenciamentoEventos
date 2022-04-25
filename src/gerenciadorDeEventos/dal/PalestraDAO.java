/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.dal;

import gerenciadorDeEventos.model.Evento;
import gerenciadorDeEventos.model.Palestra;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class PalestraDAO {
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
        String sql = "INSERT INTO palestra(data, descricao, horario, local, nomePalestra, vagas) values ('" + palestra.getData()
                                                                                                            + "', '" + palestra.getDescricao()
                                                                                                            + "', '" + palestra.getHorario()
                                                                                                            + "', '" + palestra.getLocal()
                                                                                                            + "', '" + palestra.getNomePalestra()
                                                                                                            + "', '" + palestra.getVagas()
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
}
