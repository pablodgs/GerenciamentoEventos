package gerenciadorDeEventos.model;

public class Palestrante {
    
    private String formacao;
    private String experiencias;
    
    public Palestrante(){
    }

    public Palestrante(String formacao, String experiencias) {
        this.formacao = formacao;
        this.experiencias = experiencias;
    }

    public String getFormacao() {
        return formacao;
    }

    public String getExperiencias() {
        return experiencias;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public void setExperiencias(String experiencias) {
        this.experiencias = experiencias;
    }
}