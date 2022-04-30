/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.controller;

import gerenciadorDeEventos.dal.EventoDAO;
import gerenciadorDeEventos.dal.PalestraDAO;
import gerenciadorDeEventos.model.Evento;
import gerenciadorDeEventos.model.Palestra;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lucas
 */
public class PalestraController {
    public boolean cadastrarPalestra(Evento evento, String nome, String descricao, String local, String horario, Date data){
        Palestra palestra = new Palestra(nome, descricao, local, horario, data);
        PalestraDAO palestraDAO = new PalestraDAO();
        EventoDAO eventoDAO = new EventoDAO();
        Evento event = eventoDAO.readEvento(evento.getNomeEvento());
        if(event != null){
            palestraDAO.cadastraPalestra(evento, palestra);
            return true;
        }else{
            return false;
        }
    }
   
    public boolean atualizarPalestra(String nome, String nomeNovo, Date data, String local, String descricao, String horario){
        Palestra palestra = new Palestra(nomeNovo, descricao, local, horario, data);
        PalestraDAO palestraDAO = new PalestraDAO();
        boolean update = palestraDAO.atualizarPalestra(palestra, nome);
        if(update){
            return true;
        }
        return false;
    }
    
    public List<Palestra> lerPalestraPalestrante(){
        PalestraDAO palestraoDao = new PalestraDAO();
        ResultSet rs = palestraoDao.getPalestraPalestrante();
        return palestraoDao.listaPalestras(rs);
    }
    
    public Palestra lerPalestra(String nome){
        Palestra palestra = null;
        PalestraDAO palestraDAO = new PalestraDAO();
        palestra = palestraDAO.readPalestra(nome);
        return palestra;
    }
    
    public List<Palestra> lerPalestrasEvento(int id){
        PalestraDAO palestraoDao = new PalestraDAO();
        ResultSet rs = palestraoDao.getPalestraEvento(id);
        return palestraoDao.listaPalestras(rs);
    }
}
