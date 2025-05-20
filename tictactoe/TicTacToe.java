import java.util.Scanner;

class Board {
    private char[][] board;
    private final int SIZE = 3;

    public Board() {
        board = new char[SIZE][SIZE];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = ' ';
    }

    public void displayBoard() {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
                if (j < SIZE - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < SIZE - 1)
                System.out.println("---+---+---");
        }
        System.out.println();
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == ' ';
    }

    public void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public boolean checkWin(char symbol) {
        // Check rows & columns
        for (int i = 0; i < SIZE; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol))
                return true;
        }

        // Check diagonals
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
               (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    public boolean isDraw() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }
}

class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}

class Game {
    private Board board;
    private Player player1, player2;
    private Scanner scanner;

    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.print("Enter name for Player 1 (X): ");
        player1 = new Player(scanner.nextLine(), 'X');
        System.out.print("Enter name for Player 2 (O): ");
        player2 = new Player(scanner.nextLine(), 'O');

        Player currentPlayer = player1;
        boolean gameEnded = false;

        while (!gameEnded) {
            board.displayBoard();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
            int row, col;

            while (true) {
                System.out.print("Enter row (0-2): ");
                row = scanner.nextInt();
                System.out.print("Enter column (0-2): ");
                col = scanner.nextInt();

                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Invalid input. Please enter row and column between 0 and 2.");
                } else if (!board.isCellEmpty(row, col)) {
                    System.out.println("Cell already taken. Try again.");
                } else {
                    break;
                }
            }

            board.placeMove(row, col, currentPlayer.getSymbol());

            if (board.checkWin(currentPlayer.getSymbol())) {
                board.displayBoard();
                System.out.println("Congratulations " + currentPlayer.getName() + "! You win!");
                gameEnded = true;
            } else if (board.isDraw()) {
                board.displayBoard();
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }
    }
}

class TicTacToe{
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
