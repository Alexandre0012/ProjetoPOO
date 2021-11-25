public class AlunoEspeciais extends Candidato
{
    private int nivel_necessidade;      //Entre 0 a 100
    private String incapacidade;        //tipo de incapacidade (motora, sensorial, outra)



    public AlunoEspeciais()
    {
        super();
        setBonus(5);
    }


    public AlunoEspeciais(String n, String g, int nA, int nB, int nI, int mS, int nC, String inc){
        super(n,g,nA,nB,nI,mS);
        this.nivel_necessidade = nC;
        this.incapacidade = inc;
    }

    public AlunoEspeciais(Candidato c)
    {
        super(c);
        setBonus(5);
    }

    //Métodos
    private int getNivelNecessidade(){ return this.nivel_necessidade; }
    private String getIncapacidade(){ return this.incapacidade; }

    public AlunoEspeciais clone()
    {
        return new AlunoEspeciais(this);
    }

}