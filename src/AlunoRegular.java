import java.util.HashMap;

public class AlunoRegular extends Candidato
{

    public AlunoRegular(String n, String g, int id, int nA, int nB, int nI, int mS){
        super(n,g,id,nA,nB,nI,mS);
    }

    /*public HashMap<Double, Curso>candidatura(int id, Curso a, Curso b, Curso c, Curso d, Curso e){

        GestaoAcesso gestaoacesso = new GestaoAcesso();

        for(Candidato x: gestaoacesso.){}
        HashMap<Double, Curso>temp = new HashMap<>();

        temp.put(a.calcmedia(cc), a);
        temp.put(b.calcmedia(cc), b);
        temp.put(c.calcmedia(cc), c);
        temp.put(d.calcmedia(cc), d);
        temp.put(e.calcmedia(cc), e);

        return temp;
    }*/

    public AlunoRegular clone()
    {
        return new AlunoRegular(super.getNome(), super.getGenero(), super.getID(), super.getNotaA(),
                super.getNotaB(), super.getNotaIngles(), super.getMediaSecundario());
    }

}