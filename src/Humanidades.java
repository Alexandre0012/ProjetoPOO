import java.util.ArrayList;

public class Humanidades extends Curso {
    private ArrayList<Candidato> ListaHumanidades;

    public Humanidades(String n, String uni, int nu) {
        super(n,uni,nu);
        this.ListaHumanidades = new ArrayList<Candidato>();
    }

    public double calcmedia(Candidato c){
        return c.getMediaSecundario()*0.75 + c.getNotaB()*0.25;
    }

    public Humanidades clone() {
        return new Humanidades(super.getNome(), super.getUni(), super.getNum());
    }
}
