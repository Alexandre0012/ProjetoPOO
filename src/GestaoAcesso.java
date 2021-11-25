import java.util.*;

public class GestaoAcesso
{
    private ArrayList<Candidato> candidato;


    public GestaoAcesso()
    {
        this.candidato = new ArrayList<Candidato>();
    }

    public List<Candidato> getCandidato() { return candidato; }

    //Adiciona Candidatos 
    public void addCandidato(Candidato c)
    {
        if(c != null)
            candidato.add(c.clone());
    }





}