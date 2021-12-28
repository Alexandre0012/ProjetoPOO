public class Ciencias extends Curso{

    public Ciencias(String n, String uni, int nu) {
        super(n,uni,nu);
    }

    public double calcmedia(Candidato c){
        return c.getMediaSecundario()*0.25 + c.getNotaA()*0.25 + c.getNotaB()*0.25 + c.getNotaIngles()*0.25;
    }

    public Ciencias clone() {
        return new Ciencias(super.getNome(), super.getUni(), super.getNum());
    }
}
