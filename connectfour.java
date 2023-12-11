import java.util.Scanner;

public class connectfour {

    private static final int ROWS = 6;
    private static final int COLUMNS = 7;

    private char[][] board;
    private char currentPlayer;

    public connectfour() {
        board = new char[ROWS][COLUMNS];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    private boolean dropPiece(int column) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == '-') {
                board[i][column] = currentPlayer;
                return true;
            }
        }
        return false; // Column is full
    }

    private boolean checkForWin() {
        // Check for horizontal win
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == currentPlayer &&
                        board[i][j + 1] == currentPlayer &&
                        board[i][j + 2] == currentPlayer &&
                        board[i][j + 3] == currentPlayer) {
                    return true;
                }
            }
        }

        // Check for vertical win
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == currentPlayer &&
                        board[i + 1][j] == currentPlayer &&
                        board[i + 2][j] == currentPlayer &&
                        board[i + 3][j] == currentPlayer) {
                    return true;
                }
            }
        }

        // Check for diagonal win (from top-left to bottom-right)
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == currentPlayer &&
                        board[i + 1][j + 1] == currentPlayer &&
                        board[i + 2][j + 2] == currentPlayer &&
                        board[i + 3][j + 3] == currentPlayer) {
                    return true;
                }
            }
        }

        // Check for diagonal win (from top-right to bottom-left)
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 3; j < COLUMNS; j++) {
                if (board[i][j] == currentPlayer &&
                        board[i + 1][j - 1] == currentPlayer &&
                        board[i + 2][j - 2] == currentPlayer &&
                        board[i + 3][j - 3] == currentPlayer) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == '-') {
                    return false; // Board is not full
                }
            }
        }
        return true; // Board is full
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard();

            System.out.println("Player " + currentPlayer + ", enter your move (column 0-6): ");
            int column = scanner.nextInt();

            if (column < 0 || column >= COLUMNS || !dropPiece(column)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            if (checkForWin()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }

        scanner.close();
    }

    public static void main(String[] args) {
        connectfour game = new connectfour();
        game.play();
    }
}
