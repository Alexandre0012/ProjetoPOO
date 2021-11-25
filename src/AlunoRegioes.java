public class AlunoRegioes extends Candidato
{
    private int codigo_regiao;      //código da região.


    //Construtor 1
    public AlunoRegioes()
    {
        super();
        setBonus(2);
    }

    //Construtor 2
    public AlunoRegioes(String n, String g, int nA, int nB, int nI, int mS, int cR)
    {
        super(n,g,nA,nB,nI,mS);
        this.codigo_regiao = cR;
        setBonus(2);
    }

    //Construtor 3
    public AlunoRegioes(Candidato c)
    {
        super(c);
        setBonus(2);
    }

    public int getCodigoRegiao(){ return this.codigo_regiao; }

    public AlunoRegioes clone()
    {
        return new AlunoRegioes(this);
    }

}