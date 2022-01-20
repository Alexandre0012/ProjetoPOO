public class Biociencias extends Curso{

    public Biociencias(String n, String uni, int nu) {
        super(n,uni,nu);
    }

    public double calcmedia(Candidato c){
        return c.getMediaSecundario()*0.50 + c.getNotaA()*0.40 + c.getNotaIngles()*0.10 + c.getBonus();
    }

    public Biociencias clone() {
        Biociencias temp = new Biociencias(super.getNome(), super.getUni(), super.getNum());
        for(Candidato i: super.getListaColocados())
            temp.addCandidatoColocado(i);

        return temp;
    }
}
