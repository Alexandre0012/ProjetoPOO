import java.util.ArrayList;

public class CJuridicas extends Curso{

    //private ArrayList<> ListaCjuridicas;

    public CJuridicas(String n, String uni, int nu) {
        super(n,uni,nu);
    }

    public double calcmedia(Candidato c){
        return c.getMediaSecundario()*0.50 + c.getNotaA()*0.50 + c.getBonus();
    }

    public CJuridicas clone() {
        return new CJuridicas(super.getNome(), super.getUni(), super.getNum());
    }

}
