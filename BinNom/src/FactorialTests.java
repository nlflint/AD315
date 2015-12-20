import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nate on 12/19/15.
 */
public class FactorialTests {
    @Test
    public void FiveFactorial() {
        int result = new Binom().factorial(5);
        assertEquals(120, result);
    }

    @Test
    public void OneFactorial() {
        int result = new Binom().factorial(1);
        assertEquals(1, result);
    }

    @Test
    public void TenFactorial() {
        int result = new Binom().factorial(10);
        assertEquals(3628800, result);
    }

    @Test
    public void ZeroFactorial() {
        int result = new Binom().factorial(0);
        assertEquals(1, result);
    }


}
