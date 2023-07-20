import java.util.Scanner;

class Board {
    int count = 0;
    String board[] = { " ", " ", " ", " ", " ", " ", " ", " ", " " };

    void printBoard() {
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);

    }

    boolean updateBoard(int position, String type) {
        if(board[position - 1] == " ") {
            board[position - 1] = type;
            count++;
            return true;
        } else {
            System.out.println("Vi tri da duoc chon");
            return false;
        }
    }

    boolean checkDraw() {
        if(count == 9) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkWinner(String type) {
        if(board[0] == type && board[1] == type && board[2] == type
            || board[3] == type && board[4] == type && board[5] == type
            || board[6] == type && board[7] == type && board[8] == type
            || board[0] == type && board[3] == type && board[6] == type
            || board[1] == type && board[4] == type && board[7] == type
            || board[2] == type && board[5] == type && board[8] == type
            || board[0] == type && board[4] == type && board[8] == type
            || board[2] == type && board[4] == type && board[6] == type) {
            return true;
        } else {
            return false;
        }
    }
}

class Player {
    String name;
    String type;

    Player(String type) {
        this.type = type;
        Scanner sc = new Scanner(System.in);
        if(type == "X") {
            System.out.print("Nguoi choi 1 chon X, vui long nhap ten: ");
            name = sc.nextLine();
        } else {
            System.out.print("Nguoi choi 2 chon O, vui long nhap ten: ");
            name = sc.nextLine();
        }
    }

}

class Game {
    Board board = new Board();
    Player player1 = new Player("X");
    Player player2 = new Player("O");
    Player currentPlayer = player1;

    void play() {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print(currentPlayer.name + " nhap vi tri tu (1 - 9): ");
            int position = sc.nextInt();

            if(board.updateBoard(position, currentPlayer.type)) {
                board.printBoard();

                if(board.checkWinner(currentPlayer.type)) {
                    System.out.println(currentPlayer.name + " win!");
                    break;
                }

                if(board.checkDraw()) {
                    System.out.println("Hoa!");
                    break;
                }

                if(currentPlayer == player1) {
                    currentPlayer = player2;
                } else {
                    currentPlayer = player1;
                }
            }
        }
    }
}

public class co_caro {
    public static void main(String[] args) {
        while (true) {
            Game g1 = new Game();
            g1.play();
            Scanner sc = new Scanner(System.in);
            System.out.print("Ban co muon choi lai (y/n): ");
            String temp = sc.nextLine();
            temp = temp.toLowerCase();
            if(!(temp.equals("y"))) {
                System.out.println("Tam biet!!");
                break;
            }
        }
    }
}