import java.util.HashMap;
import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer{

    private static HashMap<String,Coordinates> allowedFields;
    static {
        allowedFields = new HashMap<>();
        allowedFields.put("A1",new Coordinates(0,0));
        allowedFields.put("a1",new Coordinates(0,0));
        allowedFields.put("A2",new Coordinates(0,1));
        allowedFields.put("a2",new Coordinates(0,1));
        allowedFields.put("A3",new Coordinates(0,2));
        allowedFields.put("a3",new Coordinates(0,2));
        allowedFields.put("B1",new Coordinates(1,0));
        allowedFields.put("b1",new Coordinates(1,0));
        allowedFields.put("B2",new Coordinates(1,1));
        allowedFields.put("b2",new Coordinates(1,1));
        allowedFields.put("B3",new Coordinates(1,2));
        allowedFields.put("b3",new Coordinates(1,2));
        allowedFields.put("C1",new Coordinates(2,0));
        allowedFields.put("c1",new Coordinates(2,0));
        allowedFields.put("C2",new Coordinates(2,1));
        allowedFields.put("c2",new Coordinates(2,1));
        allowedFields.put("C3",new Coordinates(2,2));
        allowedFields.put("c3",new Coordinates(2,2));

    }

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

        String field = null;
        Coordinates coord = null;
        while(!freeFieldChoosen){

            System.out.println("Field: (ex. A1, a1)");
            try{
                field = input.next();
                Coordinates temp = allowedFields.get(field);
                if(temp == null){
                    System.out.println("Invalid field!!!");
                }else{
                    int x = temp.getX();
                    int y = temp.getY();
                    if(matrix[x][y]!='-'){
                        System.out.println("Field already taken!!!");
                    }else{
                        coord = temp;
                        freeFieldChoosen = true;
                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }
        // A1 A2 A3
        // B1 B2 B3
        // C1 C2 C3

        return coord;
    }

    @Override
    public String getName() {
        return name;
    }
}
