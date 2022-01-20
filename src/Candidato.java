import java.util.*;
import java.io.*;

public abstract class Candidato implements Serializable
{
    private String nome;
    private String genero;
    public int id;                 //codigo de candidato
    private int nota_exame_A;
    private int nota_exame_B;
    private int nota_ingles;
    private int media_secundario;
    private int bonus;
    private boolean aprovado;
    private ArrayList<Curso> ListaCursosDoCandidato;

    public Candidato(String n, String g, int id, int nA, int nB, int nI, int mS, int b)
    {
        this.nome = n;
        this.genero = g;
        this.id = id;
        this.nota_exame_A = nA;
        this.nota_exame_B = nB;
        this.nota_ingles = nI;
        this.media_secundario = mS;
        this.bonus = b;
        this.aprovado = false;
        this.ListaCursosDoCandidato = new ArrayList<Curso>();
    }


    //Métodos
    public String getNome(){ return this.nome; }
    public String getGenero(){ return this.genero; }
    public int getID(){ return this.id;}
    public int getNotaA(){ return this.nota_exame_A; }
    public int getNotaB(){ return this.nota_exame_B; }
    public int getNotaIngles(){ return this.nota_ingles; }
    public int getMediaSecundario(){ return this.media_secundario; }
    public int getBonus(){ return this.bonus; }
    public boolean getAprovado(){ return this.aprovado; }
    public void addCursoAoCandidato(Curso curso) {
        this.ListaCursosDoCandidato.add(curso.clone());
    }

    public ArrayList<Curso> getCursoDoCandidato()
    {
        ArrayList<Curso> temp = new ArrayList<Curso>();
        for(Curso c: this.ListaCursosDoCandidato){
           temp.add(c.clone());
        }
        return temp;
    }

    public void showListaCursosDoCandidato(){
        for(Curso curso: this.ListaCursosDoCandidato){
            System.out.println(curso.getNome());
        }
    }

    public void retiraCandidatosDasOpcoes(Candidato c, int pos){
        int i = 1;
        for(Curso curso: this.ListaCursosDoCandidato){
            if(i == pos){
                c.aprovado = true;
            }
            else curso.remove(c);

            i++;
        }
    }

    //Métodos Comuns 
    public boolean equals(Object obj)
    {
        if(obj == null || this.getClass() != obj.getClass())
            return false;

        Candidato c = (Candidato) obj;

        return this.id == c.id;
    }

    public String toString()
    {
        return "Nome: " + this.nome +
                "\nID: " + this.id +
                "\nGénero: " + this.genero +
                "\nCódigo de Candidato: " + this.id +
                "\nNota Exame A: " + this.nota_exame_A +
                "\nNota Exame B: " + this.nota_exame_B +
                "\nNota Exame Inglês: " + this.nota_ingles +
                "\nNota Média Secundário: " + this.media_secundario;
    }

    public abstract Candidato clone();
} 