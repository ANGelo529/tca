import java.util.Scanner;

public class Sudoku {
    final static Scanner LER = new Scanner(System.in);

    // Inicio do programa
    public static void Abertura() {
        int inicioJogo = 0;
        limparTerminal();
        System.out.println(
                """
                          \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588     \u2588\u2588\u2588\u2588\u2588  \u2588\u2588\u2588\u2588\u2588    \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588         \u2588\u2588\u2588\u2588\u2588\u2588\u2588       \u2588\u2588\u2588\u2588\u2588   \u2588\u2588\u2588\u2588    \u2588\u2588\u2588\u2588\u2588  \u2588\u2588\u2588\u2588\u2588\r
                         \u2588\u2588\u2588\u2591\u2591\u2591\u2591\u2591\u2588\u2588\u2588   \u2591\u2591\u2588\u2588\u2588  \u2591\u2591\u2588\u2588\u2588    \u2591\u2591\u2588\u2588\u2588\u2591\u2591\u2591\u2591\u2588\u2588\u2588      \u2588\u2588\u2588\u2591\u2591\u2591\u2591\u2591\u2588\u2588\u2588    \u2591\u2591\u2588\u2588\u2588   \u2588\u2588\u2588\u2591    \u2591\u2591\u2588\u2588\u2588  \u2591\u2591\u2588\u2588\u2588 \r
                        \u2591\u2588\u2588\u2588    \u2591\u2591\u2591     \u2591\u2588\u2588\u2588   \u2591\u2588\u2588\u2588     \u2591\u2588\u2588\u2588   \u2591\u2591\u2588\u2588\u2588    \u2588\u2588\u2588     \u2591\u2591\u2588\u2588\u2588    \u2591\u2588\u2588\u2588  \u2588\u2588\u2588       \u2591\u2588\u2588\u2588   \u2591\u2588\u2588\u2588 \r
                        \u2591\u2591\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588     \u2591\u2588\u2588\u2588   \u2591\u2588\u2588\u2588     \u2591\u2588\u2588\u2588    \u2591\u2588\u2588\u2588   \u2591\u2588\u2588\u2588      \u2591\u2588\u2588\u2588    \u2591\u2588\u2588\u2588\u2588\u2588\u2588\u2588        \u2591\u2588\u2588\u2588   \u2591\u2588\u2588\u2588 \r
                         \u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2588\u2588\u2588    \u2591\u2588\u2588\u2588   \u2591\u2588\u2588\u2588     \u2591\u2588\u2588\u2588    \u2591\u2588\u2588\u2588   \u2591\u2588\u2588\u2588      \u2591\u2588\u2588\u2588    \u2591\u2588\u2588\u2588\u2591\u2591\u2588\u2588\u2588       \u2591\u2588\u2588\u2588   \u2591\u2588\u2588\u2588 \r
                         \u2588\u2588\u2588    \u2591\u2588\u2588\u2588    \u2591\u2588\u2588\u2588   \u2591\u2588\u2588\u2588     \u2591\u2588\u2588\u2588    \u2588\u2588\u2588    \u2591\u2591\u2588\u2588\u2588     \u2588\u2588\u2588     \u2591\u2588\u2588\u2588 \u2591\u2591\u2588\u2588\u2588      \u2591\u2588\u2588\u2588   \u2591\u2588\u2588\u2588 \r
                        \u2591\u2591\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588     \u2591\u2591\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588      \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588      \u2591\u2591\u2591\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2591      \u2588\u2588\u2588\u2588\u2588 \u2591\u2591\u2588\u2588\u2588\u2588    \u2591\u2591\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588  \r
                         \u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591       \u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591      \u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591         \u2591\u2591\u2591\u2591\u2591\u2591\u2591       \u2591\u2591\u2591\u2591\u2591   \u2591\u2591\u2591\u2591      \u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591   """ //
        );

        while (inicioJogo != 1) {
            System.out.printf("\n\n 1.Iniciar\n\n 2.Como jogar\n\n ");
            inicioJogo = LER.nextInt();
            // inicioJogo = 1;
            while (inicioJogo != 1 && inicioJogo != 2) {
                System.out.println("\nCódigo inválido escreva novamente");
                inicioJogo = LER.nextInt();
            }
            if (inicioJogo == 1) {
                comecar();
            } else {
                instrucoes();
            }
        }
    }

