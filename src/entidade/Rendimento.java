package entidade;

public class Rendimento {
    private Aluno aluno;
    private Notas notas;


    public Rendimento(String id, double np1, double np2, double sub, double exame) {
        
    }
        
    public Rendimento(Aluno aAluno,Curso aCurso, Notas aNotas) {
        this.aluno = aAluno;
        this.notas = aNotas;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Notas getNotas() {
        return notas;
    }

    public void setNotas(Notas notas) {
        this.notas = notas;
    }
    
   @Override
    public String toString(){
        String resultado = "";
        resultado += "Aluno: " + this.getAluno() + "\n";
        resultado += "Notas: " + this.getNotas();
        return resultado;
    }  
}
