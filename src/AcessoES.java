import java.io.*;
import java.util.*;


public class AcessoES
{
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {

        GestaoAcesso gestaoacesso = new GestaoAcesso();

        Scanner scanI = new Scanner(System.in);   //Integer scanner
        Scanner scanS = new Scanner(System.in);   //String scanner

        int opc1 = -1, opc2 = -1;  //opcao menu1, menu2
        int opctipocurso = -1; //opcao curso
        int  opcGenero = -1;
        int idd=0;

        //gestaoacesso.lerFicheiro();

        //Menu
        do {
            clearScreen();
            System.out.println("*** Acesso ao Ensino Superior ***");
            System.out.println("1. Registar Candidato");
            System.out.println("2. Registar Curso");
            System.out.println("3. Mostrar Resultado da Candidatura");
            System.out.println("4. Listar");
            System.out.println("5. Créditos");
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
                    String cNome = scanS.next();

                    System.out.println("Género: ");
                    System.out.println("Selecione uma das opções:" );
                    System.out.println("1. Masculino");
                    System.out.println("2. Feminino");

                    opcGenero = scanI.nextInt();

                    while(opcGenero < 1 || opcGenero > 2){
                        System.out.println("A  opção não existe!");
                        System.out.println("Por favor introduza uma opção válida ");
                        opcGenero = scanI.nextInt();
                    }

                    String cGenero = "";
                    if(opcGenero == 1)
                        cGenero = "Masculino";
                    else
                        cGenero = "Feminino";

                    System.out.print("Nota Exame A: ");
                    int cNotaA = scanI.nextInt();

                    while(cNotaA < 0 || cNotaA > 200){
                        System.out.print("Nota InváLida!! Introduza novamente!! ");
                        System.out.print("Nota Exame A: ");
                        cNotaA = scanI.nextInt();
                    }

                    System.out.print("Nota Exame B: ");
                    int cNotaB = scanI.nextInt();

                    while(cNotaB < 0 || cNotaB > 200){
                        System.out.print("Nota Inválida!! Introduza novamente!! ");
                        System.out.print("Nota Exame B: ");
                        cNotaB = scanI.nextInt();
                    }

                    System.out.print("Nota Exame Inglês: ");
                    int cNotaIng = scanI.nextInt();

                    while(cNotaIng < 0 || cNotaIng > 200){
                        System.out.print("Nota Inválida!! Introduza novamente!! ");
                        System.out.print("Nota Exame Inglês: ");
                        cNotaIng = scanI.nextInt();
                    }

                    System.out.print("Media Secundário: ");
                    int cNotaSec = scanI.nextInt();

                    while(cNotaSec < 0 || cNotaSec > 200){
                        System.out.print("Nota Inválida!! Introduza novamente!! ");
                        System.out.print("Média Secundária: ");
                        cNotaSec = scanI.nextInt();
                    }

                    System.out.print("Aluno/a de Região Desfavorecida? ** 1-SIM || 2-NÃO **: ");
                    int cReg = scanS.nextInt();

                    if (cReg == 1) {
                        System.out.print("Introduza o código da Regiao Desfavorecida: ");
                        int cRegCode = scanI.nextInt();
                        int bonus = 20;

                        AlunoRegioes areg = new AlunoRegioes(cNome, cGenero, idd, cNotaA, cNotaB, cNotaIng, cNotaSec, bonus, cRegCode);
                        gestaoacesso.addCandidato(areg.clone());

                        System.out.println("** Lista de cursos: **");
                        gestaoacesso.showCursos();
                        System.out.println("Escolha até 5 cursos");
                        int i = 0;
                        while(i < 5){
                            int opcCurso = scanI.nextInt();
                            gestaoacesso.escolheCurso(areg.clone(), opcCurso);
                            i++;
                        }
                        gestaoacesso.addListaCandidato(areg.clone(),areg.getCursoDoCandidato());
                    }

                    System.out.print("Aluno/a com necessidades especiais? ** 1-SIM || 2-NÃO **: ");
                    int cNesEsp = scanS.nextInt();

                    if (cNesEsp == 1) {
                        System.out.print("Introduza o nível de necessidade: ");
                        int cNivelNecessidade = scanI.nextInt();

                        System.out.print("Introduza o Tipo de Incapacidade (ex: Motora, sensorial, visual): ");
                        String cTipoIncap = scanS.nextLine();
                        int bonus1 = 50;

                        AlunoEspeciais ae = new AlunoEspeciais(cNome, cGenero, idd, cNotaA, cNotaB, cNotaIng, cNotaSec, bonus1, cNivelNecessidade, cTipoIncap);
                        gestaoacesso.addCandidato(ae.clone());

                        System.out.println("** Lista de cursos: **");
                        gestaoacesso.showCursos();
                        System.out.println("Escolha até 5 cursos");
                        int i = 0;
                        while(i < 5){
                            int opcCurso = scanI.nextInt();
                            gestaoacesso.escolheCurso(ae.clone(), opcCurso);
                            i++;
                        }
                        gestaoacesso.addListaCandidato(ae.clone(),ae.getCursoDoCandidato());
                    }
                    if (cReg == 2 && cNesEsp == 2){
                        int bonus3 = 0;
                        AlunoRegular ar = new AlunoRegular(cNome, cGenero, idd, cNotaA, cNotaB, cNotaIng, cNotaSec, bonus3);
                        gestaoacesso.addCandidato(ar.clone());

                        System.out.println("** Lista de cursos: **");
                        gestaoacesso.showCursos();
                        System.out.println("Escolha até 5 cursos");
                        int i = 0;
                        while(i < 5){
                            int opcCurso = scanI.nextInt();
                            gestaoacesso.escolheCurso(ar.clone(), opcCurso);
                            i++;
                        }
                        gestaoacesso.addListaCandidato(ar.clone(),ar.getCursoDoCandidato());
                    }

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
                        gestaoacesso.addListaCurso(bio.clone(), bio.getListaColocados());
                        break;
                    }
                    if (opctipocurso == 2) {
                        Ciencias cie = new Ciencias(NomeUni, NomeCurso, NumClaus);
                        gestaoacesso.addCurso(cie.clone());
                        gestaoacesso.addListaCurso(cie.clone(), cie.getListaColocados());
                        break;
                    }
                    if (opctipocurso == 3) {
                        CJuridicas juri = new CJuridicas(NomeUni, NomeCurso, NumClaus);
                        gestaoacesso.addCurso(juri.clone());
                        gestaoacesso.addListaCurso(juri.clone(), juri.getListaColocados());
                        break;
                    }
                    if (opctipocurso == 4) {
                        Engenharia eng = new Engenharia(NomeUni, NomeCurso, NumClaus);
                        gestaoacesso.addCurso(eng.clone());
                        gestaoacesso.addListaCurso(eng.clone(), eng.getListaColocados());
                        break;
                    }
                    if (opctipocurso == 5) {
                        Humanidades hum = new Humanidades(NomeUni, NomeCurso, NumClaus);
                        gestaoacesso.addCurso(hum.clone());
                        gestaoacesso.addListaCurso(hum.clone(), hum.getListaColocados());
                        break;
                    }

                case 3:
                    clearScreen();
                    //gestaoacesso.teste();
                    gestaoacesso.aprovacao();
                    System.out.println("Introduza o seu id: ");
                    int id = scanI.nextInt();
                    while(!gestaoacesso.candidatoExiste(id)){
                        System.out.println("O candidato não existe!");
                        System.out.println("Por favor introduza um id válido!");
                        id = scanI.nextInt();
                    }
                    gestaoacesso.mostraResultadoCandidatura(id);

                    break;

                case 4:
                    do {
                        clearScreen();
                        //gestaoacesso.teste();
                        gestaoacesso.aprovacao();
                        System.out.println("1. Listar colocados");
                        System.out.println("2. Listar colocados de um curso");
                        System.out.println("3. Mostrar Curso com média mais alta");
                        System.out.println("4. Mostrar Curso com média mais baixa");
                        System.out.println("5. Curso com mais candidatos do genero feminino");
                        System.out.println("0. Voltar ao Menu Anterior");

                        System.out.print("Escolha a sua opção: ");
                        opc2 = scanI.nextInt();
                        clearScreen();

                        switch (opc2) {
                            case 1:
                                gestaoacesso.showColocados();
                                break;

                            case 2:
                                gestaoacesso.showCursos();
                                System.out.println("Introduza a opcao do curso:");
                                int opccurso = scanI.nextInt();
                                gestaoacesso.showColocadosPorCurso(opccurso);
                                break;

                            case 3:
                                int posCurso = gestaoacesso.cursoMediaMaisAlta();
                                gestaoacesso.mostraCursoPelaPosicao(posCurso);
                                break;

                            case 4:
                                int posCurso1 = gestaoacesso.cursoMediaMaisBaixa();
                                gestaoacesso.mostraCursoPelaPosicao(posCurso1);
                                break;

                            case 5:
                                int posCurso2 = gestaoacesso.cursoMaisFeminino();
                                gestaoacesso.mostraCursoPelaPosicao(posCurso2);
                                break;
                            default:
                                System.out.println("Escolha uma opção válida!\n");
                                break;

                            case 0:
                                break;
                        }


                    } while (opc2 != 0);

                    break;

                case 5:
                    System.out.println("Alexandre Ribeiro A93092");
                    System.out.println("César Castro A93090");
                    System.out.println("Ricardo Peixoto A93081");
                    break;

                case 0:
                    System.out.print("Obrigado por usar a nossa aplicação!!\n");
                    //gestaoacesso.guardaFicheiro();

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