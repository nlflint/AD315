import java.util.ArrayList;

/**
 * Created by nate on 12/14/15.
 */
public class Machine {
    private final ArrayList<State> states;
    private final Tape tape;

    public Machine(ArrayList<State> rules, Tape tape) {
        this.states = rules;
        this.tape = tape;
    }

    public void Process(String initialState, int iterations) {

        String nextState = initialState;

        for (int i = 0; i < iterations; i++) {
            String currentValue = tape.Read();
            State currentState = FindRuleByNameAndCurrentValue(nextState, currentValue);
            currentState.DoAllActions(tape);
            nextState = currentState.NextState;
        }
    }

    private State FindRuleByNameAndCurrentValue(String stateName, String currentValue) {
        for(State state : states) {
            if (state.Name.equals(stateName) && state.Predicate.isTrue(currentValue))
                return state;
        }
        throw new RuntimeException("State not found: " + stateName + " Value: " + currentValue);
    }
}
