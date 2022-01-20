import java.io.*;
import java.util.*;


public class AcessoES
{
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {

        GestaoAcesso gestaoacesso = new GestaoAcesso();

        Scanner scanI = new Scanner(System.in);   //Integer scanner
        Scanner scanS = new Scanner(System.in);   //String scanner

        //Candidato c = null;
        //Curso cur = null;

        //Map<Integer, Candidato> acesso=null;
        //List<Curso> acessocurso;

        int opc1 = -1, opc2 = -1;  //opcao menu1, menu2
        int opctipocurso = -1; //opcao curso
        int idd=0, idcurso=0;

        gestaoacesso.lerFicheiro();

        //Menu
        do {
            clearScreen();
            System.out.println("1. Registar Candidato");
            System.out.println("2. Registar Curso");
            System.out.println("3. Mostrar Resultado da Candidatura");
            System.out.println("4. Listar");
            System.out.println("0. EXIT");

            System.out.print("Escolha a sua opção: ");
            opc1 = scanI.nextInt();
            clearScreen();

            switch (opc1) {

                case 1:
                    clearScreen();
                    System.out.println("** REGISTRO DE UM NOVO ALUNO **");
                    idd++;

                    System.out.print("Nome: ");
                    String cNome = scanS.nextLine();

                    System.out.print("Género: ");
                    String cGenero = scanS.nextLine();

                    System.out.print("Nota Exame A: ");
                    int cNotaA = scanI.nextInt();

                    System.out.print("Nota Exame B: ");
                    int cNotaB = scanI.nextInt();

                    System.out.print("Nota Exame Inglês: ");
                    int cNotaIng = scanI.nextInt();

                    System.out.print("Media Secundário: ");
                    int cNotaSec = scanI.nextInt();

                    System.out.print("Aluno/a de Regiao Desfavorecida? ** 1-SIM || 2-NÃO **");
                    int cReg = scanS.nextInt();

                    if (cReg == 1) {
                        System.out.print("Introduza o código da Regiao Desfavorecida: ");
                        int cRegCode = scanI.nextInt();
                        int bonus = 20;

                        AlunoRegioes areg = new AlunoRegioes(cNome, cGenero, idd, cNotaA, cNotaB, cNotaIng, cNotaSec, bonus, cRegCode);
                        idd = areg.getID();
                        gestaoacesso.addCandidato(areg.clone());

                        System.out.println("** Lista de cursos: **");
                        gestaoacesso.showCursos();
                        int i = 0;
                        while(i < 5){
                            System.out.println("Escolha até 5 cursos");
                            int opcCurso = scanI.nextInt();
                            gestaoacesso.adicionaEscolha(areg.clone(), opcCurso);
                            i++;
                        }
                        gestaoacesso.addListaCandidato(areg.clone(),areg.getCursoDoCandidato());
                    }

                    System.out.print("Aluno/a com necessidades especiais? ** 1-SIM || 2-NÃO **");
                    int cNesEsp = scanS.nextInt();

                    if (cNesEsp == 1) {
                        System.out.print("Introduza o nível de necessidade: ");
                        int cNivelNecessidade = scanI.nextInt();

                        System.out.print("Introduza o Tipo de Incapacidade (ex: Motora, sensorial, visual): ");
                        String cTipoIncap = scanS.nextLine();
                        int bonus1 = 50;

                        AlunoEspeciais ae = new AlunoEspeciais(cNome, cGenero, idd, cNotaA, cNotaB, cNotaIng, cNotaSec, bonus1, cNivelNecessidade, cTipoIncap);
                        idd = ae.getID();
                        gestaoacesso.addCandidato(ae.clone());

                        System.out.println("** Lista de cursos: **");
                        gestaoacesso.showCursos();
                        int i = 0;
                        while(i < 5){
                            System.out.println("Escolha até 5 cursos");
                            int opcCurso = scanI.nextInt();
                            gestaoacesso.adicionaEscolha(ae.clone(), opcCurso);
                            i++;
                        }
                    }
                    if (cReg == 2 && cNesEsp == 2){
                        int bonus3 = 0;
                        AlunoRegular ar = new AlunoRegular(cNome, cGenero, idd, cNotaA, cNotaB, cNotaIng, cNotaSec, bonus3);
                        idd = ar.getID();
                        gestaoacesso.addCandidato(ar.clone());

                        System.out.println("** Lista de cursos: **");
                        gestaoacesso.showCursos();
                        int i = 0;
                        while(i < 5){
                            System.out.println("Escolha até 5 cursos");
                            int opcCurso = scanI.nextInt();
                            gestaoacesso.adicionaEscolha(ar.clone(), opcCurso);
                            i++;
                        }}

                    break;

                case 2:
                    clearScreen();
                    System.out.println("** REGISTRO DE UM NOVO CURSO **");

                    System.out.print("Universidade: ");
                    String NomeUni = scanS.nextLine();

                    System.out.print("Nome do Curso: ");
                    String NomeCurso = scanS.nextLine();

                    System.out.print("Numerus Clausus: ");
                    int NumClaus = scanI.nextInt();

                    System.out.println("Escolha o tipo de curso: ");

                    System.out.println("1 - BioCiências");
                    System.out.println("2 - Ciências");
                    System.out.println("3 - Ciências Jurídicas");
                    System.out.println("4 - Engenharias");
                    System.out.println("5 - Humanidades");

                    opctipocurso = scanI.nextInt();

                    if (opctipocurso == 1) {
                        Biociencias bio = new Biociencias(NomeUni, NomeCurso, NumClaus);
                        gestaoacesso.addCurso(bio.clone());
                        break;
                    }
                    if (opctipocurso == 2) {
                        Ciencias cie = new Ciencias(NomeUni, NomeCurso, NumClaus);
                        gestaoacesso.addCurso(cie.clone());
                        break;
                    }
                    if (opctipocurso == 3) {
                        CJuridicas juri = new CJuridicas(NomeUni, NomeCurso, NumClaus);
                        gestaoacesso.addCurso(juri.clone());
                        break;
                    }
                    if (opctipocurso == 4) {
                        Engenharia eng = new Engenharia(NomeUni, NomeCurso, NumClaus);
                        gestaoacesso.addCurso(eng.clone());
                        break;
                    }
                    if (opctipocurso == 5) {
                        Humanidades hum = new Humanidades(NomeUni, NomeCurso, NumClaus);
                        gestaoacesso.addCurso(hum.clone());
                        break;
                    }

                case 3:
                    clearScreen();
                    System.out.println("Introduza o seu id: ");
                    int id = scanI.nextInt();

                    while(!gestaoacesso.candidatoExiste(id)){
                        System.out.println("O candidato nao existe!");
                        System.out.println("Por favor introduza um id valido ");
                        id = scanI.nextInt();
                    }

                    gestaoacesso.mostraResultadoCandidatura(id);

                    /*System.out.println("Introduza a sua primeira escolha: ");
                    String nomeCan1 = scanS.nextLine();


                    System.out.println("Introduza a sua segunda escolha: ");
                    String nomeCan2 = scanS.nextLine();

                    System.out.println("Introduza a sua terceira escolha: ");
                    String nomeCan3 = scanS.nextLine();

                    System.out.println("Introduza a sua quarta escolha: ");
                    String nomeCan4 = scanS.nextLine();

                    System.out.println("Introduza a sua quinta escolha: ");
                    String nomeCan5 = scanS.nextLine();*/


                    break;

                case 4:
                    do {
                        clearScreen();
                        System.out.println("1. Listar Colocados");
                        System.out.println("2. Mostar Curso com média mais alta");
                        System.out.println("3. Mostrar Curso com média mais baixa");
                        System.out.println("4. Listar alunos colocados 1ªopção");
                        System.out.println("5. Listar curso colocados 1ªopção");
                        System.out.println("0. Voltar ao Menu Anterior");

                        System.out.print("Escolha a sua opção: ");
                        opc2 = scanI.nextInt();
                        clearScreen();

                        switch (opc2) {
                            case 1:
                                gestaoacesso.teste();
                                for(Curso curso: gestaoacesso.getListaCurso()){
                                    //gestaoacesso.aprovacao();
                                    curso.showListaColocados();
                                }

                                break;

                            case 2:
                                break;

                        }


                    } while (opc2 != 5);

                    break;

                case 5:
                    //gestaoacesso.addTodosCandidatosTodososCursos();
                    //gestaoacesso.teste();

                    break;
                case 0:
                    System.out.print("Obrigado por usar a nossa aplicação!!\n");
                    gestaoacesso.guardaFicheiro();

                    break;

                default:
                    System.out.println("Escolha uma opção válida!\n");

            }

        }while(opc1 != 0);
    }


    //Função que Limpa a Linha de comandos
    public static void clearScreen(){
        try{
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else{
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }
        catch (Exception ex) {}
    }


}