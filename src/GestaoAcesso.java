import java.io.*;
import java.util.*;
import java.util.spi.CalendarNameProvider;

public class GestaoAcesso implements Serializable
{
    private static ArrayList<Candidato> candidatos;   //lista de todos os candidatos
    private static ArrayList<Curso> curso;            //lista de todos os cursos
    private static HashMap<Candidato, ArrayList<Curso>> ListadeCandidatos;   //map com todos os candidatos e respetiva lista de cursos
    private static HashMap<Curso, TreeSet<Candidato>> ListadeCursos;         //map com todos os cursos e respetiva lista de candidatos


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

    public void addListaCurso(Curso c,TreeSet<Candidato> l)
    {
        if(c != null){
            ListadeCursos.put(c,l);
        }
    }

    public void escolheCurso(Candidato candidato, int opc){
        int i = 0;
        for(Curso curso: ListadeCursos.keySet()){
            if(i == opc){
                adicionaCursoAoCandidato(candidato, curso);
                adicionaCandidatoAoCurso(candidato,curso);
            }
        }
    }

    public void showCursos(){
        int i = 1;
        for(Curso c: ListadeCursos.keySet()){
            System.out.println(i + ":" + "Nome: " + c.getNome() + "Universidade: " + c.getUni());
            i++;
        }
    }

    public void showCandidatos(){
        for(Candidato c: ListadeCandidatos.keySet()){
            System.out.println(c.getNome());
        }
    }

    public void showColocados(){
        for(Curso cc: ListadeCursos.keySet()){
            TreeSet<Candidato> temp = ListadeCursos.get(cc);
            System.out.println(cc.toString());
            for(Candidato c: temp){
                System.out.println("Nome: " + c.getNome()
                            + "   Media: " + cc.calcmedia(c));
            }

        }
    }

    public void adicionaCursoAoCandidato(Candidato candidato, Curso curso){
        for(Candidato c: ListadeCandidatos.keySet()){
            ArrayList<Curso> temp = ListadeCandidatos.get(c);
            if(c.equals(candidato)) temp.add(curso);
        }
    }

    public void adicionaCandidatoAoCurso(Candidato candidato, Curso curso){
        for(Curso cc: ListadeCursos.keySet()){
            TreeSet<Candidato> temp = ListadeCursos.get(cc);
            if(cc.equals(curso)) temp.add(candidato);
        }
    }

    public void removeCandidatoDaListaDoCurso(Candidato candidato, Curso curso){
        for(Curso cc: ListadeCursos.keySet()){
            TreeSet<Candidato> temp = ListadeCursos.get(cc);
            if(cc.equals(curso)){
                temp.remove(candidato);
            }
        }
    }

    public boolean candidatoExiste(int x){
        for(Candidato c: ListadeCandidatos.keySet()){
            if(c.getID() == x) return true;
        }
        return false;
    }

