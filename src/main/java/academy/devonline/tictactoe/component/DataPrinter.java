package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable;

public interface DataPrinter {

    void printInstructions();

    void printInfoMessage(String message);

    void printErrorMessage(String message);

    void printGameTable(GameTable gameTable);
}
