import java.util.ArrayList;

public class CJuridicas extends Curso{

    //private ArrayList<> ListaCjuridicas;

    public CJuridicas() {
        super();
    }

    public CJuridicas(String n, String uni, int nu) {
        super(n,uni,nu);
        //this.ListaHumanidades = new listaHumanidades<>();
    }


    public CJuridicas(Curso cur) {
        super(cur);
    }



    public CJuridicas clone() {
        return new CJuridicas(this);
    }

}