    public boolean candidatoExisteNoCurso(Candidato candidato){
        for(Curso cc: ListadeCursos.keySet()){
            TreeSet<Candidato> temp = ListadeCursos.get(cc);
            if(temp.contains(candidato)) return true;
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

    public boolean verificaColocacao(Candidato c, Curso cc){
        int i = 0;
        for(Curso curso: ListadeCursos.keySet()){
            TreeSet<Candidato> temp = ListadeCursos.get(curso);
            Iterator<Candidato> iterator = temp.iterator();
            if(curso.equals(cc)){
                while (iterator.hasNext()){
                    Candidato candidato = iterator.next();
                    i++;
                    if(i <= curso.getNum()){
                        if(candidato.equals(c)) return true;
                    }
                }
                i=0;
            }
        }
        return false;
    }

    public void retiraCandidatosDasOpcoes(Candidato candidato, int pos){
        int i = 0;
        for(Candidato c: ListadeCandidatos.keySet()){
            ArrayList<Curso> temp = ListadeCandidatos.get(c);
            if(c.equals(candidato)){
                for(Curso curso: temp){
                    i++;
                    if(i > pos){
                        removeCandidatoDaListaDoCurso(candidato,curso);
                    }
                    if(i == pos)
                        candidato.setAprovado();
                }
                i=0;
            }

        }
    }

    public void aprovacao(){
        int pos = 1;
        for(Candidato candidato: ListadeCandidatos.keySet()){
            ArrayList<Curso> temp = ListadeCandidatos.get(candidato);
            for(Curso cc: temp){
                if(verificaColocacao(candidato, cc)){
                    retiraCandidatosDasOpcoes(candidato, pos);
                }
                else
                    removeCandidatoDaListaDoCurso(candidato, cc);

                pos++;
            }
            pos = 1;
        }
    }

    public void teste(){

        Engenharia eng1 = new Engenharia("Eng1", "minho", 2);
        Engenharia eng2 = new Engenharia("Eng2", "faro", 2);
        Engenharia eng3 = new Engenharia("Eng3", "porto", 2);
        Engenharia eng4 = new Engenharia("Eng4", "lisboa", 2);
        Engenharia eng5 = new Engenharia("Eng5", "coimbra", 2);

        AlunoRegular ar1 = new AlunoRegular("cesar", "male", 7, 100, 100, 100, 100, 20);
        AlunoRegular ar2 = new AlunoRegular("alex", "female", 8, 100, 100, 100, 100, 50);
        AlunoRegular ar3 = new AlunoRegular("rica", "undefined", 9, 140, 140, 140, 140, 0);
        AlunoRegular ar4 = new AlunoRegular("rato", "undefined", 10, 190, 190, 190, 190, 0);
        AlunoRegular ar5 = new AlunoRegular("ze", "female", 11, 110, 110, 110, 110, 0);

        ar1.addCursoAoCandidato(eng3.clone());ar1.addCursoAoCandidato(eng1.clone());
        ar1.addCursoAoCandidato(eng2.clone());ar1.addCursoAoCandidato(eng5.clone());
        ar1.addCursoAoCandidato(eng4.clone());ListadeCandidatos.put(ar1.clone(), ar1.getCursoDoCandidato());

        ar2.addCursoAoCandidato(eng5.clone());ar2.addCursoAoCandidato(eng4.clone());
        ar2.addCursoAoCandidato(eng1.clone());ar2.addCursoAoCandidato(eng3.clone());
        ar2.addCursoAoCandidato(eng2.clone());ListadeCandidatos.put(ar2.clone(), ar2.getCursoDoCandidato());

        ar3.addCursoAoCandidato(eng2.clone());ar3.addCursoAoCandidato(eng1.clone());
        ar3.addCursoAoCandidato(eng3.clone());ar3.addCursoAoCandidato(eng5.clone());
        ar3.addCursoAoCandidato(eng4.clone());ListadeCandidatos.put(ar3.clone(), ar3.getCursoDoCandidato());

        ar4.addCursoAoCandidato(eng1.clone());ar4.addCursoAoCandidato(eng2.clone());
        ar4.addCursoAoCandidato(eng3.clone());ar4.addCursoAoCandidato(eng4.clone());
        ar4.addCursoAoCandidato(eng5.clone());ListadeCandidatos.put(ar4.clone(), ar4.getCursoDoCandidato());

        ar5.addCursoAoCandidato(eng4.clone());ar5.addCursoAoCandidato(eng1.clone());
        ar5.addCursoAoCandidato(eng5.clone());ar5.addCursoAoCandidato(eng3.clone());
        ar5.addCursoAoCandidato(eng2.clone());ListadeCandidatos.put(ar5.clone(), ar5.getCursoDoCandidato());

        eng1.addCandidatoColocado(ar1.clone());eng1.addCandidatoColocado(ar2.clone());eng1.addCandidatoColocado(ar3.clone());
        eng1.addCandidatoColocado(ar4.clone());eng1.addCandidatoColocado(ar5.clone());ListadeCursos.put(eng1.clone(),eng1.getListaColocados());

        eng2.addCandidatoColocado(ar1.clone());eng2.addCandidatoColocado(ar2.clone());eng2.addCandidatoColocado(ar3.clone());
        eng2.addCandidatoColocado(ar4.clone());eng2.addCandidatoColocado(ar5.clone());ListadeCursos.put(eng2.clone(),eng2.getListaColocados());

        eng3.addCandidatoColocado(ar1.clone());eng3.addCandidatoColocado(ar2.clone());eng3.addCandidatoColocado(ar3.clone());
        eng3.addCandidatoColocado(ar4.clone());eng3.addCandidatoColocado(ar5.clone());ListadeCursos.put(eng3.clone(),eng3.getListaColocados());

        eng4.addCandidatoColocado(ar1.clone());eng4.addCandidatoColocado(ar2.clone());eng4.addCandidatoColocado(ar3.clone());
        eng4.addCandidatoColocado(ar4.clone());eng4.addCandidatoColocado(ar5.clone());ListadeCursos.put(eng4.clone(),eng4.getListaColocados());

        eng5.addCandidatoColocado(ar1.clone());eng5.addCandidatoColocado(ar2.clone());eng5.addCandidatoColocado(ar3.clone());
        eng5.addCandidatoColocado(ar4.clone());eng5.addCandidatoColocado(ar5.clone());ListadeCursos.put(eng5.clone(),eng5.getListaColocados());

    }

    public void mostraResultadoCandidatura(int id){

        for(Candidato candidato: ListadeCandidatos.keySet()){
            ArrayList<Curso> temp = ListadeCandidatos.get(candidato);
            if(candidato.getID() == id){
                for(Curso c: temp){
                    if(candidatoExisteNoCurso(candidato)){
                        System.out.println("Colocado em: " + c);
                    }
                }
            }
        }
    }


    /*public void lerFicheiro() {
        File f = new File("candidatos.ser");
        File ff = new File("cursos.ser");

        if (f.exists()) {
            //Ler Ficheiro de dados dos candidatos
            try {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                HashMap<Candidato, ArrayList<Curso>> can = (HashMap<Candidato, ArrayList<Curso>>) ois.readObject();
                for(Candidato c: can.keySet()){
                    ArrayList<Curso> temp = can.get(c);
                    ListadeCandidatos.put(c, temp);
                }
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

        if (ff.exists()) {
            //Ler Ficheiro de dados dos candidatos
            try {
                FileInputStream fis2 = new FileInputStream(ff);
                ObjectInputStream ois2 = new ObjectInputStream(fis2);
                HashMap<Curso, TreeSet<Candidato>> can = (HashMap<Curso, TreeSet<Candidato>>) ois2.readObject();
                for(Curso c: can.keySet()){
                    TreeSet<Candidato> temp = can.get(c);
                    ListadeCursos.put(c, temp);
                }
                System.out.println(can);
                ois2.close();
            } catch (IOException E) {
                System.out.println("Erro na leitura dos dados dos candidatos!");
                E.printStackTrace();
            } catch (ClassNotFoundException C) {
                System.out.println("Classe não encontrada.");
                C.printStackTrace();
            }
        }
    }

    public void guardaFicheiro() {
        try {
            File fc = new File("candidatos.ser");
            if (!fc.exists()) {
                fc.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(fc);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(ListadeCandidatos);
            out.flush();
            out.close();
            fos.close();
        } catch (IOException E) {
            System.out.println("Erro no Output dos dados de candidato.");
            E.printStackTrace();
        }


        try {
            File fc2 = new File("cursos.ser");
            if (!fc2.exists()) {
                fc2.createNewFile();
            }
            FileOutputStream fos2 = new FileOutputStream(fc2);
            ObjectOutputStream out2 = new ObjectOutputStream(fos2);
            out2.writeObject(ListadeCursos);
            out2.flush();
            out2.close();
            fos2.close();
        } catch (IOException E) {
            System.out.println("Erro no Output dos dados dos cursos.");
            E.printStackTrace();
        }

    }*/

}