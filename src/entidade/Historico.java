package entidade;

public class Historico {
    private Curso curso;
    private Notas notas;
    
    public Historico(Aluno aAluno,Curso aCurso, Notas aNotas) {
        this.curso = aCurso;
        this.notas = aNotas;
    }
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
        resultado += "Curso: " + this.getCurso() + "\n";
        resultado += "Notas: " + this.getNotas();
        return resultado;
    }    
}
