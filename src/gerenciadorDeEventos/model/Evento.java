/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorDeEventos.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author lucas
 */
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private String nomeEvento;
    private String descricao;
    private int ingressos;
    private float preco;
    private String horario;
    private Date data;
    private String contato;
    private String local;
    
    @OneToMany
    private List<Palestra> palestras;
    
    @ManyToOne
    @JoinColumn(name = "cpfCriador")
    private Criador criador;
    
    public Evento(int id, String nome, int ingressos, Date data, float preco, String local, String contato, String descricao, String horario, Criador criador){
        this.id = id;
        this.nomeEvento = nome;
        this.ingressos = ingressos;
        this.data = data;
        this.preco = preco;
        this.local = local;
        this.contato = contato;
        this.descricao = descricao;
        this.horario = horario;
        this.criador = criador;
    }
    
    public Evento(int id, String nome, int ingressos, Date data, float preco, String local, String contato, String descricao, String horario){
        this.id = id;
        this.nomeEvento = nome;
        this.ingressos = ingressos;
        this.data = data;
        this.preco = preco;
        this.local = local;
        this.contato = contato;
        this.descricao = descricao;
        this.horario = horario;
    }
    
    public Evento(String nome, int ingressos, Date data, float preco, String local, String contato, String descricao, String horario){
        this.nomeEvento = nome;
        this.ingressos = ingressos;
        this.data = data;
        this.preco = preco;
        this.local = local;
        this.contato = contato;
        this.descricao = descricao;
        this.horario = horario;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIngressos() {
        return ingressos;
    }

    public void setIngressos(int ingressos) {
        this.ingressos = ingressos;
    }


    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

}
