package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.component.console.ConsoleDataPrinter;
import academy.devonline.tictactoe.component.console.ConsoleUserInputReader;
import academy.devonline.tictactoe.component.keypad.DesktopNumericKeypadCellNumberConverter;
import academy.devonline.tictactoe.component.swing.GameWindow;
import academy.devonline.tictactoe.model.Player;
import academy.devonline.tictactoe.model.PlayerType;


import static academy.devonline.tictactoe.model.PlayerType.USER;
import static academy.devonline.tictactoe.model.Sign.O;
import static academy.devonline.tictactoe.model.Sign.X;

public class GameFactory {

    private final PlayerType player1Type;

    private final PlayerType player2Type;


    public GameFactory(final String[] args) {
        final CommandLineArgumentParser.PlayerTypes playerTypes = new CommandLineArgumentParser(args).parser();
        this.player1Type = playerTypes.getPlayer1Type();
        this.player2Type = playerTypes.getPlayer2Type();
    }

    public Game create() {

        final GameWindow gameWindow = new GameWindow();
        final DataPrinter dataPrinter= gameWindow;
        final UserInputReader userInputReader=gameWindow;

//        final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
//        final DataPrinter dataPrinter= new ConsoleDataPrinter(cellNumberConverter);
//        final UserInputReader userInputReader=new ConsoleUserInputReader(cellNumberConverter,dataPrinter);

        final Player player1;
        if (player1Type == USER) {
            player1 = new Player(X, new UserMove(userInputReader,dataPrinter));
        } else {
            player1 = new Player(X, new ComputerMove());
        }
        final Player player2;
        if (player2Type == USER) {
            player2 = new Player(O, new UserMove(userInputReader,dataPrinter));
        } else {
            player2 = new Player(O, new ComputerMove());
        }
        final boolean canSecondPlayerMakeFirstMove = player1Type != player2Type;
        return new Game(
                dataPrinter,
                player1,
                player2,
                new WinnerVerifier(),
                new CellVerifier(),
                canSecondPlayerMakeFirstMove);
    }
}
