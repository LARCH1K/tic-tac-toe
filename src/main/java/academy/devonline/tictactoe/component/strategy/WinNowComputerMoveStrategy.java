package academy.devonline.tictactoe.component.strategy;

import academy.devonline.tictactoe.model.game.Sign;

public class WinNowComputerMoveStrategy extends AbstractComputerMoveStrategy {
    public WinNowComputerMoveStrategy() {
        super(1);
    }

    @Override
    protected Sign getFindSign(final Sign moveSign) {
        return moveSign;
    }
}
