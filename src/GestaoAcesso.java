import java.io.*;
import java.util.*;

public class GestaoAcesso
{
    private HashMap<Integer, Candidato> listaCandidatos;
    private HashMap<Integer, Curso> listaCursos;
    private static ArrayList<Candidato> candidatos;   //lista de todos os candidatos
    private static ArrayList<Curso> curso;            //lista de todos os cursos


    public GestaoAcesso()
    {
        this.listaCandidatos= new HashMap<Integer, Candidato>();
        this.listaCursos = new HashMap<Integer, Curso>();
        this.curso = new ArrayList<Curso>();
        this.candidatos = new ArrayList<Candidato>();
    }

    public static List<Curso> getCurso() { return curso; }
    public static List<Candidato> getCandidatos() { return candidatos; }

    public List<Curso> getListaCurso()
    {
        ArrayList<Curso> temp = new ArrayList<Curso>();
        for(Curso c: curso)
            temp.add(c);
        return temp;
    }

    public List<Candidato> getListaCandidato()
    {
        ArrayList<Candidato> temp = new ArrayList<Candidato>();
        for(Candidato c: candidatos)
            temp.add(c);
        return temp;
    }

    public void novoCandidato(int id, Candidato novo){
        this.listaCandidatos.put(id, novo.clone());
    }

    public void novoCurso(int id, Curso novo){
        this.listaCursos.put(id, novo.clone());
    }

    public void addCurso(Curso c)
    {
        if(c != null)
            curso.add(c.clone());
    }

    public void addCandidato(Candidato c)
    {
        if(c != null)
            candidatos.add(c.clone());
    }

    public void showCursos(){
        int i = 1;
        for(Curso c: curso){
            System.out.println(i + ":" + "Nome: " + c.getNome() + "Universidade: " + c.getUni());
            i++;
        }
    }

    public void showCandidatos(){
        for(Candidato c: candidatos){
            System.out.println(c.getNome());
            c.showListaCursosDoCandidato();
        }
    }

    public boolean candidatoExiste(int id){
        return this.listaCandidatos.containsKey(id);
    }

    public void adicionaEscolha(Candidato candidato, int opc){
        int i = 1;
        for(Curso c: curso){
            if(i == opc){
                candidato.addCursoAoCandidato(c.clone());
            }
            i++;
        }
    }

    public void addTodosCandidatosTodososCursos(){
        for(Candidato candidato: candidatos){
            for(Curso curso: candidato.getCursoDoCandidato()){
                curso.addCandidatoColocado(candidato);
            }
        }
    }

    public void aprovacao(){
        int pos = 1;
        for(Candidato candidato: candidatos){
            System.out.println("tou");
            for(Curso curso: candidato.getCursoDoCandidato()){
                System.out.println("tou2");
                if(curso.verificaColocacao(candidato)){
                    System.out.println("tou3");
                    candidato.retiraCandidatosDasOpcoes(candidato, pos);
                }
                pos++;
            }
            pos = 1;
        }
    }

    public void teste(){

        Engenharia eng1 = new Engenharia("Eng1", "minho", 2);
        Engenharia eng2 = new Engenharia("Eng2", "faro", 2);

        AlunoRegular ar1 = new AlunoRegular("cesar", "male", 7, 100, 100, 100, 100, 20);

        AlunoRegular ar2 = new AlunoRegular("alex", "female", 8, 100, 100, 100, 100, 50);

        AlunoRegular ar3 = new AlunoRegular("rica", "undefined", 9, 140, 140, 140, 140, 0);

        ar1.addCursoAoCandidato(eng1);ar1.addCursoAoCandidato(eng2);candidatos.add(ar1);
        ar2.addCursoAoCandidato(eng1);ar2.addCursoAoCandidato(eng2);candidatos.add(ar2);
        ar3.addCursoAoCandidato(eng1);ar3.addCursoAoCandidato(eng2);candidatos.add(ar3);
        //addTodosCandidatosTodososCursos();
        eng1.addCandidatoColocado(ar1);eng1.addCandidatoColocado(ar2);eng1.addCandidatoColocado(ar3);
        eng2.addCandidatoColocado(ar1);eng2.addCandidatoColocado(ar2);eng2.addCandidatoColocado(ar3);
        aprovacao();
        showCandidatos();
        eng1.show();
        eng2.show();

    }

    public void mostraColocacaoDoCandidato(Candidato c){

        for(Curso curso: c.getCursoDoCandidato()){
            if(curso.existe(c)){
                 String str = curso.toString();
                 System.out.println(str);
            }
        }
    }


    public void mostraResultadoCandidatura(int id){

        for(Candidato candidato: candidatos){
            if(candidato.getID() == id){
                if(candidato.getAprovado()){
                    System.out.println("COLOCADO");
                    mostraColocacaoDoCandidato(candidato);
                }
                else System.out.println("NAO COLOCADO");
            }
        }
    }


    public void lerFicheiro(){

        //Ler Ficheiro de dados dos candidatos
        try{
            File f = new File("candidatos.ser");
            if (!f.exists())
                return;
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaCandidatos =(HashMap) ois.readObject();
            ois.close();
            fis.close();
        }catch (IOException E) {
            System.out.println("Erro na leitura dos dados dos candidatos!");
            E.printStackTrace();
        }catch (ClassNotFoundException C) {
            System.out.println("Classe não encontrada.");
            C.printStackTrace();
        }

        //Ler Ficheiro de dados dos cursos
        try{
            File fC = new File("cursos.ser");
            if (!fC.exists())
                return;

            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(fC));
            listaCursos = (HashMap) ois2.readObject();
            ois2.close();

        }catch (IOException E) {
            System.out.println("Erro na leitura dos dados dos cursos!");
            E.printStackTrace();
        }catch (ClassNotFoundException C) {
            System.out.println("Classe não encontrada.");
            C.printStackTrace();
        }

    }

    public void guardaFicheiro(){
        try{
            File ff = new File("candidatos.ser");
            if (!ff.exists()){
                ff.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(ff);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(listaCandidatos);
            out.flush();
            out.close();
            fos.close();
        }catch (IOException E){
            System.out.println("Erro no Output dos dados de candidato.");
        }


        try{
            File ffC = new File("cursos.ser");
            if (!ffC.exists()){
                ffC.createNewFile();
            }
            FileOutputStream fos2 = new FileOutputStream(ffC);
            ObjectOutputStream out = new ObjectOutputStream(fos2);
            out.writeObject(listaCursos);
            out.flush();
            out.close();
            fos2.close();
        }catch (IOException E){
            System.out.println("Erro no Output dos dados dos cursos.");
        }
    }






}