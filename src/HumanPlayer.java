import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer{

    public HumanPlayer(String name, Character symbol){
        super(name, symbol);
    }

    @Override
    public Character getSymbol() {
        return symbol;
    }

    @Override
    public Coordinates makeMove(Character[][] matrix) {

        Scanner input = new Scanner(System.in);

        boolean freeFieldChoosen = false;

        int x = 0;
        int y = 0;
        String warning = "";

        while(!freeFieldChoosen){
            System.out.println("Field:" + warning);
            x = input.nextInt();
            y = input.nextInt();
            if(matrix[x][y].equals('-')) freeFieldChoosen = true;
            else warning = "(again)";
        }


        return new Coordinates(x,y);
    }

    @Override
    public String getName() {
        return name;
    }
}
