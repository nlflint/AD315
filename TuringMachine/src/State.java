import java.util.ArrayList;

/**
 * Created by nate on 12/14/15.
 */
public class State {
    public final String Name;
    public final IPredicate Predicate;
    private final ArrayList<IAction> Actions;
    public final String NextState;

    public State(String name, IPredicate predicate, ArrayList<IAction> actions, String nextState) {
        Name = name;
        this.Predicate = predicate;
        this.Actions = actions;
        NextState = nextState;
    }

    public void DoAllActions(Tape tape) {
        for (IAction action : Actions) {
            action.Do(tape);
        }
    }
}
