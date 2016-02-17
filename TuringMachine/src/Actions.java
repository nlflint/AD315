/**
 * Created by nate on 12/14/15.
 */
public class Actions {
    public static IAction Right = new Right();
    public static IAction Left = new Left();
    public static IAction Erase = new Erase();

    public static IAction Print(String symbol) {
        return new Print(symbol);
    }
}
