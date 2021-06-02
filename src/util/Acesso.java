package util;

import entidade.Curso;
import entidade.Aluno;
import entidade.Rendimento;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Acesso {

    // CARREGAR CONTEUDO DO CSV

    public static List<Aluno> loadAluno(String filePath) {

        List<Aluno> alunos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String linha;
            String line = "ALUNO: ";
            int cont = 1;
            while ((linha = br.readLine()) != null) {

                System.out.println(line + cont++);
                String[] palavras = linha.split(";");

                for (String aluno : palavras) {
                    System.out.println("--> " + aluno);
                }

                System.out.println("___________________________");
                String id = palavras[0];
                String nome = palavras[1];

                Aluno aluno = new Aluno(id, nome);
                alunos.add(aluno);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return alunos;

    }

    public static List<Curso> loadACurso(String filePath) {

        List<Curso> cursos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String linha;
            String line = "REGISTRO: ";
            int cont = 1;
            while ((linha = br.readLine()) != null) {

                System.out.println(line + cont++);

                String[] palavras = linha.split(";");

                for (String curso : palavras) {
                    System.out.println("--> " + curso);
                }
                System.out.println("_______________________________");

                String nome = palavras[0];
                String nivel = palavras[1];
                int ano = Integer.parseInt(palavras[2]);

                Curso curso = new Curso(nome, nivel, ano);
                cursos.add(curso);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cursos;

    }

    public static List<Rendimento> loadARendimento(String filePath) {

        List<Rendimento> report = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String linha;
            String line = "RENDIMENTO: ";
            int cont = 1;
            while ((linha = br.readLine()) != null) {

                System.out.println(line + cont++);

                String[] palavras = linha.split(";");

                for (String rend : palavras) {
                    System.out.println("--> " + rend);
                }

                System.out.println("_______________________________");

                String id = palavras[0];
                double np1 = Double.parseDouble(palavras[1]);
                double np2 = Double.parseDouble(palavras[2]);
                double sub = Double.parseDouble(palavras[3]);
                double exame = Double.parseDouble(palavras[4]);

                Rendimento rend = new Rendimento(id, np1, np2, sub, exame);
                report.add(rend);
            }

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return report;

    }

    // SALVAR NO CSV
    public static void saveCurso(List<Curso> cursos, String filePath) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            boolean flag = true;

            for (Curso c : cursos) {
                for (Curso curso : cursos) {
                    if (c.getNome().equals(curso.getNome()) && c.getNivel().equals(curso.getNivel()) && c.getAno() == curso.getAno()){
                        System.out.println("Curso já cadastrado!");
                        flag = false;
                    }
                }
            }
       
            if (flag) {
                for (Curso curso : cursos) {
                    bw.write(curso.getNome() + ";" + curso.getNivel() + ";" + curso.getAno());
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveRendimento(ArrayList<Rendimento> rendimentos, String filePath) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {

            for (Rendimento r : rendimentos) {
                bw.write(r.getAluno().getId() + ";" + r.getNotas().getNp1() + ";" + r.getNotas().getNp2() + ";"
                        + r.getNotas().getSub() + ";" + r.getNotas().getExame());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveAluno(List<Aluno> alunos, String filePath) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            boolean flag = true;
            for (Aluno a : alunos) {
                for (Aluno aluno : alunos) {
                    if (aluno.getId().equals(a.getId())) {
                        System.out.println("ID já cadastrado!" + "\n");
                        flag = false;
                    }
                }
            }
            if (flag) {
                for (Aluno aluno : alunos) {
                    bw.write(aluno.getId() + ";" + aluno.getNome());
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
