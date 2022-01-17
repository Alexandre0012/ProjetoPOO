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
        int opccurso = -1; //opcao curso
        int idd=0, idcurso=0;


        //Menu
        do {
            clearScreen();
            System.out.println("1. Registar Candidato");
            System.out.println("2. Registar Curso");
            System.out.println("3. Registar Candidatura");
            System.out.println("4. Mostrar Resultado da Candidatura");
            System.out.println("5. Listar");
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

                        AlunoRegioes areg = new AlunoRegioes(cNome, cGenero, cNotaA, cNotaB, cNotaIng, cNotaSec, cRegCode);
                        idd = areg.getID();
                        gestaoacesso.novoCandidato(idd, areg.clone());
                    }

                    System.out.print("Aluno/a com necessidades especiais? ** 1-SIM || 2-NÃO **");
                    int cNesEsp = scanS.nextInt();

                    if (cNesEsp == 1) {
                        System.out.print("Introduza o nível de necessidade: ");
                        int cNivelNecessidade = scanI.nextInt();

                        System.out.print("Introduza o Tipo de Incapacidade (ex: Motora, sensorial, visual): ");
                        String cTipoIncap = scanS.nextLine();

                        AlunoEspeciais ae = new AlunoEspeciais(cNome, cGenero, cNotaA, cNotaB, cNotaIng, cNotaSec, cNivelNecessidade, cTipoIncap);
                        idd = ae.getID();
                        gestaoacesso.novoCandidato(idd, ae.clone());
                    }

                    AlunoRegular ar = new AlunoRegular(cNome, cGenero, cNotaA, cNotaB, cNotaIng, cNotaSec);
                    idd = ar.getID();
                    gestaoacesso.novoCandidato(idd,ar.clone());
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

                    opccurso = scanI.nextInt();

                    if (opccurso == 1) {
                        Biociencias bio = new Biociencias(NomeUni, NomeCurso, NumClaus);
                        gestaoacesso.novoCurso(idcurso, bio.clone());
                        break;
                    }
                    if (opccurso == 2) {
                        Ciencias cie = new Ciencias(NomeUni, NomeCurso, NumClaus);
                        gestaoacesso.novoCurso(idcurso, cie.clone());
                        break;
                    }
                    if (opccurso == 3) {
                        CJuridicas juri = new CJuridicas(NomeUni, NomeCurso, NumClaus);
                        gestaoacesso.novoCurso(idcurso, juri.clone());
                        break;
                    }
                    if (opccurso == 4) {
                        Engenharia eng = new Engenharia(NomeUni, NomeCurso, NumClaus);
                        gestaoacesso.novoCurso(idcurso, eng.clone());
                        break;
                    }
                    if (opccurso == 5) {
                        Humanidades hum = new Humanidades(NomeUni, NomeCurso, NumClaus);
                        gestaoacesso.novoCurso(idcurso, hum.clone());
                        break;
                    }

                case 3:

                   break;

                case 4:
                    break;

                case 5:
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
                                break;

                            case 2:
                                break;

                        }


                    } while (opc2 != 5);

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