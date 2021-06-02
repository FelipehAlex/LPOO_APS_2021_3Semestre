package menu;

import entidade.Aluno;
import entidade.Curso;
import entidade.Historico;
import entidade.Notas;
import entidade.Rendimento;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import util.Acesso;

public class APS {

    public static void iniciar(){
        
       ArrayList<Aluno> alunos = new ArrayList<>();
       ArrayList<Curso> cursos = new ArrayList<>();
       ArrayList<Rendimento> rendimentos = new ArrayList<>();
        
        int opcao = 0;
        Scanner in = new Scanner(System.in);
        while(opcao!=7){
            System.out.println("Digite a opção:");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Cadastrar Curso");
            System.out.println("3 - Cadastrar Rendimento");
            System.out.println("4 - Listar todos os Alunos");
            System.out.println("5 - Listar todos os Cursos"); 
            System.out.println("6 - Imprimir Relatório do Curso");
            System.out.println("7 - Imprimir Histórico do Aluno"); 
            System.out.println("8 - Sair");
            opcao = Integer.parseInt(in.nextLine());
            switch(opcao){
                case 1: incluirAluno(alunos); break;
                case 2: incluirCurso(cursos); break;
                case 3: incluirRendimento(cursos, alunos, rendimentos); break;
                case 4: listarAlunos(alunos); break;
                case 5: listarCursos(cursos); break;
                case 6: imprimeRelatorio(cursos); break;
                case 7: imprimeHistorico(alunos); break;
                case 8: break;
                default: System.out.println("Opção " + opcao + "inválida!");
            }
        }
        System.out.println("Saindo do programa!");       
    }  
    
    //Aluno
    public static Aluno pegaAluno(){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Entre com os dados do Aluno");
        System.out.println("ID:");
        String id = in.nextLine();
        System.out.println("Nome:");
        String nome = in.nextLine();
        Aluno aluno = null;
        aluno = new Aluno(id, nome);
        return aluno;
     }
    public static void incluirAluno(ArrayList<Aluno> alunos){
        boolean flag = true;
        Aluno aluno = pegaAluno();
        for (Aluno a : alunos) {
            if (aluno.getId().equals(a.getId())) {
                System.out.println("ID já cadastrado!" + "\n");
                flag = false;
            }
        }
        if (flag) {
            alunos.add(aluno);
            Acesso.saveAluno(alunos, "files/alunos.csv");
        }
        
    }
    public static void listarAlunos(ArrayList<Aluno> alunos){
        System.out.println("Listando alunos: ");
        Acesso.loadAluno("files/alunos.csv");
    }
    
    //Curso
    public static String pegaNivel(){
        String nivel = "";
        int opcao = 0;
        Scanner in = new Scanner(System.in);
        while(opcao!=2 && opcao!=1){
            System.out.println("Digite a opção:");
            System.out.println("1 - Graduação");
            System.out.println("2 - Pós-Graduação");
            opcao = Integer.parseInt(in.nextLine());
            switch(opcao){
                case 1: nivel = "GRADUACAO"; break;
                case 2: nivel = "POS_GRADUACAO"; break;
                default: System.out.println("Opção " + opcao + " inválida!");
            }
        }
        return nivel;
     }
    public static Curso pegaCurso(){
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Entre com os dados do Curso");
        System.out.println("Nome:");
        String nome = in.nextLine();
        System.out.println("Nivel:");
        String nivel = pegaNivel();
        System.out.println("Ano");
        int ano = Integer.parseInt(in.nextLine());
        Curso curso = null;
        curso = new Curso(nome, nivel, ano);
        return curso;
     }
    public static void incluirCurso(ArrayList<Curso> cursos){
        Curso curso = pegaCurso();
        cursos.add(curso);
        Acesso.saveCurso(cursos, "files/cursos.csv");
    }
    public static void listarCursos(ArrayList<Curso> cursos){
        System.out.println("Listando cursos: ");
        Acesso.loadACurso("files/cursos.csv");
    }
    
    //Rendimento
    public static Notas pegarNota(){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Digite as notas:");
        System.out.println("Np1:");
        double np1 = Double.parseDouble(in.nextLine());
        System.out.println("Np2:");
        double np2 = Double.parseDouble(in.nextLine());
        System.out.println("Sub:");
        double sub = Double.parseDouble(in.nextLine());
        System.out.println("Exame:");
        double exame = Double.parseDouble(in.nextLine());

        Notas nota = new Notas(np1, np2, sub, exame);
        return nota;
    }

    public static Curso selecionarCurso(ArrayList<Curso> cursos) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Digite os Dados do Curso:");
        System.out.println("Nome:");
        String nome = in.nextLine();
        System.out.println("Nivel:");
        String nivel = pegaNivel();
        System.out.println("Ano");
        int ano = Integer.parseInt(in.nextLine());
        Curso curso = new Curso(nome, nivel, ano);

        /*for(Curso c : cursos) {
            if(c.getNome().equals(curso.getNome()) && c.getNivel().equals(curso.getNivel()) && c.getAno() == curso.getAno())
                return c;
        }*/
        return curso;
    }

    public static Aluno selecionarAluno(ArrayList<Aluno> alunos) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Digite o ID do Aluno:");
        String id = in.nextLine();
        Aluno aluno = new Aluno(id,"");

        /*for(Aluno a : alunos) {
            if(a.getId().equals(id))
                return a;
        }*/
        return aluno;
    }
    
    public static void incluirRendimento(ArrayList<Curso> cursos, ArrayList<Aluno> alunos, ArrayList<Rendimento> rend){
        
        Curso curso = selecionarCurso(cursos);
        String filePath = String.format("%s_%s_%d", curso.getNome(), curso.getNivel(), curso.getAno()).toUpperCase();
        Aluno aluno = selecionarAluno(alunos);
        Notas nota = pegarNota();
        
        nota.calculaMediaFinal(nota.getNp1(), nota.getNp2(), nota.getSub(), nota.getExame(), curso);
        Rendimento redimento = new Rendimento(aluno, curso, nota);
        curso.addRendimento(redimento);
        rend.add(redimento);
        Acesso.saveRendimento(rend, "files/"+filePath+".csv");
        
        Historico historico = new Historico(aluno, curso, nota);
        aluno.addHistorico(historico);
    }

    private static void imprimeRelatorio(ArrayList<Curso> cursos) {
        Curso c = selecionarCurso(cursos);
        ArrayList<Rendimento> rendimentos;
        rendimentos =  c.getRendimentos();
        System.out.println("Imprimindo Relatório: ");
        String filePath = String.format("%s_%s_%d", c.getNome(), c.getNivel(), c.getAno()).toUpperCase();

     
        Acesso.loadARendimento("files/"+filePath+".csv");
        
        /*for(Rendimento r: rendimentos){
            System.out.println(r);
            System.out.println();
        }*/
    }
    
    
    private static void imprimeHistorico(ArrayList<Aluno> alunos) {
        Aluno a = selecionarAluno(alunos);
        ArrayList<Historico> historicos;
        historicos =  a.getHistorico();
        System.out.println("Imprimindo Histórico: ");
        for(Historico h: historicos){
            System.out.println(h);
            System.out.println();
        } 
    }
    
}
