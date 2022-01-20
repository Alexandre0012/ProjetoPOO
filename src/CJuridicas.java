import java.util.ArrayList;

public class CJuridicas extends Curso{

    public CJuridicas(String n, String uni, int nu) {
        super(n,uni,nu);
    }

    public double calcmedia(Candidato c){
        return c.getMediaSecundario()*0.50 + c.getNotaA()*0.50 + c.getBonus();
    }

    public CJuridicas clone() {
        CJuridicas temp = new CJuridicas(super.getNome(), super.getUni(), super.getNum());
        for(Candidato i: super.getListaColocados())
            temp.addCandidatoColocado(i);

        return temp;
    }

}
