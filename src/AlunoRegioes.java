public class AlunoRegioes extends Candidato
{
    private int codigo_regiao;      //código da região.
    private int bonus;

    //Construtor 2
    public AlunoRegioes(String n, String g, int id, int nA, int nB, int nI, int mS, int b, int cR)
    {
        super(n,g,id,nA,nB,nI,mS,b);
        this.codigo_regiao = cR;
    }

    public int getBonus(){ return this.bonus; }
    public int getCodigoRegiao(){ return this.codigo_regiao; }

    public AlunoRegioes clone()
    {
        return new AlunoRegioes(super.getNome(), super.getGenero(), super.getID(),super.getNotaA(),
                super.getNotaB(), super.getNotaIngles(), super.getMediaSecundario(), super.getBonus(), this.getCodigoRegiao());
    }

}