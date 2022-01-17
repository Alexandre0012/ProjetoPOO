import java.util.*;
import java.io.*;

public abstract class Candidato
{
    private String nome;
    private String genero;
    public int id;                 //codigo de candidato
    private int nota_exame_A;
    private int nota_exame_B;
    private int nota_ingles;
    private int media_secundario;
    private boolean colocado;

    //private int bonus;
    private HashMap<String, Curso> ListaC;

    public Candidato(String n, String g, int id, int nA, int nB, int nI, int mS)
    {
        this.nome = n;
        this.genero = g;
        this.id = id;
        this.nota_exame_A = nA;
        this.nota_exame_B = nB;
        this.nota_ingles = nI;
        this.media_secundario = mS;
        this.colocado = true;
        this.ListaC = new HashMap<String,Curso>();
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
        this.colocado = true;
        this.id = getID();
    }


    //Métodos
    public String getNome(){ return this.nome; }
    public String getGenero(){ return this.genero; }
    public int getID(){ return this.id;}
    public int getNotaA(){ return this.nota_exame_A; }
    public int getNotaB(){ return this.nota_exame_B; }
    public int getNotaIngles(){ return this.nota_ingles; }
    public int getMediaSecundario(){ return this.media_secundario; }
    public void addCurso(Curso curso)
    {
        this.ListaC.put("", curso.clone());
    }

    //public int getBonus(){ return this.bonus; }

    /*public void setBonus(int b) //bonus = b
    {
        this.bonus = b;
    }*/


    public HashMap<String, Curso> aprovacao(HashMap<String, Curso> temp, int pos){

        int i = 0;

        for(String s: this.ListaC.keySet()){
            Curso c = ListaC.get(s);
            switch (pos) {
                case 0: {
                    this.ListaC.replace("aprovado", c);
                    this.colocado = true;
                    break;
                }
                case 1:{
                    if (i == 1) {
                        this.ListaC.replace("aprovado", c);
                        this.colocado = true;
                    }
                    this.ListaC.replace("", c);
                    break;
                }
                case 2:{
                    if (i == 2) {
                        this.ListaC.replace("aprovado", c);
                        this.colocado = true;
                    }
                    this.ListaC.replace("", c);
                    break;
                }
                case 3:{
                    if (i == 3) {
                        this.ListaC.replace("aprovado", c);
                        this.colocado = true;
                    }
                    this.ListaC.replace("", c);
                    break;
                }
                case 4:{
                    if (i == 4) {
                        this.ListaC.replace("aprovado", c);
                        this.colocado = true;
                    }
                    this.ListaC.replace("", c);
                    break;
                }
                case 5:{
                    this.ListaC.replace("Nao aprovado", c);
                    this.colocado = false;
                    break;
                }
            }
            i++;
        }

        return temp;
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