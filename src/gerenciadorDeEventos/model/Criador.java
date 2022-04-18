package gerenciadorDeEventos.model;

public class Criador {
    private int cnpj;
    private String telefone;
    private String dadosPagamento;
    
    public Criador() {
    }

    public Criador(int cnpj, String telefone, String dadosPagamento) {
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.dadosPagamento = dadosPagamento;
    }
    
    public int getCnpj() {
        return cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDadosPagamento() {
        return dadosPagamento;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDadosPagamento(String dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
    }
}