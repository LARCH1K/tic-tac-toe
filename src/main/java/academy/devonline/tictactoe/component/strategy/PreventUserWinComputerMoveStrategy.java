package academy.devonline.tictactoe.component.strategy;

import academy.devonline.tictactoe.component.ComputerMoveStrategy;
import academy.devonline.tictactoe.model.game.Cell;
import academy.devonline.tictactoe.model.game.GameTable;
import academy.devonline.tictactoe.model.game.Sign;

public class PreventUserWinComputerMoveStrategy implements ComputerMoveStrategy {

    @Override
    public boolean tryToMakeMove(final GameTable gameTable, final Sign sign) {
        return tryToMakeMoveByRows(gameTable, sign) ||
                tryToMakeMoveByCols(gameTable, sign) ||
                tryToMakeMoveByMainDiagonal(gameTable, sign) ||
                tryToMakeMoveBySecondaryDiagonal(gameTable, sign);
    }

    private boolean tryToMakeMoveBySecondaryDiagonal(final GameTable gameTable, final Sign sign) {
        return tryToMakeMoveUsingLambdaConversion(gameTable, sign, -1, (k, j) -> new Cell(j, 2 - j));
    }

    private boolean tryToMakeMoveByMainDiagonal(final GameTable gameTable, final Sign sign) {
        return tryToMakeMoveUsingLambdaConversion(gameTable, sign, -1, (k, j) -> new Cell(j, j));
    }

    private boolean tryToMakeMoveByCols(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (tryToMakeMoveUsingLambdaConversion(gameTable, sign, i, (k, j) -> new Cell(j, k))) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("Convert2MethodRef")
    private boolean tryToMakeMoveByRows(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (tryToMakeMoveUsingLambdaConversion(gameTable, sign, i, (k, j) -> new Cell(k, j))) {
                return true;
            }
        }
        return false;
    }


    private boolean tryToMakeMoveUsingLambdaConversion(final GameTable gameTable,
                                                       final Sign sign,
                                                       final int i,
                                                       final PreventUserWinComputerMoveStrategy.Lambda lambda) {
        int countEmptyCells = 0;
        int countSignCells = 0;
        Cell lastEmptyCell = null;
        for (int j = 0; j < 3; j++) {
            final Cell cell = lambda.convert(i, j);
            if (gameTable.isEmpty(cell)) {
                lastEmptyCell = cell;
                countEmptyCells++;
            } else if (gameTable.getSign(cell) == sign.oppositeSign()) {
                countSignCells++;
            } else {
                break;
            }
        }
        if (countEmptyCells == 1 && countSignCells == 2) {
            gameTable.setSign(lastEmptyCell, sign);
            return true;
        }
        return false;
    }

    @FunctionalInterface
    private interface Lambda {
        Cell convert(int k, int j);
    }

}
