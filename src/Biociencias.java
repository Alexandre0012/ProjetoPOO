public class Biociencias extends Curso{

    public Biociencias() {
        super();
    }

    public Biociencias(String n, String uni, int nu) {
        super(n,uni,nu);
    }


    public Biociencias(Curso cur) {
        super(cur);
    }



    public Biociencias clone() {
        return new Biociencias(this);
    }

}
