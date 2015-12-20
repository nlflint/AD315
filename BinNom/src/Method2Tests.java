import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nate on 12/19/15.
 */
public class Method2Tests {
    @Test
    public void Method2_FiveChooseThree() {
        int result = new Binom().method2(5,3);
        Assert.assertEquals(10, result);
    }

    @Test
    public void Method2_SevenChooseFour() {
        int result = new Binom().method2(7,4);
        Assert.assertEquals(35, result);
    }

    @Test
    public void Method2_FourChooseFour() {
        int result = new Binom().method2(4,4);
        Assert.assertEquals(1, result);
    }

    @Test
    public void Method2_SevenChooseZero() {
        int result = new Binom().method2(7,0);
        Assert.assertEquals(1, result);
    }

    @Test
    public void Method2_ZeroChooseZero() {
        int result = new Binom().method2(0,0);
        Assert.assertEquals(1, result);
    }


}
