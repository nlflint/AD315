import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by nate on 12/14/15.
 */
public class Tape {
    private final ArrayList<String> _tape;
    private int currentIndex = 0;

    public Tape()
    {
        _tape = new ArrayList<String>(Collections.nCopies(1000, ""));
    }

    public void Print(String symbol) {
        _tape.set(currentIndex, symbol);
    }

    public void Right() {
        currentIndex++;
    }

    public String Read() {
        return _tape.get(currentIndex);
    }

    @Override
    public String toString() {
        return _tape.toString();
    }

    public void Left() {
        currentIndex--;
    }

    public void Erase() {
        _tape.set(currentIndex, "");
    }
}
