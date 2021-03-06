import java.util.HashMap;

public class AlunoRegular extends Candidato
{

    public AlunoRegular(String n, String g, int id, int nA, int nB, int nI, int mS, int b){
        super(n,g,id,nA,nB,nI,mS,b);
    }

    public AlunoRegular clone()
    {
        AlunoRegular temp = new AlunoRegular(super.getNome(), super.getGenero(), super.getID(), super.getNotaA(),
                super.getNotaB(), super.getNotaIngles(), super.getMediaSecundario(), super.getBonus());
        for(Curso c: super.getCursoDoCandidato())
            temp.addCursoAoCandidato(c);

        return temp;
    }

}