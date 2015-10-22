import org.junit.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
        String result = captureDisplayByteNum(CreateBinNum(25));
        assertEquals("00011001", result);
    }

    @Test
    public void DisplayByteNumber_Given127_ThenBinaryIs01111111()
    {
        String result = captureDisplayByteNum(CreateBinNum(127));
        assertEquals("01111111", result);

    }

    @Test
    public void DisplayByteNumber_Given0_ThenBinaryIs00000000()
    {
        String result = captureDisplayByteNum(CreateBinNum(0));
        assertEquals("00000000", result);
    }

    @Test
    public void DisplayByteNumber_GivenNegative1_ThenBinaryIs11111111()
    {
        String result = captureDisplayByteNum(CreateBinNum(-1));
        assertEquals("11111111", result);
    }

    @Test
    public void DisplayByteNumber_GivenNegative25_ThenBinaryIs11100110()
    {
        String result = captureDisplayByteNum(CreateBinNum(-26));
        assertEquals("11100110", result);
    }

    @Test
    public void DisplayByteNumber_GivenNegative127_ThenBinaryIs10000001()
    {
        String result = captureDisplayByteNum(CreateBinNum(-127));
        assertEquals("10000001", result);
    }

    @Test
    public void DisplayByteNumber_GivenNegative128_ThenBinaryIs10000000()
    {
        String result = captureDisplayByteNum(CreateBinNum(-128));
        assertEquals("10000000", result);
    }

    @Test
    public void Negate_Given10011000_ThenBinaryIs01100111()
    {
        String result = captureDisplayByteNum(CreateNegatedBinNum("10011000"));
        assertEquals("01100111", result);
    }

    @Test
    public void Negate_Given00000000_ThenBinaryIs11111111()
    {
        String result = captureDisplayByteNum(CreateNegatedBinNum("00000000"));
        assertEquals("11111111", result);
    }

    @Test
    public void Negate_Given01011011_ThenBinaryIs10100100()
    {
        String result = captureDisplayByteNum(CreateNegatedBinNum("01011011"));
        assertEquals("10100100", result);
    }

    @Test
    public void Add_WhenAdding0And1_ThenAnswerIs1()
    {
        String result = captureDisplayNum(CreateAddedBinNum(0, 1));
        assertEquals("1", result);
    }

    @Test
    public void Add_WhenAdding1And1_ThenAnswerIs2()
    {
        String result = captureDisplayNum(CreateAddedBinNum(1, 1));
        assertEquals("2", result);
    }

    @Test
    public void Add_WhenAdding3And3_ThenAnswerIs6()
    {
        String result = captureDisplayNum(CreateAddedBinNum(3, 3));
        assertEquals("6", result);
    }

    @Test
    public void Add_WhenAdding12And24_ThenAnswerIs36()
    {
        String result = captureDisplayNum(CreateAddedBinNum(12, 24));
        assertEquals("36", result);
    }

    @Test
    public void Add_WhenAdding4AndNegative2_ThenAnswerIs2()
    {
        String result = captureDisplayNum(CreateAddedBinNum(4, -2));
        assertEquals("2", result);
    }

    @Test
    public void Add_WhenAdding13AndNegative13_ThenAnswerIs0()
    {
        String result = captureDisplayNum(CreateAddedBinNum(13, -13));
        assertEquals("0", result);
    }

    @Test
    public void Add_WhenAdding4AndNegative8_ThenAnswerIsNegative4()
    {
        String result = captureDisplayNum(CreateAddedBinNum(4, -8));
        assertEquals("-4", result);
    }

    @Test
    public void Add_WhenAddingNegative14AndNegative13_ThenAnswerIsNegative27()
    {
        String result = captureDisplayNum(CreateAddedBinNum(-14, -13));
        assertEquals("-27", result);
    }

    @Test
    public void Add_WhenAddingNegative95AndNegative33_ThenAnswerIsNegative128()
    {
        String result = captureDisplayNum(CreateAddedBinNum(-95, -33));
        assertEquals("-128", result);
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

    private BinNum CreateBinNum(int number) {
        return new BinNum(number);
    }

    private String captureDisplayByteNum(BinNum binNum) {

        // Create a custom System.out
        ByteArrayOutputStream fakeOutStream;
        fakeOutStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(fakeOutStream);
        PrintStream old = System.out;
        System.setOut(ps);

        binNum.displayByteNum();

        //Restore original system.out
        System.out.flush();
        String result = fakeOutStream.toString();
        System.setOut(old);

        return result;
    }

    private String captureDisplayNum(BinNum binNum) {

        // Create a custom System.out
        ByteArrayOutputStream fakeOutStream;
        fakeOutStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(fakeOutStream);
        PrintStream old = System.out;
        System.setOut(ps);

        binNum.displayNum();

        //Restore original system.out
        System.out.flush();
        String result = fakeOutStream.toString();
        System.setOut(old);

        return result;
    }
}
