public class AlunoRegioes extends Candidato
{
    private int codigo_regiao;      //código da região.

    //Construtor 2
    public AlunoRegioes(String n, String g, int id, int nA, int nB, int nI, int mS, int cR)
    {
        super(n,g,id,nA,nB,nI,mS);
        this.codigo_regiao = cR;
    }

    public int getCodigoRegiao(){ return this.codigo_regiao; }

    public AlunoRegioes clone()
    {
        return new AlunoRegioes(super.getNome(), super.getGenero(), super.getID(),super.getNotaA(),
                super.getNotaB(), super.getNotaIngles(), super.getMediaSecundario(), this.getCodigoRegiao());
    }

}