package academy.devonline.tictactoe.component.strategy;

import academy.devonline.tictactoe.model.game.Sign;

public class WinOnTheNextStepComputerMoveStrategy extends AbstractComputerMoveStrategy {
    public WinOnTheNextStepComputerMoveStrategy() {
        super(2);
    }

    @Override
    protected Sign getFindSign(final Sign moveSign) {
        return moveSign;
    }
}
