public abstract class AbstractPlayer implements Player{
    String name;
    Character symbol;

    public AbstractPlayer(String name, Character symbol){
        this.name = name;
        this.symbol = symbol;
    }
}
