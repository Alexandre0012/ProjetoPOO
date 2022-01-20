import java.io.*;
import java.util.*;

public class GestaoAcesso
{
    private static ArrayList<Candidato> candidatos;   //lista de todos os candidatos
    private static ArrayList<Curso> curso;            //lista de todos os cursos
    private static HashMap<Candidato, ArrayList<Curso>> ListadeCandidatos;
    private static HashMap<Curso, TreeSet<Candidato>> ListadeCursos;


    public GestaoAcesso()
    {
        curso = new ArrayList<>();
        candidatos = new ArrayList<>();
        ListadeCandidatos = new HashMap<>();
        ListadeCursos = new HashMap<>();
    }

    public static List<Curso> getCurso() { return curso; }
    public static List<Candidato> getCandidatos() { return candidatos; }
    public static HashMap<Candidato,ArrayList<Curso>> getListadeCandidatos() { return ListadeCandidatos; }
    public static HashMap<Curso, TreeSet<Candidato>> getListadeCursos() { return ListadeCursos; }

    public List<Curso> getListaCurso()
    {
        ArrayList<Curso> temp = new ArrayList<Curso>();
        for(Curso c: curso)
            temp.add(c);
        return temp;
    }

    public List<Candidato> getListaCandidato()
    {
        ArrayList<Candidato> temp = new ArrayList<>();
        for(Candidato c: candidatos)
            temp.add(c);
        return temp;
    }

    public HashMap<Candidato, ArrayList<Curso>> getListaCandidatos()
    {
        HashMap<Candidato, ArrayList<Curso>> temp = new  HashMap<>();
        for(Candidato c: candidatos){
            temp.put(c, c.getCursoDoCandidato());
        }
        return temp;
    }

