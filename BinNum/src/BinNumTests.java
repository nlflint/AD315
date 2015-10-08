import org.junit.*;
import static org.junit.Assert.*;
import java.lang.*;

/**
 * Created by nate on 10/4/15.
 */
public class BinNumTests extends BinNum {
    public BinNumTests() {
        super(0);
    }

    @Test
    public void DisplayByteNumber_Given24_ThenBinaryIs00011000()
    {
        boolean[] result = CreateBinNum(24).getBits();
        boolean[] expectedResult = getBooleans("00011000");
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void DisplayByteNumber_Given127_ThenBinaryIs01111111()
    {
        boolean[] result = CreateBinNum(127).getBits();
        boolean[] expectedResult = getBooleans("01111111");
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void DisplayByteNumber_Given0_ThenBinaryIs00000000()
    {
        boolean[] result = CreateBinNum(0).getBits();
        boolean[] expectedResult = getBooleans("00000000");
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void DisplayByteNumber_GivenNegative1_ThenBinaryIs11111110()
    {
        boolean[] result = CreateBinNum(-1).getBits();
        boolean[] expectedResult = getBooleans("11111111");
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void DisplayByteNumber_GivenNegative25_ThenBinaryIs11100111()
    {
        boolean[] result = CreateBinNum(-25).getBits();
        boolean[] expectedResult = getBooleans("11100111");
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void DisplayByteNumber_GivenNegative127_ThenBinaryIs10000001()
    {
        boolean[] result = CreateBinNum(-127).getBits();
        boolean[] expectedResult = getBooleans("10000001");
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void DisplayByteNumber_GivenNegative128_ThenBinaryIs10000000()
    {
        boolean[] result = CreateBinNum(-128).getBits();
        boolean[] expectedResult = getBooleans("10000000");
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void Negate_Given00011000_ThenBinaryIs11100111()
    {
        boolean[] result = CreateNegatedBinNum("00011000").getBits();
        boolean[] expectedResult = getBooleans("11100111");
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void Negate_Given00000000_ThenBinaryIs11111111()
    {
        boolean[] result = CreateNegatedBinNum("00000000").getBits();
        boolean[] expectedResult = getBooleans("11111111");
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void Negate_Given01011011_ThenBinaryIs10100100()
    {
        boolean[] result = CreateNegatedBinNum("01011011").getBits();
        boolean[] expectedResult = getBooleans("10100100");
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void Add_WhenAdding0And1_ThenAnswerIs1()
    {
        boolean[] result = CreateAddedBinNum(0, 1).getBits();
        boolean[] expectedResult = CreateBinNum(1).getBits();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void Add_WhenAdding1And1_ThenAnswerIs2()
    {
        boolean[] result = CreateAddedBinNum(1, 1).getBits();
        boolean[] expectedResult = CreateBinNum(2).getBits();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void Add_WhenAdding3And3_ThenAnswerIs6()
    {
        boolean[] result = CreateAddedBinNum(3, 3).getBits();
        boolean[] expectedResult = CreateBinNum(6).getBits();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void Add_WhenAdding12And24_ThenAnswerIs36()
    {
        boolean[] result = CreateAddedBinNum(12, 24).getBits();
        boolean[] expectedResult = CreateBinNum(36).getBits();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void Add_WhenAdding4AndNegative2_ThenAnswerIs2()
    {
        boolean[] result = CreateAddedBinNum(4, -2).getBits();
        boolean[] expectedResult = CreateBinNum(2).getBits();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void Add_WhenAdding13AndNegative13_ThenAnswerIs0()
    {
        boolean[] result = CreateAddedBinNum(13, -13).getBits();
        boolean[] expectedResult = CreateBinNum(0).getBits();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void Add_WhenAdding4AndNegative8_ThenAnswerIsNegative4()
    {
        boolean[] result = CreateAddedBinNum(4, -8).getBits();
        boolean[] expectedResult = CreateBinNum(-4).getBits();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void Add_WhenAddingNegative14AndNegative13_ThenAnswerIsNegative27()
    {
        boolean[] result = CreateAddedBinNum(-14, -13).getBits();
        boolean[] expectedResult = CreateBinNum(-27).getBits();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void Add_WhenAddingNegative95AndNegative33_ThenAnswerIsNegative128()
    {
        boolean[] result = CreateAddedBinNum(-95, -33).getBits();
        boolean[] expectedResult = CreateBinNum(-128).getBits();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void DisplayNum_GivenBinNum0_ThenAnswerIs45()
    {
        int result = CreateBinNum(0).getDecimalValue();
        assertEquals(0, result);
    }

    @Test
    public void DisplayNum_GivenBinNum45_ThenAnswerIs45()
    {
        int result = CreateBinNum(45).getDecimalValue();
        assertEquals(45, result);
    }

    @Test
    public void DisplayNum_GivenBinNum127_ThenAnswerIs127()
    {
        int result = CreateBinNum(127).getDecimalValue();
        assertEquals(127, result);
    }

    @Test
    public void DisplayNum_GivenBinNumNegative14_ThenAnswerIsNegative14()
    {
        int result = CreateBinNum(-14).getDecimalValue();
        assertEquals(-14, result);
    }

    @Test
    public void DisplayNum_GivenBinNumNegative97_ThenAnswerIsNegative97()
    {
        int result = CreateBinNum(-97).getDecimalValue();
        assertEquals(-97, result);
    }

    @Test
    public void DisplayNum_GivenBinNumNegative128_ThenAnswerIsNegative128()
    {
        int result = CreateBinNum(-128).getDecimalValue();
        assertEquals(-128, result);
    }

    @Test
    public void Add_GivenTopAndBottomAndCarry_ThenAnswerAndNextCarryAreCorrect()
    {
        boolean[][] testData = new boolean[][] {
                {true, true, true, true, true},
                {true, true, false, false, true},
                {true, false, true, false, true},
                {true, false, false, true, false},
                {false, true, true, false, true},
                {false, true, false, true, false},
                {false, false, true, true, false},
                {false, false, false, false, false},
        };

        for (boolean[] data : testData) {
            assertLogic(data);
        }
    }

    private void assertLogic(boolean[] data) {
        boolean answer = data[0] ^ data[1] ^ data[2];
        boolean carry = ((data[0] || data[1]) && data[2])
                || ((data[0] && data[1]) && !data[2]);

        assertEquals(String.format("Wrong answer for %s %s %s:", data[0], data[1], data[2])
                , data[3]
                , answer);
        assertEquals(String.format("Wrong carry for %s %s %s:", data[0], data[1], data[2])
                , data[4]
                , carry);
    }

    private BinNum CreateAddedBinNum(int first, int second) {
        return BinNum.add(new BinNum(first), new BinNum(second));
    }

    private BinNum CreateNegatedBinNum(String bitString) {
        BinNum testedBinNum = new BinNum(0);
        testedBinNum.setBits(getBooleans(bitString));
        testedBinNum.negate();
        return testedBinNum;
    }

    private boolean[] getBooleans(String bits) {
        boolean[] result = new boolean[8];

        for(int i = 0; i < 8; i++)
            if (bits.charAt(i) == '1')
                result[i] = true;
        return result;
    }

    private void assertArrayEquals(boolean[] expectedResult, boolean[] result) {
        assertEquals(expectedResult.length, result.length);

        for (int i = 0; i < result.length; i++) {
            assertEquals("Different bits at index: " + i, expectedResult[i], result[i]);
        }
    }

    private BinNum CreateBinNum(int number) {
        return new BinNum(number);
    }
}