    // Como se deve jogar tanto na minha versão e regras do sudoku
    public static void instrucoes() {
        limparTerminal();
        System.out.println(
                "\n    O objetivo é completar totalmente o tabuleiro de tamanho 9x9 sobrando nenhum espaço em branco");
        System.out.println("    Regras:");
        System.out.println(
                "    1.Cada linha deve ter todos os números de 1 a 9 de forma em que não repita nenhum numero.");
        System.out.println(
                "    2.Cada coluna deve ter todos os números de 1 a 9 de forma em que não repita nenhum numero.");
        System.out.println(
                "    3.Cada bloco 3x3 também deve ter todos os números de 1 a 9 de forma em que não repita nenhum numero.");
        System.out.println(
                "\n    Para jogar informe o numero que será colocado depois informe a posição com linha e coluna (A posição vai de 0 a 8 mantenha a ordem linha coluna)");
    }

    // Metodo feito para limpar o terminal
    public static void limparTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Inicio real do jogo
    public static void comecar() {
        limparTerminal();
        int[][] sudokuAlteravel = new int[9][9];
        int[][] sudokuCompleto = new int[9][9];
        do {
            embaralharGrade(sudokuCompleto);
            sudokuAlteravel = sudokuCompleto;
            retirarPosicoes(sudokuAlteravel);
            imprimirGrade(sudokuAlteravel);
            colocarPosicao(sudokuAlteravel);
        } while (verificarVitoria(sudokuAlteravel, sudokuCompleto) != true);
    }

    public static void imprimirGrade(int[][] sudokuAlteravel) {
        System.out.println("\t\t S U D O K U");
        for (int i = 0; i < 9; i++) {
            System.out.printf("  %d  ", i);
        }
        System.out.print("\n -------------------------------------------\n");
        for (int i = 0; i < sudokuAlteravel.length; i++) {
            for (int j = 0; j < sudokuAlteravel.length; j++) {
                if (i % 3 == 0 && i != 0 && j == 0) {
                    System.out.print(" -------------------------------------------\n");
                }
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" []");
                    System.out.print(" | ");
                    System.out.print(sudokuAlteravel[i][j]);
                } else {
                    System.out.print(" | ");
                    System.out.print(sudokuAlteravel[i][j]);
                }

            }
            System.out.print(" | \n");
        }

    }

    public static void colocarPosicao(int[][] sudokuAlteravel) {
        int numeroEscolhido = LER.nextInt();
        int linha = LER.nextInt();
        int coluna = LER.nextInt();
        if (sudokuAlteravel[linha][coluna] == 0) {
            sudokuAlteravel[linha][coluna] = numeroEscolhido;
            limparTerminal();
        } else {
            limparTerminal();
            System.out.println("Essa posição não pode ser alterada");
        }
    }

    public static void retirarPosicoes(int[][] sudokuAlteravel) {

    }

    // Gera numeros semi aleatorios na grade do sudoku (semi aleatorio por ainda
    // seguir as regras do jogo)
    // Gera 2 a 4 de cada numero na grade
    public static void embaralharGrade(int[][] sudoku1) {
        int[][] sudoku = new int[9][9];
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {

            }
        }

    }

    // Metodo de backtracking para confirmar se a forma em que foi embaralhado a
    // grade do sudoku é possivel de se resolver
    public static boolean verificarVitoria(int[][] sudokuAlterado, int[][] sudokuCompleto) {
        boolean possivel = false;
        return possivel;
    }

    public static void main(String[] args) {
        Abertura();
    }
}