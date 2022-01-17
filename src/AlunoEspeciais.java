public class AlunoEspeciais extends Candidato
{
    private int nivel_necessidade;      //Entre 0 a 100
    private String incapacidade;        //tipo de incapacidade (motora, sensorial, outra)

    public AlunoEspeciais(String n, String g, int id, int nA, int nB, int nI, int mS, int nC, String inc){
        super(n,g,id,nA,nB,nI,mS);
        this.nivel_necessidade = nC;
        this.incapacidade = inc;
    }

    //Métodos
    private int getNivelNecessidade(){ return this.nivel_necessidade; }
    private String getIncapacidade(){ return this.incapacidade; }

    public AlunoEspeciais clone() {
        return new AlunoEspeciais(super.getNome(), super.getGenero(), super.getID(), super.getNotaA(),
                super.getNotaB(), super.getNotaIngles(), super.getMediaSecundario(), this.getNivelNecessidade(), this.getIncapacidade());
    }

}