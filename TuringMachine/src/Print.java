/**
 * Created by nate on 12/14/15.
 */
public class Print implements IAction {
    private final String Symbol;
    public Print(String symbol) {
        Symbol = symbol;
    }

    @Override
    public void Do(Tape tape) {
        tape.Print(Symbol);
    }
}
