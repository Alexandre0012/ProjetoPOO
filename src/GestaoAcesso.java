import java.io.*;
import java.util.*;

public class GestaoAcesso
{
    //private static ArrayList<Candidato> candidato;
    private HashMap<Integer, Candidato> listaCandidatos = new HashMap<>();
    private HashMap<Integer, Curso> listaCursos = new HashMap<>();
    private static ArrayList<Curso> curso;
    //private ArrayList<> ListaCjuridicas;


    public GestaoAcesso()
    {
        //this.candidato = new ArrayList<Candidato>();
        this.listaCandidatos= new HashMap<Integer, Candidato>();
        this.listaCursos = new HashMap<Integer, Curso>();
        this.curso = new ArrayList<Curso>();
        //this.ListaCjuridicas = new ArrayList<Curso>();
    }

    //public static List<Candidato> getCandidato() { return candidato; }
    public static List<Curso> getCurso() { return curso; }

    /*Adiciona Candidatos
    public void addCandidato(Candidato c)
    {
        if(c != null)
            candidato.add(c.clone());
    }*/

    //Adiciona Cursos
    public void addCurso(Curso cur)
    {
        if(cur != null)
            curso.add(cur.clone());
    }

    public void novoCandidato(int id, Candidato novo){
        this.listaCandidatos.put(id, novo.clone());
    }

    public void novoCurso(int id, Curso novo){
        this.listaCursos.put(id, novo.clone());
    }

    public void ShowCursos(){
        int i = 1;
        for(Curso c: curso){
            System.out.println(i + ":" + "Nome: " + c.getNome() + "Universidade: " + c.getUni());
            i++;
        }
    }

    public boolean candidatoExiste(int id){
        if(this.listaCandidatos.containsKey(id)) return true;
        else return false;
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