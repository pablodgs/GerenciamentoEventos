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
import java.util.Date;

/**
 *
 * @author lucas
 */
public class PalestraController {
    public boolean cadastrarPalestra(Evento evento, String nome, String descricao, int vagas, String local, String horario, Date data){
        Palestra palestra = new Palestra(nome, descricao, vagas, local, horario, data);
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
}
