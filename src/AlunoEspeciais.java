public class AlunoEspeciais extends Candidato
{
    private int bonus;
    private int nivel_necessidade;      //Entre 0 a 100
    private String incapacidade;        //tipo de incapacidade (motora, sensorial, outra)

    public AlunoEspeciais(String n, String g, int id, int nA, int nB, int nI, int mS, int b, int nC, String inc){
        super(n,g,id,nA,nB,nI,mS,b);
        this.nivel_necessidade = nC;
        this.incapacidade = inc;
    }

    //Métodos
    public int getBonus(){ return this.bonus; }
    private int getNivelNecessidade(){ return this.nivel_necessidade; }
    private String getIncapacidade(){ return this.incapacidade; }

    public AlunoEspeciais clone() {
        AlunoEspeciais temp = new AlunoEspeciais(super.getNome(), super.getGenero(), super.getID(), super.getNotaA(),
                super.getNotaB(), super.getNotaIngles(), super.getMediaSecundario(), super.getBonus(), this.getNivelNecessidade(), this.getIncapacidade());
        for(Curso c: super.getCursoDoCandidato())
            temp.addCursoAoCandidato(c);

        return temp;
    }

}