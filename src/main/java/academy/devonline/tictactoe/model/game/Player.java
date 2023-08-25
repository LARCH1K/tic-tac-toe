package academy.devonline.tictactoe.model.game;

import academy.devonline.tictactoe.component.Move;

public class Player {
    private final Sign sign;

    private final Move move;

    public Player(final Sign sign, final Move move) {
        this.sign = sign;
        this.move = move;
    }


    public Sign getSign() {
        return sign;
    }

    public void makeMove(final GameTable gameTable) {
        move.make(gameTable, sign);
    }

    @Override
    public String toString() {
        return "'" + sign + "'";
    }
}
