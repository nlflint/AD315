/**
 * Created by nate on 12/14/15.
 */
public class NotBlank implements IPredicate {

    @Override
    public boolean isTrue(String symbol) {
        return !symbol.equals("");
    }
}
