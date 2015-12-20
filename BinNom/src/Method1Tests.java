import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nate on 12/19/15.
 */
public class Method1Tests {
    @Test
    public void Method1_FiveChooseThree() {
        int result = new Binom().method1(5,3);
        Assert.assertEquals(10, result);
    }

    @Test
    public void Method1_SevenChooseFour() {
        int result = new Binom().method1(7,4);
        Assert.assertEquals(35, result);
    }

    @Test
    public void Method1_FourChooseFour() {
        int result = new Binom().method1(4,4);
        Assert.assertEquals(1, result);
    }

    @Test
    public void Method1_SevenChooseZero() {
        int result = new Binom().method1(7,0);
        Assert.assertEquals(1, result);
    }

    @Test
    public void Method1_ZeroChooseZero() {
        int result = new Binom().method1(0,0);
        Assert.assertEquals(1, result);
    }


}
