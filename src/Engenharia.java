public class Engenharia extends Curso {


    public Engenharia() {
        super();
    }

    public Engenharia(String n, String uni, int nu) {
        super(n,uni,nu);
    }


    public Engenharia(Curso cur) {
        super(cur);
    }



    public Engenharia clone() {
        return new Engenharia(this);
    }
}
