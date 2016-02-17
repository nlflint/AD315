/**
 * Created by nate on 12/14/15.
 */
public class Game {
    private State First;
    private State Second;
    private State Third;
    private State NewGame;
    private Turn Fifth;
    private int marblesRemaining = 11;

    public Result TakeTurn() {
        TakeMarble();
        doFirst();
        if (marblesRemaining == 0)
            return Result.Lose;
    }

    private Result doFirst() {
        if (First.equals(State.Left)) {
            First = toggle(First);
            return DoNewGame();
        }

    }

    private Result DoNewGame() {
        if (NewGame.equals(State.Right)) {
            return Result.GoAgain;
        }
        return TakeTurn();
    }

    private State toggle(State first) {
        return first.equals(State.Left) ? State.Right : State.Left;
    }

    private void TakeMarble() {
        marblesRemaining--;
    }

    enum State {
        Left,
        Right
    }

    enum Turn {
        Me,
        DrNim
    }

    enum Result {
        Win,
        Lose,
        GoAgain
    }

}
