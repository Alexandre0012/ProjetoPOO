import java.util.ArrayList;
import java.util.TreeSet;

public class Humanidades extends Curso {

    public Humanidades(String n, String uni, int nu) {
        super(n,uni,nu);
    }

    public double calcmedia(Candidato c){
        return c.getMediaSecundario()*0.75 + c.getNotaB()*0.25 + c.getBonus();
    }

    public Humanidades clone() {
        return new Humanidades(super.getNome(), super.getUni(), super.getNum());
    }
}
