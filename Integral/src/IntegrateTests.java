import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by nate on 10/21/15.
 */
public class IntegrateTests {

    static final double tolerance = 0.000000000001;

    public double Integrate(String str, double lower, double upper, int rectangles) {
        return new Integrate(str, lower, upper, rectangles).ApproximateValue;
    }

    @Test
    public void Integrate_LeftHandedFrom3To7With4Approx_AnswerIs86() {
        double actualResult = Integrate("l", 3, 7, 4);
        assertEquals(86.0, actualResult, tolerance);
    }

    @Test
    public void Integrate_LeftHandedFrom3p25To7p66With4Approx_AnswerIsAbout112() {
        double actualResult = Integrate("l", 3.25, 7.66, 4);
        assertEquals(112.7467077187500, actualResult, tolerance);
    }

    @Test
    public void Integrate_RightHandedFrom3To7With4Approx_AnswerIs126() {
        double actualResult = Integrate("r", 3, 7, 4);
        assertEquals(126.0, actualResult, tolerance);
    }

    @Test
    public void Integrate_RightHandedFrom3p25To7p66With4Approx_AnswerIsAbout165() {
        double actualResult = Integrate("r", 3.25, 7.66, 4);
        assertEquals(165.7914004687500, actualResult, tolerance);
    }

    @Test
    public void Integrate_TrapezoidFrom3To7With4Approx_AnswerIs106() {
        double actualResult = Integrate("t", 3, 7, 4);
        assertEquals(106.0, actualResult, tolerance);
    }

    @Test
    public void Integrate_TrapezoidHandedFrom3p25To7p66With4Approx_AnswerIsAbout145() {
        double actualResult = Integrate("t", 3.25, 7.66, 4);
        assertEquals(139.2690540937500, actualResult, tolerance);
    }

}
