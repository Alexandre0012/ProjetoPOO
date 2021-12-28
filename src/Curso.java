
public abstract class Curso
{

    private String nome;
    private String uni;
    private int num;

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
    }

    //Métodos
    public String getNome() { return this.nome; }
    public String getUni() { return this.uni; }
    public int getNum() { return this.num; }


    public String toString()
    {
        return "Universidade: " + this.uni +
                "\nNome do Curso: " + this.nome +
                "\nNºClausus: " + this.num;
    }

    public abstract double calcmedia(Candidato c);
    public abstract Curso clone();
}





