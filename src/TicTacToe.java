import java.util.Scanner;

public class TicTacToe <X extends Player,O extends Player>{
    Character[][] matrix;
    int freeSpaces;
    private X playerOne;
    private O playerTwo;
    public TicTacToe(X playerOne, O playerTwo){
        matrix = new Character[][] {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
        freeSpaces = 9;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

    }

    public void play(){

        boolean stillPlaying = true;
        Player nowPlaying = playerOne;
        while(stillPlaying){
            System.out.println("Now playing: " + nowPlaying.getName());
            printBoard();
            Coordinates inputCoordinates = nowPlaying.makeMove(matrix);
            freeSpaces--;
            matrix[inputCoordinates.getX()][inputCoordinates.getY()] = nowPlaying.getSymbol();
            Character end = checkForWinnerAndEnd();

            stillPlaying = false;
            switch (end){
                case 'o':
                case 'x':
                    System.out.println("Winner: " + nowPlaying.getName() + "!!!");
                    break;
                case 'n':
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

    private Character checkForWinnerAndEnd(){
        //ako nije zavrseno vraca -
        //ako je nerijeseno vraca n

        if(
                (matrix[0][0]=='o' && matrix[0][1]=='o' && matrix[0][2]=='o') ||
                (matrix[0][2]=='o' && matrix[1][2]=='o' && matrix[2][2]=='o') ||
                (matrix[2][2]=='o' && matrix[2][1]=='o' && matrix[2][0]=='o') ||
                (matrix[2][0]=='o' && matrix[1][0]=='o' && matrix[0][0]=='o') ||
                (matrix[2][0]=='o' && matrix[1][1]=='o' && matrix[0][2]=='o') ||
                (matrix[0][0]=='o' && matrix[1][1]=='o' && matrix[2][2]=='o') ||
                (matrix[1][0]=='o' && matrix[1][1]=='o' && matrix[1][2]=='o') ||
                (matrix[0][1]=='o' && matrix[1][1]=='o' && matrix[2][1]=='o')


        ){
            return 'o';
        }

        if(
                (matrix[0][0]=='x' && matrix[0][1]=='x' && matrix[0][2]=='x') ||
                (matrix[0][2]=='x' && matrix[1][2]=='x' && matrix[2][2]=='x') ||
                (matrix[2][2]=='x' && matrix[2][1]=='x' && matrix[2][0]=='x') ||
                (matrix[2][0]=='x' && matrix[1][0]=='x' && matrix[0][0]=='x') ||
                (matrix[2][0]=='x' && matrix[1][1]=='x' && matrix[0][2]=='x') ||
                (matrix[0][0]=='x' && matrix[1][1]=='x' && matrix[2][2]=='x') ||
                (matrix[1][0]=='x' && matrix[1][1]=='x' && matrix[1][2]=='x') ||
                (matrix[0][1]=='x' && matrix[1][1]=='x' && matrix[2][1]=='x')

        ){
            return 'x';
        }

        if(freeSpaces==0) return 'n';

        return '-';
    }

    // 0,0 0,1 0,2
    // 1,0 1,1 1,2
    // 2,0 2,1 2,2

    private void printBoard(){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j< matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private void cleanBoard(){
        matrix = new Character[][] {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    }
}
