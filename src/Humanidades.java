import java.util.ArrayList;

public class Humanidades extends Curso {
    //private ArrayList<> ListaHumanidades;

    public Humanidades() {
        super();
    }

    public Humanidades(String n, String uni, int nu) {
        super(n,uni,nu);
        //this.ListaHumanidades = new listaHumanidades<>();
    }


    public Humanidades(Curso cur) {
        super(cur);
    }



    public Humanidades clone() {
        return new Humanidades(this);
    }
}
