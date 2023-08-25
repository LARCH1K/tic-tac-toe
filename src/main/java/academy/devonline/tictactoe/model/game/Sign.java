package academy.devonline.tictactoe.model.game;

public enum Sign {

    X,

    O,

    EMPTY;

    @Override
    public String toString() {
        if (this == EMPTY) {
            return " ";
        } else {
            return name();
        }
    }
}
