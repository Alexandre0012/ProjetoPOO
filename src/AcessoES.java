import java.io.*;
import java.util.*;


public class AcessoES
{
    public static void main(String[] args)
    {

        GestaoAcesso gestaoacesso = new GestaoAcesso();


        Scanner scanI = new Scanner(System.in);   //Integer scanner
        Scanner scanS = new Scanner(System.in);   //String scanner
        Scanner scanD = new Scanner(System.in);   //Double scanner

        Candidato c = null;

        int opc1=-1;  //opcao menu1
        int id;

        //Menu
        do
        {
            clearScreen();
            System.out.println("1. Registar Candidato");
            System.out.println("2. Registar Curso");
            System.out.println("3. ");
            System.out.println("4. Listar");
            System.out.println("0. EXIT");

            System.out.print("Escolha a sua opção: ");
            opc1 = scanI.nextInt();
            clearScreen();

            switch(opc1)
            {
                case 0:
                    System.out.print("Obrigado por usar a nossa aplicação!!\n");
                    System.exit(0);
                    break;

                case 1:
                    clearScreen();
                    System.out.println("** REGISTRO DE UM NOVO ALUNO **");

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

                    id = 0;

                    if(cReg == 1)
                    {
                        System.out.print("Introduza o código da Regiao Desfavorecida: ");
                        int cRegCode = scanI.nextInt();

                        AlunoRegioes areg = new AlunoRegioes(cNome, cGenero, cNotaA, cNotaB, cNotaIng, cNotaSec, cRegCode);
                        id = areg.getID();
                        gestaoacesso.addCandidato(areg.clone());
                    }

                    System.out.print("Aluno/a com necessidades especiais? ** 1-SIM || 2-NÃO **");
                    int cNesEsp = scanS.nextInt();

                    if(cNesEsp == 1)
                    {
                        System.out.print("Introduza o nível de necessidade: ");
                        int cNivelNecessidade = scanI.nextInt();

                        System.out.print("Introduza o Tipo de Incapacidade (ex: Motora, sensorial): ");
                        String cTipoIncap = scanS.nextLine();

                        AlunoEspeciais ae = new AlunoEspeciais(cNome, cGenero, cNotaA, cNotaB, cNotaIng, cNotaSec, cNivelNecessidade, cTipoIncap);
                        id = ae.getID();
                        gestaoacesso.addCandidato(ae.clone());
                    }

                    AlunoRegular ar = new AlunoRegular(cNome, cGenero, cNotaA, cNotaB, cNotaIng, cNotaSec);
                    id = ar.getID();
                    gestaoacesso.addCandidato(ar.clone());

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




                    break;

                case 3:

                    break;

                case 4:
                    System.out.println("Id: ");
                    aux = scanI.nextInt();

                    boolean check = false;
                    for(Candidato c1: GestaoAcesso.getCandidato()){
                        if(aux == c1.getID()){
                            check = true;
                            System.out.println('\n'+ c1.toString() +'\n');
                        }else{
                            check = false;
                            System.out.println("Id inválido!! ");
                        }
                    }

                    break;

                default: System.out.println("Escolha uma opção válida!\n");
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