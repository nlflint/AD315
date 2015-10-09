/* Class to store integers between -128 and 127 as
an array of 8 booleans. Two's complement will be used to
deal with negative integers.
*/

public class BinNum {
    private boolean[] bits;

    BinNum(int n) {
        if (n >= 0) {
            bits = toBinaryArray(n);
        } else {
            bits = toBinaryArray(-n);
            negate();
            bits = add(this, new BinNum(1)).bits;
        }
    }

    public void negate() {
        for (int i = 0; i < 8; i++) {
            bits[i] = !bits[i];
        }
    }

    private boolean[] toBinaryArray(int n) {
        boolean[] binaryArray = new boolean[8];
        for (int i = 0; i < 8; i++) {
            int bitDecimalValue = calculateDecimalValueForBitIndex(i);
            if (n - bitDecimalValue >= 0){
                binaryArray[i] = true;
                n = n - bitDecimalValue;
            }
        }
        return binaryArray;
    }

    private int calculateDecimalValueForBitIndex(int i) {
        return (int) Math.pow(2, 7 - i);
    }

    public static BinNum add(BinNum first, BinNum second) {
        boolean[] answerBits = new boolean[8];
        boolean carryBit = false;

        for (int i = 7; i >= 0; i--) {
            boolean top = first.bits[i];
            boolean bottom = second.bits[i];
            answerBits[i] = top ^ bottom ^ carryBit;
            carryBit =
                    (top && bottom) ||
                    (top && carryBit) ||
                    (bottom && carryBit);
        }
        BinNum newBinNum = new BinNum(0);
        newBinNum.bits = answerBits;
        return newBinNum;
    }

    public void displayByteNum() {
        for (boolean bit : bits)
            System.out.print(bit ? "1" : "0");
    }

    public void displayNum() {
        System.out.print(getDecimalValue());
    }

    public int getDecimalValue() {
        if (bits[0]) {
            BinNum temporaryBinNum = clone();
            temporaryBinNum = add(temporaryBinNum, new BinNum(-1));
            temporaryBinNum.negate();
            return -sumBits(temporaryBinNum.bits);
        }
        return sumBits(bits);
    }

    protected BinNum clone() {
        BinNum clone = new BinNum(0);
        clone.bits = bits.clone();
        return clone;
    }

    private int sumBits(boolean[] bits) {
        int sum = 0;
        for(int i = 0; i < 8; i++)
            if (bits[i])
                sum += calculateDecimalValueForBitIndex(i);
        return sum;
    }

    public static void main(String[] args) {
        DisplayMessageWithBinNum("Positive BinNum: ", new BinNum(45));
        DisplayMessageWithBinNum("Negative BinNum: ", new BinNum(-97));

        DisplayAddWithMessage("Adding two positives: ", new BinNum(33), new BinNum(54));
        DisplayAddWithMessage("Adding two negatives: ", new BinNum(-43), new BinNum(-15));
        DisplayAddWithMessage("Adding positive and negative: ", new BinNum(66), new BinNum(-100));

        DisplayBinNumTableFrom(-10, 10);
    }

    private static void DisplayMessageWithBinNum(String message, BinNum binNum) {
        System.out.print(message);
        binNum.displayNum();
        System.out.print(" - ");
        binNum.displayByteNum();
        System.out.println();
    }

    private static void DisplayAddWithMessage(String message, BinNum first, BinNum second) {
        System.out.print(message);
        first.displayNum();
        System.out.print(" + ");
        second.displayNum();
        System.out.print(" = ");
        add(first, second).displayNum();
        System.out.println();
    }

    private static void DisplayBinNumTableFrom(int lowerBound, int upperBound) {
        System.out.println();
        System.out.println("Table:");
        System.out.println(" Bits\t\t| Int");
        System.out.println("------------------");

        for (int i = lowerBound; i <= upperBound; i++) {
            BinNum num = new BinNum(i);
            num.displayByteNum();
            System.out.print("\t| ");
            num.displayNum();
            System.out.println();
        }
    }

    protected void setBits(boolean[] newBits){
        bits = newBits;
    }
}






