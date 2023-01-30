import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer extends AbstractPlayer{

    public ComputerPlayer(String name, Character symbol){
        super(name,symbol);
    }

    @Override
    public Character getSymbol() {
        return symbol;
    }

    @Override
    public Coordinates makeMove(Character[][] matrix) {
        List<Coordinates> positionList = new ArrayList<Coordinates>();
        for (int i = 0 ; i<3 ; i++){
            for(int j = 0 ; j<3 ; j++){
                if(matrix[i][j].equals('-')){
                    positionList.add(new Coordinates(i,j));
                }
            }
        }

        Random random = new Random();
        int randomValue = random.nextInt(positionList.size());
        return positionList.get(randomValue);
    }

    @Override
    public String getName() {
        return name;
    }
}
