import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class Engenharia extends Curso {


    public Engenharia(String n, String uni, int nu) {
        super(n,uni,nu);
    }

    public double calcmedia(Candidato c){
        return c.getMediaSecundario() * 0.50 + c.getNotaA() * 0.25 + c.getNotaB() * 0.25 + c.getBonus();
    }

    public Engenharia clone() {
        Engenharia temp = new Engenharia(super.getNome(), super.getUni(), super.getNum());
        for(Candidato i: super.getListaColocados())
            temp.addCandidatoColocado(i);

        return temp;
    }
}
