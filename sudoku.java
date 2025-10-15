import java.util.Scanner;

public class Sudoku {
    final static Scanner LER = new Scanner(System.in);

    // Inicio do programa
    public static void Abertura() {
        int inicioJogo = 0;
        System.out.println(
                "  █████████     █████  █████    ██████████         ███████       █████   ████    █████  █████\r\n" + //
                        " ███░░░░░███   ░░███  ░░███    ░░███░░░░███      ███░░░░░███    ░░███   ███░    ░░███  ░░███ \r\n"
                        + //
                        "░███    ░░░     ░███   ░███     ░███   ░░███    ███     ░░███    ░███  ███       ░███   ░███ \r\n"
                        + //
                        "░░█████████     ░███   ░███     ░███    ░███   ░███      ░███    ░███████        ░███   ░███ \r\n"
                        + //
                        " ░░░░░░░░███    ░███   ░███     ░███    ░███   ░███      ░███    ░███░░███       ░███   ░███ \r\n"
                        + //
                        " ███    ░███    ░███   ░███     ░███    ███    ░░███     ███     ░███ ░░███      ░███   ░███ \r\n"
                        + //
                        "░░█████████     ░░████████      ██████████      ░░░███████░      █████ ░░████    ░░████████  \r\n"
                        + //
                        " ░░░░░░░░░       ░░░░░░░░      ░░░░░░░░░░         ░░░░░░░       ░░░░░   ░░░░      ░░░░░░░░   ");

        while (inicioJogo != 1) {
            System.out.printf("\n\n 1.Iniciar\n\n 2.Como jogar\n");
            inicioJogo = LER.nextInt();
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
                "\n    Para colocar os numeros informe primeiro se será uma marcação ou uma jogada após informe a posição");
        System.out.println("    Para a marcação digite 'M' e para a jogada 'J'");
        System.out.println("    Para a posição primeiro coloque a linha depois a coluna");
    }

    // Metodo feito para limpar o terminal
    public static void limparTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Inicio real do jogo
    public static void comecar() {
        limparTerminal();
        int[][] sudokuEmbaralhado = new int[9][9];
        while (verificarPossibilidade(sudokuEmbaralhado) != true) {
            sudokuEmbaralhado = embaralharGrade();

        }

    }

    // Gera numeros semi aleatorios na grade do sudoku (semi aleatorio por ainda
    // seguir as regras do jogo)
    // Gera 2 a 4 de cada numero na grade
    public static int[][] embaralharGrade() {
        int[][] sudoku = new int[9][9];
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {

            }
        }
        return sudoku;
    }

    // Metodo de backtracking para confirmar se a forma em que foi embaralhado a
    // grade do sudoku é possivel de se resolver
    public static boolean verificarPossibilidade(int[][] baseSudoku) {
        boolean possivel = false;
        return possivel;
    }

    public static void main(String[] args) {
        Abertura();
    }
}
