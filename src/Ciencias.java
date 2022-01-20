public class Ciencias extends Curso{

    public Ciencias(String n, String uni, int nu) {
        super(n,uni,nu);
    }

    public double calcmedia(Candidato c){
        return c.getMediaSecundario()*0.25 + c.getNotaA()*0.25 + c.getNotaB()*0.25 + c.getNotaIngles()*0.25 + c.getBonus();
    }

    public Ciencias clone() {
        Ciencias temp = new Ciencias(super.getNome(), super.getUni(), super.getNum());
        for(Candidato i: super.getListaColocados())
            temp.addCandidatoColocado(i);

        return temp;
    }
}
