import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class TicTacToe <X extends Player,O extends Player>{
    private Character[][] matrix;
    private int freeSpaces;
    private X playerOne;
    private O playerTwo;




    public TicTacToe(X playerOne, O playerTwo){
        matrix = new Character[][] {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
        freeSpaces = 9;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

    }

    public void play(){
        if(playerOne.getSymbol().equals(playerTwo.getSymbol())){
            System.out.println("Players have to choose different symbols from eacheother!!!");
            return;
        }

        boolean stillPlaying = true;
        Player nowPlaying = playerOne;
        while(stillPlaying){
            System.out.println("Now playing: " + nowPlaying.getName());
            printBoard();
            Coordinates inputCoordinates = nowPlaying.makeMove(matrix);
            freeSpaces--;
            matrix[inputCoordinates.getX()][inputCoordinates.getY()] = nowPlaying.getSymbol();
            Character end = checkForWinnerAndEnd(matrix,freeSpaces);

            stillPlaying = false;
            switch (end){
                case 'w':
                    System.out.println();
                    System.out.println("Winner: " + nowPlaying.getName() + "!!!");
                    break;
                case 'd':
                    System.out.println();
                    System.out.println("DRAW!!!");
                    break;
                default:
                    stillPlaying = true;
                    break;
            }

            if(stillPlaying == false){
                printBoard();
                System.out.println("New game: y-yes, n-no");
                Scanner input = new Scanner(System.in);
                String s = input.next();

                if(s.equals("y")){
                    cleanBoard();
                    freeSpaces = 9;
                    stillPlaying = true;
                }
            }

            nowPlaying = nowPlaying == playerOne? playerTwo : playerOne;
        }
    }

    public static Character checkForWinnerAndEnd(Character[][] matrix, int freeSpaces){
        //ako nije zavrseno vraca -
        //ako je nerijeseno vraca n
        

        if(
                (matrix[0][0]!= '-' && matrix[0][0] == matrix[0][1] && matrix[0][0] == matrix[0][2]) ||
                (matrix[0][2]!= '-' && matrix[0][2] == matrix[1][2] && matrix[0][2] == matrix[2][2]) ||
                (matrix[2][2]!= '-' && matrix[2][2] == matrix[2][1] && matrix[2][2] == matrix[2][0]) ||
                (matrix[2][0]!= '-' && matrix[2][0] == matrix[1][0] && matrix[2][0] == matrix[0][0]) ||
                (matrix[2][0]!= '-' && matrix[2][0] == matrix[1][1] && matrix[2][0] == matrix[0][2]) ||
                (matrix[0][0]!= '-' && matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2]) ||
                (matrix[1][0]!= '-' && matrix[1][0] == matrix[1][1] && matrix[1][0] == matrix[1][2]) ||
                (matrix[0][1]!= '-' && matrix[0][1] == matrix[1][1] && matrix[0][1] == matrix[2][1])

        ){
            return 'w';
        }

        if(freeSpaces==0) return 'd';

        return '-';
    }

    // 0,0 0,1 0,2
    // 1,0 1,1 1,2
    // 2,0 2,1 2,2

    private void printBoard(){
        System.out.println();
        System.out.println("  1 2 3");
        System.out.println("A " + matrix[0][0]  + "|" + matrix[0][1] + "|"
                + matrix[0][2]);
        System.out.println("  -----");
        System.out.println("B " + matrix[1][0] + "|" + matrix[1][1] + "|"
                + matrix[1][2]);
        System.out.println("  -----");
        System.out.println("C " + matrix[2][0] + "|" + matrix[2][1] + "|"
                + matrix[2][2]);
        System.out.println();
    }

    private void cleanBoard(){
        matrix = new Character[][] {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    }
}
