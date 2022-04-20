package gerenciadorDeEventos.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    private String cpf;
    private String nome;
    private String sexo;
    private String endereco;
    private String email;
    private String senha;
    //private Palestrante palestrante = new Palestrante();
    //private Criador criador = new Criador();

    public Usuario() {
    }
    
    public Usuario(String nome, String cpf, String sexo, String endereco, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String cpf, String endereco, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

 //   public Palestrante getPalestrante() {
 //       return palestrante;
  //  }

 //   public Criador getCriador() {
  //      return criador;
  //  }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

 //   public void setPalestrante(Palestrante palestrante) {
 //       this.palestrante = palestrante;
 //   }

 //   public void setCriador(Criador criador) {
 //       this.criador = criador;
 //   }
}