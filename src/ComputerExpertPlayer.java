import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ComputerExpertPlayer extends ComputerPlayer{

    class Line{
        HashSet<Coordinates> positions;
        Line(int x1, int y1,int x2,int y2, int x3, int y3) {
            positions = new HashSet<>();
            positions.add(new Coordinates(x1,y1));
            positions.add(new Coordinates(x2,y2));
            positions.add(new Coordinates(x3,y3));

        }
    }

    HashSet<Line> vert;
    HashSet<Line> hor;
    HashSet<Line> slant;
    HashSet<Line> allLines;
    List<Coordinates> corners;

    {
        vert = new HashSet<>();
        vert.add(new Line(0,0, 1,0, 2,0));
        vert.add(new Line(0,1, 1,1, 2,1));
        vert.add(new Line(0,2, 1,2, 2,2));

        hor = new HashSet<>();
        hor.add(new Line(0,0, 0,1, 0,2));
        hor.add(new Line(1,0, 1,1, 1,2));
        hor.add(new Line(2,0, 2,1, 2,2));

        slant = new HashSet<>();
        slant.add(new Line(0,0,1,1,2,2));
        slant.add(new Line(0,2,1,1,2,0));

        allLines = new HashSet<>();
        allLines.addAll(vert);
        allLines.addAll(hor);
        allLines.addAll(slant);

        corners = new ArrayList<>();
        corners.add(new Coordinates(0,0));
        corners.add(new Coordinates(0,2));
        corners.add(new Coordinates(2,0));
        corners.add(new Coordinates(2,2));
    }

    private Character enemySymbol;


    public ComputerExpertPlayer(String name, Character symbol) {
        super(name, symbol);
    }

    @Override
    public Coordinates makeMove(Character[][] matrix) {
        enemySymbol = getEnemySymbol(matrix);
        return nextMove(matrix);
    }

    private Coordinates nextMove(Character[][] matrix){

        if(freeSpaces(matrix) == 9){
            Random random = new Random();
            int r = random.nextInt(corners.size());
            return corners.get(r);
        }

        for (Line l:
             allLines) {

            if(inLine(matrix,l,symbol)==2 && inLine(matrix,l,enemySymbol)==0){
                for (Coordinates c: l.positions){
                    int i = c.getX();
                    int j = c.getY();
                    if(matrix[i][j]!=symbol) return c;
                }
            }

        }

        for (Line l:
             allLines) {

            if(inLine(matrix,l,symbol)==0 && inLine(matrix,l,enemySymbol)==2){
                for (Coordinates c: l.positions){
                    int i = c.getX();
                    int j = c.getY();
                    if(matrix[i][j]!=enemySymbol) return c;
                }
            }

        }

        if(matrix[1][1]=='-' && inCorners(matrix, enemySymbol)>0){
            return  new Coordinates(1,1);
        }

        return super.makeMove(matrix);
    }

    private int inCorners(Character[][] matrix,Character s){
        int temp=0;
        for(Coordinates c: corners){
            int i = c.getX();
            int j = c.getY();
            if(matrix[i][j] == s) temp++;
        }

        return temp;
    }



    private int inLine(Character[][] matrix, Line l, Character s){
        int temp=0;
        for(Coordinates c: l.positions){
            int i = c.getX();
            int j = c.getY();
            if(matrix[i][j]==s) temp++;
        }

        return temp;
    }


    private int freeSpaces(Character[][] matrix){
        int free = 0;
        for(Character[] arr : matrix){
            for (Character c : arr){
                if(c.equals('-')) free++;
            }
        }

        return free;
    }

    private Character getEnemySymbol(Character[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                Character c = matrix[i][j];
                if(c!='-' && c!=symbol) return c;
            }
        }

        return symbol=='x'?'o':'x';
    }


}
