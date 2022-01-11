import java.util.*;

public class GestaoAcesso
{
    public static ArrayList<Candidato> candidato;
    public static ArrayList<Curso> curso;


    static
    {
        candidato = new ArrayList<Candidato>();
        curso = new ArrayList<Curso>();
    }

    public static List<Candidato> getCandidato() { return candidato; }
    public static List<Curso> getCurso() { return curso; }

    //Adiciona Candidatos 
    public void addCandidato(Candidato c)
    {
        if(c != null)
            candidato.add(c.clone());
    }

    public void addCurso(Curso c)
    {
        if(c != null)
            curso.add(c.clone());
    }


    public void listarCandidatos(){

        for(Candidato c: candidato){
            System.out.println(candidato);
        }
    }

    public void listarCursos(){

        for(Curso c: curso){
            System.out.println(curso);
        }
    }

    public int NTotalCandidatos(){
        int temp = 0;

        for(Candidato i: candidato){
            temp++;
        }
        return temp;
    }

    public int NTotalCursos(){
        int temp = 0;

        for(Curso c: curso){
            temp++;
        }
        return temp;
    }

    public TreeSet<Candidato> verificaMedia(Candidato candidato, Curso curso){
        double min = -1.0;

        TreeSet<Candidato> temp = new TreeSet<Candidato>();

        Candidato temp1 = new Candidato() {
            @Override
            public Candidato clone() {
                return null;
            }
        };

        for(Candidato i: curso.colocados()){
            if(curso.calcmedia(candidato) < min){
                min = curso.calcmedia(i);
                temp1 = i;
            }
        }

        if(curso.calcmedia(candidato) > min){
            curso.colocados().remove(temp1);
            curso.colocados().add(candidato);
        }
        temp = curso.colocados();

        return temp;
    }


    public TreeSet<Candidato> candidatura(){
        TreeSet<Candidato>temp = new TreeSet<Candidato>();
        for(Candidato c: candidato){
            for(Curso cc: c.getListaCursos()){
                temp = verificaMedia(c,cc);
            }
        }
        return temp;
    }


}