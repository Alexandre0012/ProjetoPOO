public class AlunoRegular extends Candidato
{

    public AlunoRegular(){
        super();
    }

    public AlunoRegular(String n, String g, int nA, int nB, int nI, int mS){
        super(n,g,nA,nB,nI,mS);
    }

    public AlunoRegular(Candidato c){
        super(c);
    }

    public AlunoRegular clone()
    {
        return new AlunoRegular(this);
    }

}