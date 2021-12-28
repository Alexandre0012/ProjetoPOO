import java.util.ArrayList;

public class CJuridicas extends Curso{

    //private ArrayList<> ListaCjuridicas;

    public CJuridicas(String n, String uni, int nu) {
        super(n,uni,nu);
        //this.ListaHumanidades = new listaHumanidades<>();
    }

    public double calcmedia(Candidato c){
        return c.getMediaSecundario()*0.50 + c.getNotaA()*0.50;
    }

    public CJuridicas clone() {
        return new CJuridicas(super.getNome(), super.getUni(), super.getNum());
    }

}
