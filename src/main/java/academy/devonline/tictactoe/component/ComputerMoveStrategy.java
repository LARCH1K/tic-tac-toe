package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.game.GameTable;
import academy.devonline.tictactoe.model.game.Sign;

public interface ComputerMoveStrategy {

    boolean tryToMakeMove(GameTable gameTable, Sign sign);
}
