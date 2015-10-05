import org.junit.*;
import static org.junit.Assert.*;
import java.util.stream.StreamSupport;
import java.util.List;

/**
 * Created by nate on 10/4/15.
 */
public class BinNumTests {
    @Test
    public void DisplayByteNumber_Given24_ThenBinaryIs00011000()
    {
        boolean[] result = CreateBinNum(24).displayByteNum();
        boolean[] expectedResult = getBooleans("00011000");
        assertArrayEquals(result, expectedResult);
    }

    @Test
    public void DisplayByteNumber_Given127_ThenBinaryIs01111111()
    {
        boolean[] result = CreateBinNum(127).displayByteNum();
        boolean[] expectedResult = getBooleans("01111111");
        assertArrayEquals(result, expectedResult);
    }

    @Test
    public void DisplayByteNumber_Given0_ThenBinaryIs00000000()
    {
        boolean[] result = CreateBinNum(0).displayByteNum();
        boolean[] expectedResult = getBooleans("00000000");
        assertArrayEquals(result, expectedResult);
    }

    @Test
    public void Negate_Given00011000_ThenBinaryIs11100111()
    {
        boolean[] result = CreateNegatedBinNum("00011000").displayByteNum();
        boolean[] expectedResult = getBooleans("11100111");
        assertArrayEquals(result, expectedResult);
    }

    @Test
    public void Negate_Given00000000_ThenBinaryIs11111111()
    {
        boolean[] result = CreateNegatedBinNum("00000000").displayByteNum();
        boolean[] expectedResult = getBooleans("11111111");
        assertArrayEquals(result, expectedResult);
    }

    @Test
    public void Negate_Given01011011_ThenBinaryIs10100100()
    {
        boolean[] result = CreateNegatedBinNum("01011011").displayByteNum();
        boolean[] expectedResult = getBooleans("10100100");
        assertArrayEquals(result, expectedResult);
    }

    @Test
    public void Add_WhenAdding0And1_ThenAnswerIs1()
    {
        boolean[] result = CreateAddedBinNum(0, 1).displayByteNum();
        boolean[] expectedResult = CreateBinNum(1).displayByteNum();
        assertArrayEquals(result, expectedResult);
    }

    @Test
    public void Add_WhenAdding1And1_ThenAnswerIs2()
    {
        boolean[] result = CreateAddedBinNum(1, 1).displayByteNum();
        boolean[] expectedResult = CreateBinNum(2).displayByteNum();
        assertArrayEquals(result, expectedResult);
    }

    @Test
    public void Add_WhenAdding3And3_ThenAnswerIs6()
    {
        boolean[] result = CreateAddedBinNum(3, 3).displayByteNum();
        boolean[] expectedResult = CreateBinNum(6).displayByteNum();
        assertArrayEquals(result, expectedResult);
    }

    @Test
    public void Add_WhenAdding12And24_ThenAnswerIs36()
    {
        boolean[] result = CreateAddedBinNum(12, 24).displayByteNum();
        boolean[] expectedResult = CreateBinNum(36).displayByteNum();
        assertArrayEquals(result, expectedResult);
    }

    @Test
    public void DisplayNum_GivenBinNum0_ThenAnswerIs45()
    {
        int result = CreateBinNum(0).displayNum();
        assertEquals(result, 0);
    }

    @Test
    public void DisplayNum_GivenBinNum45_ThenAnswerIs45()
    {
        int result = CreateBinNum(45).displayNum();
        assertEquals(result, 45);
    }

    @Test
    public void DisplayNum_GivenBinNum127_ThenAnswerIs127()
    {
        int result = CreateBinNum(127).displayNum();
        assertEquals(result, 127);
    }

    private BinNum CreateAddedBinNum(int first, int second) {
        return BinNum.add(new BinNum(first), new BinNum(second));
    }

    private BinNum CreateNegatedBinNum(String bitString) {
        BinNum binNum = new BinNum(bitString);
        binNum.negate();
        return binNum;
    }

    private boolean[] getBooleans(String bits) {
        boolean[] result = new boolean[8];

        for(int i = 0; i < 8; i++)
            if (bits.charAt(i) == '1')
                result[i] = true;
        return result;
    }

    private void assertArrayEquals(boolean[] result, boolean[] expectedResult) {
        assertEquals(result.length, expectedResult.length);

        for (int i = 0; i < result.length; i++) {
            assertEquals("Different bits at index: " + i, result[i], expectedResult[i]);
        }
    }

    private BinNum CreateBinNum(int number) {
        return new BinNum(number);
    }
}
