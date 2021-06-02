package entidade;

import java.util.ArrayList;

public class Curso {
    
    private String nome;
    private String nivel;
    private int ano;
    private ArrayList<Rendimento> rendimentos;

    public Curso(String nome, String nivel, int ano) {
        this.nome = nome;
        this.nivel = nivel;
        this.ano = ano;
        this.rendimentos = new ArrayList<Rendimento>();
    }

    public ArrayList<Rendimento> getRendimentos() {
        return this.rendimentos;
    }

    public void addRendimento(Rendimento rendimento) {
        this.rendimentos.add(rendimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    
    @Override
    public String toString(){
        String resultado = "";
        resultado += "Nome: " + this.getNome();
        resultado += " Nivel: " + this.getNivel();
        resultado += " Ano: " + this.getAno();
        return resultado;
    }
    
}
