/**
 * Created by nate on 12/14/15.
 */
public class Predicates {
    public static IPredicate NotBlank = new NotBlank();
    public static IPredicate Blank = new Blank();

    public static IPredicate Equals(String symbol) {
        return new Equals(symbol);
    }
}
