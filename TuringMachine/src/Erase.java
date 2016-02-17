/**
 * Created by nate on 12/14/15.
 */
public class Erase implements IAction {
    @Override
    public void Do(Tape tape) {
        tape.Erase();
    }
}
