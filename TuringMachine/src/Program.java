import java.util.ArrayList;

/**
 * Created by nate on 12/14/15.
 */
public class Program {
    public static void main(String[] args) {
        Tape tape = new Tape();
        ArrayList<State> states = States.CountingSequence();
        Machine machine = new Machine(states, tape);

        machine.Process("b", 1000);

        System.out.println(tape.toString());

    }
}
