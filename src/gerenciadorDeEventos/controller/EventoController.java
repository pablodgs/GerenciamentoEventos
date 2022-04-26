/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.controller;

import gerenciadorDeEventos.dal.EventoDAO;
import gerenciadorDeEventos.model.Evento;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lucas
 */
public class EventoController {
    public boolean cadastrarEvento(String nome, int ingressos, Date data, float preco, String local, String contato, String descricao, String horario){
        Evento evento = new Evento(nome, ingressos, data, preco, local, contato, descricao, horario);
        EventoDAO eventoDAO = new EventoDAO();
        Evento event = eventoDAO.readEvento(nome);
        if(event == null){
            eventoDAO.cadastrarEvento(evento);
            return true;
        }
        return false;
    }
    
    public Evento lerEvento(String nome){
        Evento evento = null;
        EventoDAO eventoDAO = new EventoDAO();
        evento = eventoDAO.readEvento(nome);
        return evento;
    }
        
    public List<Evento> lerEventosCriador(){
        EventoDAO eventoDao = new EventoDAO();
        ResultSet rs = eventoDao.getEventosCriador();
        return eventoDao.listaEventos(rs);
    }
        
    public boolean atualizarEvento(String nome, String nomeNovo, int ingressos, Date data, float preco, String local, String contato, String descricao, String horario){
        Evento evento = new Evento(nomeNovo, ingressos, data, preco, local, contato, descricao, horario);
        EventoDAO eventoDAO = new EventoDAO();
        boolean update = eventoDAO.atualizarEvento(evento, nome);
        if(update){
            return true;
        }
        return false;
    }
    
    public List<Evento> lerTodosEventos(){
        EventoDAO eventoDao = new EventoDAO();
        ResultSet rs = eventoDao.getTodosEventos();
        return eventoDao.listaEventos(rs);
    }
}