    public HashMap<Curso, TreeSet<Candidato>> getListaCursos()
    {
        HashMap<Curso, TreeSet<Candidato>> temp = new  HashMap<>();
        for(Curso c: curso){
            temp.put(c, c.getListaColocados());
        }
        return temp;
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

    public void addListaCandidato(Candidato c,ArrayList<Curso> l)
    {
        if(c != null){
            ListadeCandidatos.put(c,l);
        }
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

    public void removeCandidatoDaListaDoCurso(Candidato candidato, Curso curso){
        for(Curso cc: ListadeCursos.keySet()){
            TreeSet<Candidato> temp = ListadeCursos.get(cc);
            if(cc.equals(curso)){
                for(Candidato c: temp){
                    if(c.equals(candidato)){
                        temp.remove(candidato);
                    }
                }
            }
        }
    }

    public boolean candidatoExiste(int x){
        for(Candidato c: candidatos){
            if(c.getID() == x) return true;
        }
        return false;
    }

    public void adicionaEscolha(Candidato candidato, int opc){
        int i = 1;
        for(Curso c: curso){
            if(i == opc){
                candidato.addCursoAoCandidato(c.clone());
                candidato.adicionaCursoaSuaLista(c);
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

    public boolean verificaColocacao(Candidato c, Curso cc){
        /*int i = 1;
        Iterator<Candidato> temp = cc.ListaColocados.iterator();

        while (temp.hasNext()){
            System.out.println("cheguei aqui");
            Candidato candidato = temp.next();
            if(i <= this.getNum()){
                System.out.println("cheguei aqui2");
                if(candidato == c) return true;
            }else return false;
            i++;
        }
        return false;*/

        int i = 0;
        for(Curso curso: ListadeCursos.keySet()){
            TreeSet<Candidato> temp = ListadeCursos.get(curso);
            Iterator<Candidato> iterator = temp.iterator();
            System.out.println("aqui  " + curso.toString() + cc.toString());
            if(curso.equals(cc)){
                System.out.println("llllll");
                while (iterator.hasNext()){
                    Candidato candidato = iterator.next();
                    System.out.println(candidato + "\n" + curso.getNum());
                    i++;
                    if(i <= curso.getNum()){
                        System.out.println("ali");
                        if(candidato.equals(c)) return true;
                    }
                }
                i=0;
            }
        }

        /*for(Candidato candidato: cc.getListaColocados()){
            i++;
            if(i <= cc.getNum()){              //cc.getNum()
                if(candidato == c) return true;
            }
        }*/
        return false;
    }

    public void retiraCandidatosDasOpcoes(Candidato candidato, int pos){
        int i = 0;
        for(Candidato c: ListadeCandidatos.keySet()){
            ArrayList<Curso> temp = ListadeCandidatos.get(c);
            if(c.equals(candidato)){
                for(Curso curso: temp){
                    i++;
                    if(i != pos){
                        curso.remove(candidato);
                        removeCandidatoDaListaDoCurso(candidato,curso);
                        System.out.println("cheguei retira1");
                    }
                    else System.out.println("cheguei retira2"); candidato.setAprovado();
                }
                i=0;
            }

        }
    }

    public void aprovacao(){
        int pos = 1;
        for(Candidato candidato: candidatos){
            //candidato.showListaCursosDoCandidato();
            for(Curso curso: candidato.getCursoDoCandidato()){
                //System.out.println("tou2" + curso.getListaColocados());
                //curso.showListaColocados();
                if(verificaColocacao(candidato, curso)){
                    System.out.println("tou3");
                    retiraCandidatosDasOpcoes(candidato,pos);
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

        ar1.addCursoAoCandidato(eng1.clone());ar1.addCursoAoCandidato(eng2.clone());ListadeCandidatos.put(ar1.clone(), ar1.getCursoDoCandidato());
        ar2.addCursoAoCandidato(eng1.clone());ar2.addCursoAoCandidato(eng2.clone());ListadeCandidatos.put(ar2.clone(), ar2.getCursoDoCandidato());
        ar3.addCursoAoCandidato(eng1.clone());ar3.addCursoAoCandidato(eng2.clone());ListadeCandidatos.put(ar3.clone(), ar3.getCursoDoCandidato());
        //addTodosCandidatosTodososCursos();
        eng1.addCandidatoColocado(ar1.clone());eng1.addCandidatoColocado(ar2.clone());eng1.addCandidatoColocado(ar3.clone());ListadeCursos.put(eng1.clone(),eng1.getListaColocados());
        eng2.addCandidatoColocado(ar1.clone());eng2.addCandidatoColocado(ar2.clone());eng2.addCandidatoColocado(ar3.clone());ListadeCursos.put(eng2.clone(),eng2.getListaColocados());

        //aprovacao();
        int pos = 1;
        for(Candidato candidato: ListadeCandidatos.keySet()){
            ArrayList<Curso> temp = ListadeCandidatos.get(candidato);
            for(Curso cc: temp){
                System.out.println(cc);
                if(verificaColocacao(candidato, cc)){
                    System.out.println("tou 3");
                    retiraCandidatosDasOpcoes(candidato, pos);
                }
                else System.out.println("tou 4");cc.remove(candidato);
                pos++;
            }
            pos = 1;
        }
        eng1.showListaColocados();
        eng2.showListaColocados();

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
        File f = new File("candidatos.ser");
        File ff = new File("cursos.ser");

        if(f.exists()) {
            //Ler Ficheiro de dados dos candidatos
            try {

                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ArrayList<Candidato> can = (ArrayList<Candidato>) ois.readObject();

                for (Candidato cand : can)
                    candidatos.add(cand.clone());

                System.out.println(can);
                ois.close();
            } catch (IOException E) {
                System.out.println("Erro na leitura dos dados dos candidatos!");
                E.printStackTrace();
            } catch (ClassNotFoundException C) {
                System.out.println("Classe não encontrada.");
                C.printStackTrace();
            }
        }

        /*if (ff.exists()) {
            try {

                FileInputStream fis2 = new FileInputStream(ff);
                ObjectInputStream ois2 = new ObjectInputStream(fis2);
                ArrayList<Curso> curso1 = (ArrayList<Curso>) ois2.readObject();

                for (Curso cur : curso1)
                    curso.add(cur.clone());

                ois2.close();
            } catch (IOException E) {
                System.out.println("Erro na leitura dos dados dos candidatos!");
                E.printStackTrace();
            } catch (ClassNotFoundException C) {
                System.out.println("Classe não encontrada.");
                C.printStackTrace();
            }
        }*/
    }

    public void guardaFicheiro(){
        try{
            File fc = new File("candidatos.ser");
            if (!fc.exists()){
                fc.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(fc);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(candidatos);
            out.flush();
            out.close();
            fos.close();
        }catch (IOException E){
            System.out.println("Erro no Output dos dados de candidato.");
            E.printStackTrace();
        }


        /*try{
            File fc2 = new File("cursos.ser");
            if (!fc2.exists()){
                fc2.createNewFile();
            }
            FileOutputStream fos2 = new FileOutputStream(fc2);
            ObjectOutputStream out2 = new ObjectOutputStream(fos2);
            out2.writeObject(curso);
            out2.flush();
            out2.close();
            fos2.close();
        }catch (IOException E){
            System.out.println("Erro no Output dos dados dos cursos.");
            E.printStackTrace();
        }*/
    }

}