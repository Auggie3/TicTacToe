public class Test {
    public static void main(String[] args) {
        //mogu samo da se koriste mala slova 'o' i 'x'
        HumanPlayer p1 = new HumanPlayer("Gio",'x');
        ComputerPlayer p2 = new ComputerPlayer("COM", 'o');
        //HumanPlayer p2 = new HumanPlayer("Gio2",'o');
        TicTacToe<Player,Player> game = new TicTacToe<Player,Player>(p1,p2);
        game.play();
    }
}
