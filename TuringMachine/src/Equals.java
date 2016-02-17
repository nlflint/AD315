import sun.jvm.hotspot.debugger.cdbg.Sym;

/**
 * Created by nate on 12/14/15.
 */
public class Equals implements IPredicate {
    private final String Symbol;
    public Equals(String symbol) {
        Symbol = symbol;
    }

    @Override
    public boolean isTrue(String symbol) {
        return Symbol.equals(symbol);
    }
}
