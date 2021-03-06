/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author lucas
 */
@Entity
public class Palestra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private String nomePalestra;
    private String descricao;
    private String local;
    private String horario;
    private Date data;
    
    @ManyToOne
    @JoinColumn(name = "cpfPalestrante")
    private Palestrante palestrate;
    
    
    public Palestra(int id, String nomePalestra, String descricao, String local, String horario, Date data, Palestrante palestrante){
        this.id = id;
        this.nomePalestra = nomePalestra;
        this.descricao = descricao;
        this.local = local;
        this.horario = horario;
        this.data = data;
        this.palestrate = palestrante;
    }
    public Palestra(String nomePalestra, String descricao, String local, String horario, Date data){
        this.nomePalestra = nomePalestra;
        this.descricao = descricao;
        this.local = local;
        this.horario = horario;
        this.data = data;
    }

    public Palestrante getPalestrate() {
        return palestrate;
    }

    public void setPalestrate(Palestrante palestrate) {
        this.palestrate = palestrate;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePalestra() {
        return nomePalestra;
    }

    public void setNomePalestra(String nomePalestra) {
        this.nomePalestra = nomePalestra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
