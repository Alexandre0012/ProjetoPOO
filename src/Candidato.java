import java.util.*;
import java.io.*;

public abstract class Candidato
{
    private static int count = 0;

    private String nome;
    private String genero;
    private int id;                 //codigo de candidato
    private int nota_exame_A;
    private int nota_exame_B;
    private int nota_ingles;
    private int media_secundario;

    private int bonus;


    //Construtor 1
    public Candidato()
    {
        this.nome = "";
        this.genero = "";
        this.id = 0;
        this.nota_exame_A = 0;
        this.nota_exame_B = 0;
        this.nota_ingles = 0;
        this.media_secundario = 0;
        this.bonus = 0;
        this.id = count + 1;        //id = id+1;
        count++;
    }


    //Construtor 2
    public Candidato(String n, String g, int nA, int nB, int nI, int mS)
    {
        this.nome = n;
        this.genero = g;
        this.id = 0;
        this.nota_exame_A = nA;
        this.nota_exame_B = nB;
        this.nota_ingles = nI;
        this.media_secundario = mS;
        this.id = count + 1;        //id = id+1;
        count++;
    }

    //Construtor 3
    public Candidato(Candidato c)
    {
        this.nome = c.getNome();
        this.genero = c.getGenero();
        this.nota_exame_A = c.getNotaA();
        this.nota_exame_B = c.getNotaB();
        this.nota_ingles = c.getNotaIngles();
        this.media_secundario = c.getMediaSecundario();
        this.bonus = c.getBonus();
        this.id = count + 1;        //id = id+1;
        count++;
    }


    //Métodos
    public String getNome(){ return this.nome; }
    public String getGenero(){ return this.genero; }
    public int getID(){ return this.id; }
    public int getNotaA(){ return this.nota_exame_A; }
    public int getNotaB(){ return this.nota_exame_B; }
    public int getNotaIngles(){ return this.nota_ingles; }
    public int getMediaSecundario(){ return this.media_secundario; }
    public int getBonus(){ return this.bonus; }

    public void setBonus(int b) //bonus = b
    {
        this.bonus = b;
    }

    //Métodos Comuns 
    public boolean equals(Object obj)
    {
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Candidato c = (Candidato) obj;

        return this.getID() == c.getID();
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