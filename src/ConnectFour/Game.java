package ConnectFour;

public class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private GameState state;
    private Player winner;

    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.board = new Board();
        this.state = GameState.IN_PROGRESS;
    }

    public boolean makeMove(Player player, int col){
        if (state != GameState.IN_PROGRESS){
            return false;
        }
        if (player != currentPlayer){
            return false;
        }

        int row = board.placeDisk(col, player.getColor());

        if (row == -1){
            return false;
        }

        if (board.checkWin(row, col, player.getColor())){
            state = GameState.WON;
            winner = player;
        }
        else if (board.isFull()) {
            state = GameState.DRAW;
        }
        else {
            currentPlayer = (player == player1) ? player2 : player1;
        }

        return true;
    }
}
