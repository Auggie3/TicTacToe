import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        //mogu samo da se koriste mala slova 'o' i 'x'
        HumanPlayer p1 = new HumanPlayer("Gio",'x');
        //ComputerPlayer p2 = new ComputerPlayer("COM", 'Y');
        //ComputerPlayer p3 = new ComputerPlayer("COM2", 'p');
        //HumanPlayer p2 = new HumanPlayer("Gio2",'o');

        ComputerExpertPlayer expert = new ComputerExpertPlayer("SmartCOM", 'o');
        //TicTacToe<Player,Player> game = new TicTacToe<Player,Player>(new ComputerExpertPlayer("SmarterCom",'x'),expert);
        TicTacToe<Player,Player> game = new TicTacToe<Player,Player>(p1,expert);
        game.play();
    }
}
