import java.util.*;

public abstract class Curso
{

    private String nome;
    private String uni;
    private int num;
    private TreeSet<Candidato>ListaColocados;

    //Construtor 1
    public Curso()
    {
        this.nome = "";
        this.uni = "";
        this.num = 0;
    }

    //Construtor 2
    public Curso(String n, String u, int nu)
    {
        this.nome = n;
        this.uni = u;
        this.num = nu;
    }

    //Construtor 3
    public Curso(Curso cur)
    {
        this.nome = cur.getNome();
        this.uni = cur.getUni();
        this.num = cur.getNum();
        this.ListaColocados = new TreeSet<Candidato>();
    }

    //Métodos
    public String getNome() { return this.nome; }
    public String getUni() { return this.uni; }
    public int getNum() { return this.num; }

    public void add(Candidato c)
    { this.ListaColocados.add(c);}
    public void remove(Candidato c)
    { this.ListaColocados.remove(c);}
    public boolean existe(Candidato c)
    { return this.ListaColocados.contains(c);}

    public TreeSet<Candidato> colocados()
    {
        TreeSet<Candidato> temp = new TreeSet<Candidato>();
        for(Candidato c: this.ListaColocados)
            temp.add(c);
        return temp;
    }


    public String toString()
    {
        return "Universidade: " + this.uni +
                "\nNome do Curso: " + this.nome +
                "\nNºClausus: " + this.num;
    }

    public abstract double calcmedia(Candidato c);
    public abstract Curso clone();
}





