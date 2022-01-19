import java.util.*;

public abstract class Curso
{

    private String nome;
    private String uni;
    private int num;
    private TreeSet<Candidato>ListaColocados;

    public Curso(String n, String u, int nu)
    {
        this.nome = n;
        this.uni = u;
        this.num = nu;
        this.ListaColocados = new TreeSet<Candidato>(ordenacao1);
    }

    //Métodos
    public String getNome() { return this.nome; }
    public String getUni() { return this.uni; }
    public int getNum() { return this.num; }
    public Set<Candidato> getCandidato()
    {
        TreeSet<Candidato> novo = new TreeSet<Candidato>();
        for(Candidato i: this.ListaColocados)
            novo.add(i);
        return novo;
    }

    Comparator<Candidato> ordenacao1 = (x1, x2) ->
    {
        if (x1.id == x2.id){ // igualdade (para remove() funcionar)
            this.ListaColocados.remove(x2);
            return  0;
        }
        if (calcmedia(x1) < calcmedia(x2)){
            return  1;
        }
        else
        if (calcmedia(x1) == calcmedia(x2)) { //implementa desempate de acordo com o enunciado!!

        }

        return  -1;

    };

    public void addCandidatoColocado(Candidato c)
    { this.ListaColocados.add(c);}
    public void remove(Candidato c)
    { this.ListaColocados.remove(c);}
    public boolean existe(Candidato c)
    { return this.ListaColocados.contains(c);}
    public void show(){
        System.out.println("\n" + this.getNome() + ",  " + this.getUni() + "\n");
        for(Candidato candidato: ListaColocados){
            System.out.println(candidato.getNome() + ", " + calcmedia(candidato));
        }
    }

    public boolean verificaColocacao(Candidato c){
        int i = 1;
        for(Candidato candidato: ListaColocados){
            System.out.println("cheguei aqui");
            if(i <= this.getNum()){
                System.out.println("cheguei aqui2");
                if(candidato == c) return true;
            }
            i++;
        }
        return false;
    }


    public String toString()
    {
        return "Universidade: " + this.uni +
                "\nNome do Curso: " + this.nome;
    }

    public abstract double calcmedia(Candidato c);
    public abstract Curso clone();
}





