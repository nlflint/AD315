import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nate on 12/19/15.
 */
public class Method3Tests {
    @Test
    public void FiveChooseThree() {
        int result = new Binom().method3(5, 3);
        Assert.assertEquals(10, result);
    }

    @Test
    public void SevenChooseFour() {
        int result = new Binom().method3(7, 4);
        Assert.assertEquals(35, result);
    }

    @Test
    public void FourChooseFour() {
        int result = new Binom().method3(4, 4);
        Assert.assertEquals(1, result);
    }

    @Test
    public void SevenChooseZero() {
        int result = new Binom().method3(7, 0);
        Assert.assertEquals(1, result);
    }

    @Test
    public void ZeroChooseZero() {
        int result = new Binom().method3(0, 0);
        Assert.assertEquals(1, result);
    }
}
