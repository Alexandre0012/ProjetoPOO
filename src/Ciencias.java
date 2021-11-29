public class Ciencias extends Curso{

    public Ciencias() {
        super();
    }

    public Ciencias(String n, String uni, int nu) {
        super(n,uni,nu);
    }


    public Ciencias(Curso cur) {
        super(cur);
    }



    public Ciencias clone() {
        return new Ciencias(this);
    }
}
