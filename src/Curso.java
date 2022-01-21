import java.io.Serializable;
import java.util.*;

public abstract class Curso implements Serializable
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
    public TreeSet<Candidato> getListaColocados()
    {
        TreeSet<Candidato> novo = new TreeSet<Candidato>(ordenacao1);
        for(Candidato c: this.ListaColocados)
            novo.add(c);
        return novo;
    }

    Comparator<Candidato> ordenacao1 = (x1, x2) ->
    {
        if (x1.id == x2.id){
            //this.ListaColocados.remove(x2);
            return  0;
        }
        if (calcmedia(x1) < calcmedia(x2)){
            return  1;
        }
        else if (calcmedia(x1) == calcmedia(x2)) {
            if(x1.getBonus() < x2.getBonus())  return 1;
            else if(x1.getBonus() == x2.getBonus()){
                if(x1.getGenero().equals("Feminino")) return -1;
                else if(x1.getGenero().equals("Masculino")){
                    if(x2.getGenero().equals("Masculino")) return -1;
                    else return 1;
                }
            }
        }
        return  -1;
    };

    public void addCandidatoColocado(Candidato c)
    { this.ListaColocados.add(c);}
    public void remove(Candidato c)
    { this.ListaColocados.remove(c);}
    public boolean existe(Candidato c)
    { return this.ListaColocados.contains(c);}

    public String toString()
    {
        return "Nome do Curso: " + this.nome
                +"\nUniversidade: " + this.uni;
    }

    public boolean equals(Object o){
        if(o!=null){
            if(this.getClass()==o.getClass()){
                Curso c = (Curso) o;
                if(this.getUni()== c.getUni() && this.getNome() == c.getNome()){
                    return true;
                }
            }
        }
        return false;
    }

    public abstract double calcmedia(Candidato c);
    public abstract Curso clone();
}





