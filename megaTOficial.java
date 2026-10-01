
/*
             INFORMAÇÕES DE VALORES DO JOGO
TAMANHO = 200 EM CASA E SEM ABAS DEPENDENDO DA TELA PODE NÃO FICAR CORRETO O TAMANHO CASO NÃO ESTEJA CORRETO NECESSARIO ALTERAR ESSE VALOR

VALOR DOS PERSONAGENS NO VETOR POSICOES:(0 lugar vazio) (1 player) (2 inimigo) (3 boss) (4 ataque do player) (5 ataque inimigo 1) (6 escudo) (7 inimigo 2) 
(8 ataque inimigo2)

VALORES DO VETOR TAMANHOSX e TAMANHOSI: (0 tamanhoX Geral) (1 tamanhoX Bala) (2 tamanhoX escudo) (3 tamanhoX inimigo 1) (4 tamanhoX inimigo 2) (5 tamanhoX tableThistoria) (6 tamanhoX boss)
(7 avisoDoAtaque) (8 ataqueDeTrovão) (9 ataque inimigoBase1)

VALORES DO VETOR TEMINIMIGOS: (0 inimigo 1) (1 inimigo 2) (2 boss)

VALORES DO VETOR POSICAOINIMIGOS: (0 inimigo 1) (1 inimigo 2) (2 boss)
*/
import java.util.Scanner;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class megaTOficial {
    final static Scanner LER = new Scanner(System.in);
    // Na escola TAMANHO = 221 EM CASA 200
    final static int TAMANHO = obterLarguraTerminal();
    final static int MOVIMENTODOPLAYER = 20;
    final static int[] TAMANHOX = new int[11];
    final static int[] TAMANHOY = new int[11];
    static boolean vivo = true;
    static int fase = 0;
    static int vida = 5;
    static int qtdInimigos = 0;
    static int posicao = 10;
    static int turnos;
    static int turnoInicial;
    static int temTiro;
    static float danoBasePlayer = (float) (10);
    static boolean temHist = true;
    static boolean entrou = true;
    static boolean venceu = false;
    static char clicou = ' ';
    static char ultimoClique = ' ';
    static float[] vidaInimigo = new float[3];
    static int[] posicaoInimigos = new int[3];
    static int[] posicoes = new int[TAMANHO];
    static boolean[] temInimigos = new boolean[3];
    static boolean[] temUp = new boolean[2];
    static char[][] mapa = new char[14][TAMANHO];
    static Terminal terminal;
    static char[][] personagem = {
            { ' ', ' ', '┌', '─', '─', '┐', ' ', ' ' },
            { ' ', ' ', '│', 'O', 'O', '│', ' ', ' ' },
            { ' ', ' ', '│', '-', '-', '│', ' ', ' ' },
            { ' ', ' ', '└', '─', '─', '┘', ' ', ' ' },
            { ' ', ' ', ' ', '│', '│', '─', '┌', '─' },
            { ' ', ' ', ' ', '│', '│', ' ', ' ', ' ' },
            { ' ', ' ', ' ', '/', '\\', ' ', ' ', ' ' },
            { ' ', ' ', '/', ' ', ' ', '\\', ' ', ' ' } };

    final static char[][] escudoEsquerda = {
            { ' ', ' ', '/', '/', ' ' },
            { ' ', ' ', '│', '│', ' ' },
            { ' ', ' ', '│', '│', ' ' },
            { ' ', ' ', '│', '│', ' ' },
            { ' ', ' ', '│', '│', ' ' },
            { ' ', ' ', '│', '│', ' ' },
            { ' ', ' ', '│', '│', ' ' },
            { ' ', ' ', '\\', '\\', ' ' } };

    final static char[][] escudoDireita = {
            { ' ', ' ', '\\', '\\', ' ' },
            { ' ', ' ', '│', '│', ' ' },
            { ' ', ' ', '│', '│', ' ' },
            { ' ', ' ', '│', '│', ' ' },
            { ' ', ' ', '│', '│', ' ' },
            { ' ', ' ', '│', '│', ' ' },
            { ' ', ' ', '│', '│', ' ' },
            { ' ', ' ', '/', '/', ' ' } };

    final static char[][] balaDireita = {
            { '┌', '─', '─', '\\' },
            { '│', ' ', ' ', '│' },
            { '└', '─', '─', '/' } };

    final static char[][] balaEsquerda = {
            { '/', '─', '─', '┐' },
            { '│', ' ', ' ', '│' },
            { '\\', '─', '─', '┘' } };

    final static char[][] ataqueInimigo = {
            { ' ', '*', '*', ' ' },
            { '*', '*', '*', '*' },
            { '*', '*', '*', '*' },
            { ' ', '*', '*', ' ' } };

    final static char[][] inimigoBase = {
            { ' ', ' ', '┌', '─', '─', '┐', ' ', ' ' },
            { ' ', ' ', '│', '*', '*', '│', ' ', ' ' },
            { ' ', ' ', '│', '┌', '┐', '│', ' ', ' ' },
            { ' ', ' ', '│', '└', '┘', '│', ' ', ' ' },
            { ' ', ' ', '└', '─', '─', '┘', ' ', ' ' } };

    final static char[][] inimigoBase2 = {
            { ' ', ' ', '┌', '─', '─', '┐', ' ', '┌', '┐' },
            { ' ', ' ', '│', '*', '*', '│', ' ', '└', '┘' },
            { ' ', ' ', '│', '┌', '┐', '│', ' ', '─', '─' },
            { ' ', ' ', '│', '└', '┘', '│', ' ', '│', '│' },
            { ' ', ' ', '└', '─', '─', '┘', ' ', '│', '│' } };

    final static char[][] boss = {
            { ' ', ' ', ' ', '┌', '─', '─', '┐', ' ', ' ', ' ' },
            { ' ', ' ', ' ', '│', '*', '*', '│', ' ', ' ', ' ' },
            { ' ', ' ', ' ', '│', '<', '>', '│', ' ', ' ', ' ' },
            { '┌', '─', '┐', '└', '┐', '┌', '┘', '┌', '─', '┐' },
            { '│', ' ', '└', '─', '┤', '├', '─', '┘', ' ', '│' },
            { '│', ' ', ' ', ' ', '│', '│', ' ', ' ', ' ', '│' },
            { '└', '─', '┐', ' ', '│', '│', ' ', '┌', '─', '┘' },
            { ' ', ' ', '└', '─', '┤', '├', '─', '┘', ' ', ' ' },
            { ' ', ' ', ' ', ' ', '│', '│', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', '/', '\\', ' ', ' ', ' ', ' ' } };

    final static char[][] tableteTech = {
            { '┌', '─', '─', '─', '─', '─', '─', '─', '─', '┐' },
            { '│', 'Z', ' ', '(', ' ', '$', ' ', '(', ' ', '│' },
            { '│', ' ', 'X', ' ', '$', ' ', '¨', '&', ' ', '│' },
            { '│', '$', ' ', 'R', ' ', ' ', '#', ' ', ')', '│' },
            { '│', ' ', ' ', '$', ' ', 'V', ' ', ')', ' ', '│' },
            { '│', ' ', '*', ' ', ' ', ' ', '*', ' ', ' ', '│' },
            { '└', '─', '─', '┐', ' ', ' ', '┌', '─', '─', '┘' },
            { ' ', ' ', ' ', '│', ' ', ' ', '│', ' ', ' ', ' ' },
            { ' ', ' ', ' ', '│', ' ', ' ', '│', ' ', ' ', ' ' },
            { ' ', ' ', ' ', '│', ' ', ' ', '│', ' ', ' ', ' ' },
            { ' ', '┌', '─', '┘', ' ', ' ', '└', '─', '┐', ' ' },
            { ' ', '└', '─', '─', '─', '─', '─', '─', '┘', ' ' } };

    final static char[][] upDano = {
            { '┌', '─', '─', '─', '─', '─', '─', '─', '─', '┐' },
            { '│', ' ', ' ', '┌', '─', '─', '┐', ' ', ' ', '│' },
            { '│', ' ', ' ', '│', ' ', ' ', '│', ' ', ' ', '│' },
            { '│', ' ', '┌', '┴', '─', '─', '┴', '┐', ' ', '│' },
            { '│', ' ', '└', '┬', '─', '─', '┬', '┘', ' ', '│' },
            { '│', ' ', ' ', '└', '─', '─', '┘', ' ', ' ', '│' },
            { '└', '─', '─', '┐', ' ', ' ', '┌', '─', '─', '┘' },
            { ' ', ' ', ' ', '│', ' ', ' ', '│', ' ', ' ', ' ' },
            { ' ', ' ', ' ', '│', ' ', ' ', '│', ' ', ' ', ' ' },
            { ' ', ' ', ' ', '│', ' ', ' ', '│', ' ', ' ', ' ' },
            { ' ', '┌', '─', '┘', ' ', ' ', '└', '─', '┐', ' ' },
            { ' ', '└', '─', '─', '─', '─', '─', '─', '┘', ' ' } };

    final static char[][] upVida = {
            { '┌', '─', '─', '─', '─', '─', '─', '─', '─', '┐' },
            { '│', ' ', '/', '\\', ' ', ' ', '/', '\\', ' ', '│' },
            { '│', '/', ' ', ' ', '\\', '/', ' ', ' ', '\\', '│' },
            { '│', '\\', ' ', ' ', ' ', ' ', ' ', ' ', '/', '│' },
            { '│', ' ', '\\', ' ', ' ', ' ', ' ', '/', ' ', '│' },
            { '│', ' ', ' ', '\\', ' ', ' ', '/', ' ', ' ', '│' },
            { '└', '─', '─', '┐', '\\', '/', '┌', '─', '─', '┘' },
            { ' ', ' ', ' ', '│', ' ', ' ', '│', ' ', ' ', ' ' },
            { ' ', ' ', ' ', '│', ' ', ' ', '│', ' ', ' ', ' ' },
            { ' ', ' ', ' ', '│', ' ', ' ', '│', ' ', ' ', ' ' },
            { ' ', '┌', '─', '┘', ' ', ' ', '└', '─', '┐', ' ' },
            { ' ', '└', '─', '─', '─', '─', '─', '─', '┘', ' ' } };

    final static char[][] aviso = {
            { ' ', ' ', '│', '│', ' ', ' ' },
            { ' ', ' ', '│', '│', ' ', ' ' },
            { ' ', ' ', '│', '│', ' ', ' ' },
            { ' ', ' ', '│', '│', ' ', ' ' },
            { ' ', ' ', '│', '│', ' ', ' ' },
            { ' ', ' ', '┌', '┐', ' ', ' ' },
            { ' ', ' ', '└', '┘', ' ', ' ' } };

    final static char[][] ataqueTrovoada = {
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', '/', '/' },
            { ' ', ' ', ' ', ' ', ' ', '/', '/', ' ' },
            { ' ', ' ', ' ', ' ', '/', '/', ' ', ' ' },
            { ' ', ' ', ' ', '/', '/', ' ', ' ', ' ' },
            { ' ', ' ', '/', '/', ' ', ' ', ' ', ' ' },
            { ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ' },
            { '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ' } };

    public static void limparTerminal() {
        // Limpa a tela (em alguns PCs da escola não funciona as vezes)
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void setColor(int cor) {
        // Método feito pelo professor Ló serve para colocar cor no sout
        String s = "[0m";
        switch (cor) {
            case 0 -> s = "[30m";// preto
            case 1 -> s = "[31m";// vermelho
            case 2 -> s = "[32m";// verde
            case 3 -> s = "[33m";// amarelo
            case 4 -> s = "[34m";// azul
            case 5 -> s = "[35m";// magenta
            case 6 -> s = "[36m";// ciano
            case 7 -> s = "[97m";// branco
        }

        System.out.print((char) 27 + s);
    }

    public static int obterLarguraTerminal() {
    try {
        if (terminal == null) {
            // Inicializa a interface com o terminal do sistema
            terminal = TerminalBuilder.builder()
                        .system(true)
                        .dumb(true) // Fallback caso não seja um terminal ANSI completo
                        .build();
        }
        
        // Pega o número de colunas atual da Janela
        int colunas = terminal.getWidth();
        
        // Se retornar um valor válido, usa ele; senão usa 120
        return (colunas > 0) ? colunas : 120;
    } catch (Exception e) {
        // Caso ocorra qualquer erro ao inicializar o terminal
        return 120;
    }
}

    public static void instrucoes() {
        // Comandos de como se joga (as teclas foram escolhidas em base pelo uso geral
        // em jogos)
        limparTerminal();
        // Bem vindo a Metrônia o seu principal objetivo é derrotar todos os robôs do
        // doutor Melônic
        setColor(1);
        System.out.println("""

                \t\t\t\t\t+-+-+-+-+-+-+-+-+-+-+-+-+-+ +-+-+ +-+-+-+-+ +-+-+\r
                \t\t\t\t\t|F|u|n|c|i|o|n|a|m|e|n|t|o| |d|o| |M|e|g|a| |T|:|\r
                \t\t\t\t\t+-+-+-+-+-+-+-+-+-+-+-+-+-+ +-+-+ +-+-+-+-+ +-+-+

                """ //
        //
        );
        setColor(7);
        System.out.println("1.Para andar clique 'd' para andar a direita e 'a' para andar a esquerda.");
        System.out.println("2.Para usar o escudo aperte 'f' o escudo te defenderá de possiveis ataques.");
        System.out.println("3.Para utilizar seu canhão de energia T aperte 'r'.");
        System.out.println("4.Para prosseguir para a proxima fase aperte 'e'.");
    }

    public static void imprimirJogo(int fase) throws InterruptedException {
        // Funcionamento do jogo tendo os metodos de funcionamento do jogo
        limparTerminal();
        imprimirUI();
        limparMatriz(mapa);
        controleDeFases(mapa);
        ataques(1);
        imprimirAcoes(ultimoClique);
        ataques(2);
        ataques(3);
        imprimirMapa(mapa);
        posicoes[posicao] = 1;
        ultimoClique = clicou;
        posicao = controlePosicao(posicao, mapa);

        // Prevenir erros zerando variavéis temporárias
        // Mesmo a maioria sendo zerado no método correspondente para não ter erros
        // zero denovo os valores
        zerarValores(4);
        zerarValores(5);
        zerarValores(6);
        zerarValores(8);
        if (vida <= 0) {
            vivo = false;
        }
    }

    public static void gotoXY(int linha, int coluna) {
        // Método feito pelo professor Thiago Ló
        char escCode = 0x1B;
        System.out.print(String.format("%c[%d;%df", escCode, linha, coluna));
    }

    public static void imprimirUI() {
        // Imprime valores bases como vida, fase e o nome do projeto
        // Sendo literalmente uma UI
        setColor(3);
        gotoXY(1, 100);
        System.out.printf("M E G A-T");
        setColor(1);
        gotoXY(2, 85);
        System.out.printf("vida:%d", vida);
        setColor(4);
        gotoXY(2, 115);
        System.out.printf("fase:%d\n", fase);
        setColor(7);
    }

    public static void limparMatriz(char[][] mapa) {
        // Zera a matriz do mapa serve para prevenir valores remanescentes
        for (int i = 0; i < 14; i++) {

            for (int j = 0; j < TAMANHO; j++) {

                mapa[i][j] = ' ';
            }
        }
    }

    public static void imprimirMapa(char[][] mapa) {
        // Imprime o mapa depois de todas as alterações
        for (int i = 0; i < 14; i++) {
            //gotoXY(i, 10);
            for (int j = 0; j < TAMANHO - 10; j++) {

                System.out.print(mapa[i][j]);
            }
            System.out.println();
        }
        //gotoXY(15, 10);
        for (int i = 0; i < TAMANHO - 11; i++) {

            System.out.print("=");
            System.out.print("=");
        }
        System.out.print("==");
        System.out.println();
    }

    @SuppressWarnings("ManualArrayToCollectionCopy")
    public static void spawnarPlayer(int posicao, char[][] mapa) {
        // Somente coloca o sprite do player no mapa
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < TAMANHOX[0]; j++) {

                mapa[6 + i][posicao + j] = personagem[i][j];
            }
        }

    }

    @SuppressWarnings("ManualArrayToCollectionCopy")
    public static void spawnarBoss() throws InterruptedException {
        // Coloca o boss na matriz principal
        for (int i = 0; i < TAMANHOY[6]; i++) {

            for (int j = 0; j < TAMANHOX[6]; j++) {

                mapa[4 + i][descobrirPosicao(3) + j] = boss[i][j];
            }
        }

    }

    public static void spawnarHistoria() throws InterruptedException {
        char historia = ' ';

        // Impressão do tablete da história
        for (int i = 0; i < TAMANHOY[5]; i++) {

            for (int j = 0; j < TAMANHOX[5]; j++) {

                mapa[2 + i][(int) (TAMANHO / 1.5 + j)] = tableteTech[i][j];
            }
        }

        if ((posicao <= (int) (TAMANHO / 1.5 + 60) && posicao >= (int) (TAMANHO / 1.5 - 60)) && temHist) {
            imprimirMapa(mapa);
            gotoXY(19, 50);
            setColor(4);
            System.out.println(
                    "Para ler a história do mundo e do personagem clique 'Q' ou clique 'E' para ignorar a historia");
            historia = LER.next().charAt(0);

            // Verifica se vai contar a historia
            if (historia == 'q' || historia == 'Q') {
                temHist = false;
                imprimirHistoria();
            }

            // Impedimento de ficar repetindo o mesma pergunta várias vezes
            if (historia == 'e' || historia == 'E') {
                temHist = false;
            }
        }
    }

    public static void spawnarUps() {
        char ups = ' ';
        int vidaOuDano = 0;
        imprimirTabletesUps();

        // Verificação para saber se o player está dentro do range de funcionamento
        if (((posicao <= (int) (TAMANHO / 1.5 + 40) && posicao >= (int) (TAMANHO / 1.5 - 40))
                || (posicao <= (int) (TAMANHO / 3 + 40) && posicao >= (int) (TAMANHO / 3 - 40))) && temUp[1]
                || temUp[0]) {

            imprimirMapa(mapa);
            gotoXY(19, 50);
            setColor(4);

            // Imprimindo explicação doque tem que ser feito para upar a vida
            if ((posicao <= (int) ((TAMANHO / 1.2) + 30) && posicao >= (int) ((TAMANHO / 1.2) - 30)) && temUp[0]) {

                System.out.println(
                        "Para melhorar e restaurar a vida do personagem clique 'Q' ou clique 'E' para ignorar a melhoria");
                vidaOuDano = 1;
                ups = LER.next().charAt(0);
            }

            // Imprimindo uma explicação doque tem que ser feito para upar o dano
            if ((posicao <= (int) ((TAMANHO / 3) + 40) && posicao >= (int) ((TAMANHO / 3) - 40)) && temUp[1]) {

                System.out.println(
                        "Para melhorar o dano do personagem clique 'Q' ou clique 'E' para ignorar a melhoria");
                vidaOuDano = 2;
                ups = LER.next().charAt(0);
            }

            // Se aceito a melhoria ele executa dependendo qual foi escolhido
            if (ups == 'q' || ups == 'Q') {

                temUp[0] = false;
                temUp[1] = false;
                fazerUps(vidaOuDano);
            }

            // Verificação para poder avançar sem ficar aparecendo a tela de melhorar
            // personagem
            if (ups == 'e' || ups == 'E') {

                if (vidaOuDano == 1) {

                    temUp[0] = false;
                } else if (vidaOuDano == 2) {

                    temUp[1] = false;
                }

            }

        }
    }

    public static void fazerUps(int vidaOuDano) {
        // Execução real dos Ups alterando o valor dependendo da fase
        if (vidaOuDano == 2 && fase == 2) {
            danoBasePlayer += 0.5;
        } else if (vidaOuDano == 2 && fase == 4) {
            danoBasePlayer += 1;
        }

        if (vidaOuDano == 1 && fase == 2) {
            vida += 3;
        } else if (vidaOuDano == 1 && fase == 4) {
            vida += 5;
        }
    }

    @SuppressWarnings("ManualArrayToCollectionCopy")
    public static void spawnarInimigo(char[][] mapa, int qtdInimigosDesejados, char[][] personagem, int tamanhoI,
            int TamanhoJ, int inimigosDesejado) {

        // Coloca a posição inicial dos inimigos
        colocarPosicaoInimigos(qtdInimigosDesejados, inimigosDesejado);

        // Zera a posição deles no vetor das posições e faz o movimento dependendo da
        // posição do player
        posicoes[posicaoInimigos[inimigosDesejado]] = 0;
        posicaoInimigos[inimigosDesejado] += verificarMovimento(posicao, inimigosDesejado);

        // Verificação antifalha
        limiteposicaoInimigos(inimigosDesejado, TamanhoJ);

        // Para saber qual inimigo que está colocando no vetor posições
        switch (inimigosDesejado) {
            case 0:
                posicoes[posicaoInimigos[inimigosDesejado]] = 2;
                break;
            case 1:
                posicoes[posicaoInimigos[inimigosDesejado]] = 7;
                break;
            case 2:
                posicoes[posicaoInimigos[inimigosDesejado]] = 3;
                break;
            default:
                posicoes[posicaoInimigos[inimigosDesejado]] = 2;
        }

        // Impressão do inimigo na matriz principal
        for (int i = 0; i < tamanhoI; i++) {

            for (int j = 0; j < TamanhoJ; j++) {

                mapa[(14 - tamanhoI) + i][posicaoInimigos[inimigosDesejado] + j] = personagem[i][j];

            }
        }

        qtdInimigos++;
    }

    public static void colocarPosicaoInimigos(int qtdInimigosDesejados, int inimigosDesejado) {
        // Aleatoriza a posição inicial do inimigo
        // posicao > tamanho/2 serve pra saber aonde colocar
        // qtdInimigos < qtdInimigosDesejados limite de inimigo
        // posicaoInimigos[inimigosDesejado] < 0 limitar quantas será colocado

        if (posicao >= (int) (TAMANHO / 2) && qtdInimigos <= qtdInimigosDesejados
                && posicaoInimigos[inimigosDesejado] < 0) {

            posicaoInimigos[inimigosDesejado] = (int) ((Math.random() * 80) + 5);

        } else if (posicao <= (int) (TAMANHO / 2) && qtdInimigos <= qtdInimigosDesejados
                && posicaoInimigos[inimigosDesejado] < 0) {

            posicaoInimigos[inimigosDesejado] = (int) ((Math.random() * 80) + 101);

        }

    }

    public static void limiteposicaoInimigos(int inimigosDesejado, int TamanhoJ) {
        // Verificação para ver se o inimigo está dentro dos limites
        // Força a posição do inimigo em um valor dentro dos limites

        if (posicaoInimigos[inimigosDesejado] <= 9) {
            posicaoInimigos[inimigosDesejado] = Math.abs(posicaoInimigos[inimigosDesejado]) + TamanhoJ;
        } else if (posicaoInimigos[inimigosDesejado] >= TAMANHO - TamanhoJ - 7) {
            posicaoInimigos[inimigosDesejado] = TAMANHO - TamanhoJ - 10;
        }

    }

    public static void limitePosicao() {
        // Verificação para ver se o player está dentro dos limites
        // Força a posição do player em um valor dentro dos limites
        if (posicao >= TAMANHO || posicao >= TAMANHO - 13) {
            posicao = 190;
            passarFase();
        } else if (posicao < 5) {
            posicao = (posicao + Math.abs(posicao)) + 0;
        }

    }

    public static int verificarMovimento(int posicao, int inimigosDesejado) {
        // Numero aleatorio serve para fazer a aleatoriedade
        int random = (int) (Math.random() * 10);
        // Movimentação do inimigo a direita
        if (posicao >= posicaoInimigos[inimigosDesejado] - MOVIMENTODOPLAYER) {
            // Movimentação aleatoria podendo ir da pra direita ou esquerda
            // para o inimigo ainda avançar o player nessa situação a chance de ir a direita
            // é maior

            if (random <= 7) {
                return ((int) ((Math.random() * MOVIMENTODOPLAYER) / 1.4));
            } else {
                return -((int) ((Math.random() * MOVIMENTODOPLAYER) / 1.4));
            }

        } // Movimentação do inimigo a esquerda
        else if (posicao <= posicaoInimigos[inimigosDesejado] + MOVIMENTODOPLAYER) {
            // Movimentação aleatoria podendo ir da pra direita ou esquerda
            // para o inimigo ainda avançar o player nessa situação a chance de ir a
            // esquerda
            // é maior

            if (random <= 7) {
                return -((int) ((Math.random() * MOVIMENTODOPLAYER) / 1.4));
            } else {
                return ((int) ((Math.random() * MOVIMENTODOPLAYER) / 1.4));
            }

        }

        return 0;
    }

    // Descobre a posição usado principalmente nos ataques
    public static int descobrirPosicao(int sinalizador) {
        switch (sinalizador) {
            case 1 -> {
                for (int i = 0; i < TAMANHO; i++) {
                    if (posicoes[i] == 1) {
                        return i;
                    }
                }
            }
            case 2 -> {
                for (int i = 0; i < TAMANHO; i++) {
                    if (posicoes[i] == 2) {
                        return i;
                    }
                }
            }
            case 3 -> {
                for (int i = 0; i < TAMANHO; i++) {
                    if (posicoes[i] == 3) {
                        return i;
                    }
                }
            }
            case 4 -> {
                for (int i = 0; i < TAMANHO; i++) {
                    if (posicoes[i] == 4) {
                        return i;
                    }
                }
            }
            case 5 -> {
                for (int i = 0; i < TAMANHO; i++) {
                    if (posicoes[i] == 5) {
                        return i;
                    }
                }
            }
            case 6 -> {
                for (int i = 0; i < TAMANHO; i++) {
                    if (posicoes[i] == 6) {
                        return i;
                    }
                }
            }
            case 7 -> {
                for (int i = 0; i < TAMANHO; i++) {
                    if (posicoes[i] == 7) {
                        return i;
                    }
                }
            }
            case 8 -> {
                for (int i = 0; i < TAMANHO; i++) {
                    if (posicoes[i] == 8) {
                        return i;
                    }
                }
            }
            default -> {
            }
        }
        return 0;
    }

    public static int controlePosicao(int posicao, char[][] mapa) {
        clicou = LER.next().charAt(0);
        posicoes[posicao] = 0;

        // Validação do digito
        while ((clicou != 'd' && clicou != 'D') && (clicou != 'a' && clicou != 'A') &&
                (clicou != 'r' && clicou != 'R') && (clicou != 'f' && clicou != 'F')) {
            setColor(1);
            System.out.println("\t\t\t\t\t\tDIGITO INVALIDO DIGITE NOVAMENTE");
            setColor(7);
            clicou = LER.next().charAt(0);
        }

        // Movimento do player e alteração do avatar para imitar sprites
        if (clicou == 'd' || clicou == 'D') {

            posicao += MOVIMENTODOPLAYER;
            personagem[4][0] = ' ';
            personagem[4][1] = ' ';
            personagem[4][2] = ' ';
            personagem[4][5] = '─';
            personagem[4][6] = '┌';
            personagem[4][7] = '─';
        } else if (clicou == 'a' || clicou == 'A') {

            posicao -= MOVIMENTODOPLAYER;
            personagem[4][0] = '─';
            personagem[4][1] = '┐';
            personagem[4][2] = '─';
            personagem[4][5] = ' ';
            personagem[4][6] = ' ';
            personagem[4][7] = ' ';
        }

        return posicao;
    }

    public static void imprimirAcoes(char ultimoClique) throws InterruptedException {
        temTiro = 0;
        imprimirTiro();
        limparTerminal();
        imprimirUI();
        imprimirEscudo();
    }

    public static void imprimirEscudo() {
        // Clique para o uso do escudo
        if (clicou == 'f' || clicou == 'F') {

            for (int i = 0; i < 8; i++) {

                for (int j = 0; j < TAMANHOX[2]; j++) {

                    // Verificação antifalha
                    if (dentroDaArea(posicao - (TAMANHOX[0] + 2)) || dentroDaArea(posicao + 6)) {

                        // Coloca o escudo a direita
                        if (ultimoClique == 'd' || ultimoClique == 'D') {

                            mapa[6 + i][posicao + j + 8] = escudoDireita[i][j];
                            posicoes[posicao + 5] = 6;
                        }

                        // Coloca o escudo a esquerda
                        if (ultimoClique == 'a' || ultimoClique == 'A') {

                            mapa[6 + i][posicao + j - 8] = escudoEsquerda[i][j];
                            posicoes[posicao - 5] = 6;
                        }
                    }
                }
            }
        }
    }

    public static void imprimirTiro() throws InterruptedException {
        int posicaoTiro = 0;
        // O uso da variavel "temTiro" serve para prevenir spam de tiros
        // Clique para uso da arma

        if (clicou == 'r' || clicou == 'R' || ultimoClique == 'r' || ultimoClique == 'R') {

            // Verificação antifalha
            if (dentroDaArea(posicao + (10 + TAMANHOX[1]))) {
                temTiro = 1;

                // Coloca o tira a direita
                if (ultimoClique == 'd' || ultimoClique == 'D') {
                    posicoes[posicao + (10 + TAMANHOX[1])] = 4;
                    posicaoTiro = descobrirPosicao(4);
                }
            }

            // Verificação antifalha
            if (dentroDaArea(posicao - (10 + TAMANHOX[1]))) {
                temTiro = 1;

                // Coloca o tiro para a esquerda
                if (ultimoClique == 'a' || ultimoClique == 'A') {

                    posicoes[posicao - (10 + TAMANHOX[1])] = 4;
                    posicaoTiro = descobrirPosicao(4);
                }
            }
        }

        animacaoTiro(posicaoTiro);

    }

    public static void animacaoTiro(int posicaoTiro) throws InterruptedException {
        int posTiroInicial = posicaoTiro;
        if (temTiro == 1) {

            while (dentroDaArea(posicaoTiro)) {

                limparTerminal();
                limparMatriz(mapa);
                imprimirUI();

                for (int i = 0; i < 3; i++) {

                    for (int j = 0; j < TAMANHOX[1]; j++) {

                        if (dentroDaArea(posicaoTiro)) {
                            // Atira o tira a direita
                            if (ultimoClique == 'd' || ultimoClique == 'D') {

                                mapa[8 + i][posicaoTiro + j] = balaDireita[i][j];

                            }

                            // Atira o tiro para a esquerda
                            if (ultimoClique == 'a' || ultimoClique == 'A') {

                                mapa[8 + i][posicaoTiro + j] = balaEsquerda[i][j];

                            }
                        }

                    }

                }

                // Faz o movimento do tiro
                if (ultimoClique == 'd' || ultimoClique == 'D') {

                    posicaoTiro += MOVIMENTODOPLAYER;
                }
                if (ultimoClique == 'a' || ultimoClique == 'A') {

                    posicaoTiro -= MOVIMENTODOPLAYER;
                }

                // Impressão do tiro
                controleDeFases(mapa);
                imprimirMapa(mapa);
                Thread.sleep(200);

                // Limite máximo
                if (posTiroInicial + (int) (TAMANHO / 2.5) <= posicaoTiro) {
                    break;
                }

                // Caso o valor esteja indo para a direita
                if (ultimoClique == 'd' || ultimoClique == 'D') {

                    // Verificação se o tiro chegou no inimigo1
                    if (descobrirPosicao(2) <= posicaoTiro && descobrirPosicao(2) != 0) {

                        vidaInimigo[0] -= danoBasePlayer;
                        break;
                    }

                    // Verificação se o tiro chegou no inimigo2
                    if (descobrirPosicao(7) <= posicaoTiro && descobrirPosicao(7) != 0) {

                        vidaInimigo[1] -= danoBasePlayer;
                        break;
                    }

                    // Verificação se o tiro chegou no boss
                    if (descobrirPosicao(3) <= posicaoTiro && descobrirPosicao(3) != 0) {

                        vidaInimigo[2] -= danoBasePlayer;
                        break;
                    }
                }

                // Caso o valor esteja indo para a esquerda
                if (ultimoClique == 'a' || ultimoClique == 'A') {

                    // Verificação se o tiro chegou no inimigo1
                    if (descobrirPosicao(2) >= posicaoTiro && descobrirPosicao(7) != 0) {

                        vidaInimigo[0] -= danoBasePlayer;
                        break;
                    }

                    // Verificação se o tiro chegou no inimigo2
                    if (descobrirPosicao(7) >= posicaoTiro && descobrirPosicao(7) != 0) {

                        vidaInimigo[1] -= danoBasePlayer;
                        break;
                    }

                    // Verificação se o tiro chegou no inimigo2
                    if (descobrirPosicao(3) >= posicaoTiro && descobrirPosicao(3) != 0) {

                        vidaInimigo[2] -= danoBasePlayer;
                        break;
                    }
                }

            }

        }
    }

    // O nome é bem claro mas é uma verificação para
    // passar de fase verificando se o player quer avançar
    public static void passarFase() {
        char passarFase;
        if (qtdInimigos == 0) {

            setColor(4);
            System.out.println(
                    "\t\t\t\t\tVOCÊ DESEJA AVANÇAR PARA A PRÓXIMA FASE? DIGITE 'e' PARA AVANÇAR PARA A PROXIMA FASE");
            setColor(7);
            passarFase = LER.next().charAt(0);

            if (passarFase == 'e' || passarFase == 'E') {
                fase++;
                // Reset dos vetores para iniciar o jogo
                posicao = 10;
                if (fase == 1 || fase == 3) {
                    vidaInimigo[0] = 2;
                    vidaInimigo[1] = 2;
                }

                posicaoInimigos[0] = -51;
                posicaoInimigos[1] = -51;

                // Reset dos turnos
                turnos = 0;
                turnoInicial = 0;
                entrou = true;

                // Zerando a posicao dos inimigos para não ter erros
                zerarValores(2);
                zerarValores(7);
                // Zerando a posição do ataque dos inimigos para prevenir erros
                zerarValores(5);
                zerarValores(8);

                if (fase == 2 || fase == 4) {
                    temUp[0] = true;
                    temUp[1] = true;
                }
            }
        }
    }

    // Serve para ter um controle fixo das fases escolhendo exatamente oque acontece
    public static void controleDeFases(char[][] mapa) throws InterruptedException {

        switch (fase) {

            // Primeiro level inicio e contar historia
            case 0:

                spawnarPlayer(posicao, mapa);
                spawnarHistoria();
                break;

            // segunda level começo do jogo
            case 1:

                spawnarPlayer(posicao, mapa);
                fase1SpawnarInimigo();
                break;

            // terceiro level UP
            case 2:

                spawnarPlayer(posicao, mapa);
                spawnarUps();
                break;

            // Quarto level Começa a aparecer mais inimigos
            case 3:

                spawnarPlayer(posicao, mapa);
                fase3SpawnarInimigo();
                fase3InimigoMorrer();
                break;

            // quinto level UP
            case 4:
                spawnarPlayer(posicao, mapa);
                spawnarUps();
                break;

            // quinto level spawna o boss
            case 5:
                spawnarPlayer(posicao, mapa);
                fase5SpawnarInimigo();
                fase5InimigoMorrer();
                break;

            case 6:
                spawnarPlayer(posicao, mapa);
                venceu = true;
                vivo = false;
                break;

            default:
                break;
        }

    }

    // Para poder deixar mais simples o caminho do código usei esses métodos para
    // limpar o método principal
    public static void fase1SpawnarInimigo() {
        if (vidaInimigo[0] > 0) {

            if (qtdInimigos >= 1) {

                qtdInimigos = 1;
            }
            temInimigos[0] = true;
            spawnarInimigo(mapa, 1, inimigoBase, TAMANHOY[3], TAMANHOX[3], 0);
        } else if (qtdInimigos != 0) {
            temInimigos[0] = false;
            qtdInimigos = 0;
        }
    }

    // Para poder deixar mais simples o caminho do código usei esses métodos para
    // limpar o método principal
    public static void fase3SpawnarInimigo() throws InterruptedException {
        if (vidaInimigo[0] > 0 || vidaInimigo[1] > 0) {

            if (qtdInimigos >= 2) {

                qtdInimigos = 2;
            }

            if (vidaInimigo[0] > 0) {

                temInimigos[0] = true;
                spawnarInimigo(mapa, 1, inimigoBase, TAMANHOY[3], TAMANHOX[3], 0);

            } else if (vidaInimigo[1] > 0) {
                zerarValores(5);
                zerarValores(2);
                temInimigos[1] = true;
                spawnarInimigo(mapa, 2, inimigoBase2, TAMANHOY[4], TAMANHOX[4], 1);

            }

        }
    }

    // Para poder deixar mais simples o caminho do código usei esses métodos para
    // limpar o método principal
    public static void fase3InimigoMorrer() {
        if (vidaInimigo[0] <= 0) {

            temInimigos[0] = false;
        } else if (vidaInimigo[1] <= 0) {

            temInimigos[1] = false;
        }

        if (qtdInimigos != 0 && vidaInimigo[0] <= 0 && vidaInimigo[1] <= 0) {

            qtdInimigos = 0;
        }
    }

    // Para poder deixar mais simples o caminho do código usei esses métodos para
    // limpar o método principal
    public static void fase5SpawnarInimigo() {
        if (vidaInimigo[2] > 0) {

            if (qtdInimigos >= 1) {

                qtdInimigos = 1;
            }

            if (vidaInimigo[2] > 0) {
                temInimigos[2] = true;
                spawnarInimigo(mapa, 1, boss, TAMANHOY[6], TAMANHOX[6], 2);

            }

        }
    }

    // Para poder deixar mais simples o caminho do código usei esses métodos para
    // limpar o método principal
    public static void fase5InimigoMorrer() {
        if (vidaInimigo[2] <= 0) {

            temInimigos[2] = false;
        }

        if (qtdInimigos != 0 && vidaInimigo[2] <= 0) {

            qtdInimigos = 0;
        }
    }

    public static boolean dentroDaArea(int posicaoXDesejado) {
        // Somente verifica se ta dentro da area para prevenir erros no caso
        // ArrayIndexOutOfBoundsException
        if (posicaoXDesejado >= TAMANHO - 13) {
            return false;
        } else if (posicaoXDesejado <= TAMANHOX[0] + 5) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("ManualArrayToCollectionCopy")
    public static void ataques(int ataqueDesejado) throws InterruptedException {
        boolean ataqueFeito = true;

        colocarPosicaoInimigo();
        verificarSeLevouDano(ataqueFeito);

        // AtaqueDesejado = 1 é pro inimigoBase1
        // AtaqueDesejado = 2 é pro inimigoBase2
        // AtaqueDesejado = 3 é pro boss

        // Imprimir o ataque do player
        if (ataqueDesejado == 1) {
            // Ataque do inimigo1 é um ataque mais simples aonde o inimigo somente atacará
            // se o player estiver perto
            if (descobrirPosicao(5) != 0 && ataqueFeito && vidaInimigo[0] >= 0 && fase > 0) {

                for (int i = 0; i < TAMANHOY[0x9]; i++) {
                    for (int j = 0; j < TAMANHOX[9]; j++) {
                        mapa[8 + i][descobrirPosicao(5) + j] = ataqueInimigo[i][j];
                    }
                }
            }

        } else if (ataqueDesejado == 2 && vidaInimigo[1] > 0 && fase == 3) {
            // Ataque do inimigo2 por ser um inimigo mais forte o ataque dele funciona por
            // turnos e tem o uso de uma "animação" para o seu ataque
            if (entrou) {
                turnoInicial = turnos;
                entrou = false;
            }

            if (turnos == turnoInicial + 5) {
                turnoInicial = turnos;
            }

            // Serve para prevenir de atacar quando não tem inimigo
            if (temInimigos[1]) {
                if (turnos == turnoInicial + 2) {
                    imprimirAviso(7);
                }
            }

            if (turnos == turnoInicial + 4) {
                fazerAtaqueComplexo(7);

            }

        } else if (ataqueDesejado == 3 && vidaInimigo[2] > 0 && fase == 5) {
            // Ataques do boss (incompleto)
            if (entrou) {
                turnoInicial = turnos;
                entrou = false;
            }

            if (turnos == turnoInicial + 5) {
                turnoInicial = turnos;
            }

            // Serve para prevenir de atacar quando não tem inimigo
            if (temInimigos[2]) {
                if (turnos == turnoInicial + 2) {
                    imprimirAviso(3);
                }
            }

            if (turnos == turnoInicial + 4) {
                fazerAtaqueComplexo(3);

            }

        }

        // Reset de valores prevenir erros
        zerarValores(5);
        zerarValores(8);
    }

    public static void imprimirAviso(int inimigoDesejado) {
        // Serve para colocar o aviso na matriz principal
        // Metódo usa inimigoDesejado para eu poder reaproveitar mais esse método
        for (int i = 0; i < TAMANHOY[7]; i++) {

            for (int j = 0; j < TAMANHOX[7]; j++) {
                if (posicao <= descobrirPosicao(inimigoDesejado)) {
                    mapa[5 + i][descobrirPosicao(inimigoDesejado) - 10 + j] = aviso[i][j];
                } else if (posicao >= descobrirPosicao(inimigoDesejado)) {
                    mapa[5 + i][descobrirPosicao(inimigoDesejado) - 10 + j] = aviso[i][j];
                }

            }
        }
    }

    public static void fazerAtaqueComplexo(int inimigosDesejado) throws InterruptedException {
        int posAtaque;
        int distAtaque = 5;
        // InimigoDesejado 1 é o inimigoBase2
        // InimigoDesejado 2 é o boss

        posAtaque = descobrirPosicao(inimigosDesejado);
        while (dentroDaArea(posAtaque)) {
            // DentroDaArea está servindo para não ocorrer de dar um valor fora da matriz
            imprimirUI();

            // Ataques a direita
            if (posicao >= descobrirPosicao(inimigosDesejado)) {

                // Semi-animação vai colocando traços de 5 em 5 (no caso distAtaque)
                if (posAtaque < TAMANHO - 20) {
                    for (int i = 0; i < distAtaque; i++) {
                        mapa[10][posAtaque + i + 10] = '─';
                        mapa[11][posAtaque + i + 10] = '─';
                    }
                }

                // Verificação para ver se tomou dano
                // Primeiro IF para ver se não tem escudo por isso o !
                // Segundo IF para saber se não passou muito da posição do player
                if (!(descobrirPosicao(6) <= posAtaque)) {
                    if (posAtaque >= posicao + 3) {
                        vida -= 3;
                        break;
                    }
                }

                // Serve para ver se tem escudo e se tem acaba o código para o tiro não ficar
                // passando do escudo
                if (descobrirPosicao(6) >= posAtaque && descobrirPosicao(6) != 0) {
                    break;
                }
                posAtaque += distAtaque;

            } // Ataques a esquerda
            else if (posicao <= descobrirPosicao(inimigosDesejado)) {

                // Semi-animação vai colocando traços de 5 em 5 (no caso distAtaque)
                if (posAtaque > TAMANHOX[0] + 5) {
                    for (int i = 0; i < distAtaque; i++) {
                        mapa[10][posAtaque + i - 10] = '─';
                        mapa[11][posAtaque + i - 10] = '─';
                    }
                }

                // Verificação para ver se tomou dano
                // Primeiro IF para ver se não tem escudo por isso o !
                // Segundo IF para saber se não passou muito da posição do player
                if (!(descobrirPosicao(6) >= posAtaque)) {
                    if (posAtaque <= posicao - 3) {
                        vida -= 3;
                        break;
                    }
                }

                // Serve para ver se tem escudo e se tem acaba o código para o tiro não ficar
                // passando do escudo
                if (descobrirPosicao(6) <= posAtaque && descobrirPosicao(6) != 0) {
                    break;
                }
                posAtaque -= distAtaque;

            }

            // Fim do código se está morto
            if (vida <= 0) {
                vivo = false;
            }

            imprimirMapa(mapa);
            Thread.sleep(300);
        }

    }

    public static void colocarPosicaoInimigo() {

        // Coloca o valor do ataque do inimigo no vetor das posições
        if (posicaoInimigos[0] <= posicao + 75 && posicaoInimigos[0] >= posicao - 75 && temInimigos[0]) {
            limiteposicaoInimigos(0, TAMANHOX[3]);
            if (posicao > posicaoInimigos[0]) {

                posicoes[posicaoInimigos[0] + 8] = 5;
            } else {
                posicoes[posicaoInimigos[0] - 8] = 5;
            }

        }

    }

    public static void verificarSeLevouDano(boolean ataqueFeito) {
        // verificar se levou o ataque
        if (descobrirPosicao(5) <= posicao + TAMANHOX[0] + 6 && descobrirPosicao(5) >= posicao - TAMANHOX[0] + 6) {

            ataqueFeito = false;
            verificarTemEscudo();

            if (vida <= 0) {
                vivo = false;
            }
        }
    }

    public static void verificarTemEscudo() {
        // verificar se tem escudo se não tem (por isso o not) leva dano
        if (!((descobrirPosicao(6) <= posicao + TAMANHOX[0] + 6)
                && (descobrirPosicao(6) >= posicao - TAMANHOX[0] + 6))
                && vidaInimigo[0] > 0) {

            vida--;

            // else if (!((descobrirPosicao(6) <= posicao + TAMANHOX[0] + 6)
            // && (descobrirPosicao(6) >= posicao - TAMANHOX[0] + 6))
            // && vidaInimigo[1] > 0) {

            // vida--;
        }
    }

    public static void zerarValores(int valorDesejado) {
        // Somente zera os valores para ao acabar a partida/momento não ocorrer erros
        for (int i = 0; i < TAMANHO; i++) {
            if (posicoes[i] == valorDesejado) {
                posicoes[i] = 0;
            }
        }
    }

    public static void imprimirInicio() {
        // Thumb usei metódo somente para deixar mais limpo o código ja que não é uma
        // ação que se repete muito
        limparTerminal();
        setColor(4);
        gotoXY(1, 80);
        System.out.println(" ██████   ██████    ██████████      █████████       █████████      ███████████");
        gotoXY(2, 80);
        System.out.println("░░██████ ██████    ░░███░░░░░█     ███░░░░░███     ███░░░░░███    ░█░░░███░░░█");
        gotoXY(3, 80);
        System.out.println(" ░███░█████░███     ░███  █ ░     ███     ░░░     ░███    ░███    ░   ░███  ░ ");
        gotoXY(4, 80);
        System.out.println(" ░███░░███ ░███     ░██████      ░███             ░███████████        ░███    ");
        gotoXY(5, 80);
        System.out.println(" ░███ ░░░  ░███     ░███░░█      ░███    █████    ░███░░░░░███        ░███    ");
        gotoXY(6, 80);
        System.out.println(" ░███      ░███     ░███ ░   █   ░░███  ░░███     ░███    ░███        ░███    ");
        gotoXY(7, 80);
        System.out.println(" █████     █████    ██████████    ░░█████████     █████   █████       █████   ");
        gotoXY(8, 80);
        System.out.println("░░░░░     ░░░░░    ░░░░░░░░░░      ░░░░░░░░░     ░░░░░   ░░░░░       ░░░░░    ");
        setColor(2);
        System.out.printf("\n\n 1.Iniciar");
        setColor(5);
        System.out.printf("\n\n 2.Como jogar\n\n");
        setColor(7);
    }

    public static void imprimirHistoria() throws InterruptedException {
        // Historia do jogo

        setColor(2);
        gotoXY(22, 80);
        System.out.println("+-+-+-+-+-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+-+-+");
        gotoXY(23, 80);
        System.out.println("|T|R|A|D|U|Z|I|N|D|O| |T|A|B|L|E|T|E|.|.|.|");
        gotoXY(24, 80);
        System.out.println("+-+-+-+-+-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+-+-+");

        setColor(3);
        System.out.println(
                "  No ano de 2097 com a revolução da IA o mundo começou a se alterar ao ponto que não era possivel ser o mesmo planeta de 2025 ");
        System.out.println(
                "  Mesmo que no inicio aparentasse ser algo acidental todo esse acontecimento foi planejado por TREBREH e OGAIHT");
        System.out.println(
                "  Que sorrateramente alteraram o codigo das IA's e desligaram a opção que faziam elas respeitarem os humanos assim começando o caos");
        System.out.println("  MAS para tentar impedir as maquinas foi criados os M.E.G.A's");

        setColor(1);
        System.out.println("  M\tMaquinas");
        setColor(2);
        System.out.println("  E\tEspeciais");
        setColor(3);
        System.out.println("  G\tGuardiões de");
        setColor(4);
        System.out.println("  A\tAmôntric\n\n");

        setColor(1);
        System.out.println("  VOCÊ é um desses MEGAS");
        System.out.println("  Seu objetivo desde a sua criação é defender Amôntric das maquinas corruptas");
        System.out.println(
                "  A sua missão atual é derrotar os inimigos em uma base secreta que supostamente está o TREBREH e o OGAIHT");
        Thread.sleep(15000);
    }

    public static void imprimirVenceu() {
        setColor(1);
        gotoXY(19, 80);
        System.out.println("PARABENS ");
        System.out.println(
                "Graças a sua batalha nós conseguimos acabar com a revolução das IA's e prender TREBREH E OGAIHT");
    }

    public static void imprimirTabletesUps() {
        // Somente coloca os tabletes na matriz principal os ups
        for (int i = 0; i < TAMANHOY[5]; i++) {

            for (int j = 0; j < TAMANHOX[5]; j++) {

                mapa[2 + i][(int) (TAMANHO / 3 + j)] = upDano[i][j];
            }
        }

        for (int i = 0; i < TAMANHOY[5]; i++) {

            for (int j = 0; j < TAMANHOX[5]; j++) {

                mapa[2 + i][(int) (TAMANHO / 1.2 + j)] = upVida[i][j];
            }
        }
    }

    public static void mortePlayer() throws InterruptedException {
        // Switch para ter certa historia com o player quando ele perde
        switch (fase) {
            case 1 -> {
                System.out.println("Foi uma boa tentativa que logo se desfez");
                Thread.sleep(15000);
            }
            case 3 -> {
                System.out.println("Que luta e que fim");
                Thread.sleep(15000);
            }
            case 5 -> {
                System.out.println("Espero que retorne para eu poder ver a sua derrota novamente");
                Thread.sleep(15000);
            }
            default -> throw new AssertionError();
        }
    }

    public static void iniciarVariaveis() {
        // Reset de variaveis e coloco os tamanhos x,y
        TAMANHOX[0] = personagem[0].length;
        TAMANHOX[1] = balaDireita[0].length;
        TAMANHOX[2] = escudoDireita[0].length;
        TAMANHOX[3] = inimigoBase[0].length;
        TAMANHOX[4] = inimigoBase2[0].length;
        TAMANHOX[5] = tableteTech[0].length;
        TAMANHOX[6] = boss[0].length;
        TAMANHOX[7] = aviso[0].length;
        TAMANHOX[8] = ataqueTrovoada[0].length;
        TAMANHOX[9] = ataqueInimigo[0].length;

        TAMANHOY[0] = personagem.length;
        TAMANHOY[1] = balaDireita.length;
        TAMANHOY[2] = escudoDireita.length;
        TAMANHOY[3] = inimigoBase.length;
        TAMANHOY[4] = inimigoBase2.length;
        TAMANHOY[5] = tableteTech.length;
        TAMANHOY[6] = boss.length;
        TAMANHOY[7] = aviso.length;
        TAMANHOY[8] = ataqueTrovoada.length;
        TAMANHOY[9] = ataqueInimigo.length;

        // Reset de algumas variaveis de inimigos
        vidaInimigo[0] = 2;
        vidaInimigo[1] = 3;
        vidaInimigo[2] = 6;
        posicaoInimigos[0] = -51;
        posicaoInimigos[1] = -51;
        posicaoInimigos[2] = -51;
        temUp[0] = true;
        temUp[1] = true;
    }

    public static void main(String[] args) throws InterruptedException {
        int inicioJogo = 0;
        iniciarVariaveis();
        while (vivo) {
            switch (inicioJogo) {
                case 1 -> {
                    // Inicio do jogo
                    imprimirJogo(fase);
                    limitePosicao();
                    turnos++;
                }
                case 2 -> {
                    // Comandos do jogo
                    instrucoes();
                    Thread.sleep(15000);
                    inicioJogo = 0;
                }
                default -> {
                    imprimirInicio();
                    inicioJogo = LER.nextInt();
                }
            }

            // Verificação se está dentro do permitido
            if (inicioJogo != 1 && inicioJogo != 2 && inicioJogo != 0) {
                imprimirInicio();
                System.out.println("\nCÓDIGO INVALIDO DIGITE NOVAMENTE");
                inicioJogo = LER.nextInt();
            }
        }

        if (vida <= 0) {
            mortePlayer();
        } else if (venceu) {
            imprimirVenceu();
        }

    }
}
