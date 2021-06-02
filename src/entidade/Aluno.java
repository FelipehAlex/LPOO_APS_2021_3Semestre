package entidade;

import java.util.ArrayList;

public class Aluno {
    
    private String id;
    private String nome;
    private ArrayList<Historico> historicos;
    
    public Aluno(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.historicos = new ArrayList<Historico>();
    }
    
    public ArrayList<Historico> getHistorico() {
        return this.historicos;
    }

    public void addHistorico(Historico historico) {
        this.historicos.add(historico);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
      
   /* @Override
    public String toString(){
        String resultado = "";
        resultado += "Id: " + this.getId();
        resultado += " Nome: " + this.getNome();
        return resultado;
    }    */
    
}
