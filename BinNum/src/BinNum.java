/* Class to store integers between -128 and 127 as
an array of 8 booleans. Two's complement will be used to
deal with negative integers.
*/

public class BinNum {
    private boolean[] bits;
    private static final int[] bitMask = new int[] {128,64,32,16,8,4,2,1};;



    BinNum(int n) {
        bits = new boolean[8];

        if (n >= 0)
        {
            bits = toBinaryArray(n, bitMask);
        } else {
            bits = negate(toBinaryArray(-n, bitMask));
            bits = add(this, new BinNum(1)).bits;
        }
    }

    private boolean[] toBinaryArray(int n, int[] maskingBits) {
        boolean[] binaryArray = new boolean[8];
        for (int i = 0; i < 8; i++) {
            int mask = maskingBits[i];
            if (n - mask >= 0){
                binaryArray[i] = true;
                n = n - mask;
            }
        }
        return binaryArray;
    }

    public static BinNum add(BinNum first, BinNum second) {
        boolean[] newBits = new boolean[8];
        boolean[] firstBits = first.bits;
        boolean[] secondBits = second.bits;
        boolean carryBit = false;

        for (int i = 7; i >= 0; i--) {

            newBits[i] = firstBits[i] ^ secondBits[i] ^ carryBit;
            carryBit = ((firstBits[i] || secondBits[i]) && carryBit)
                    || ((firstBits[i] && secondBits[i]) && !carryBit);
        }

        BinNum newBinNum = new BinNum(0);
        newBinNum.bits = newBits;
        return newBinNum;
    }

    public void negate() {
        bits = negate(bits);
    }

    private static boolean[] negate(boolean[] givenBits) {
        boolean[] newBits = new boolean[8];
        for (int i = 0; i < 8; i++) {
            newBits[i] = !givenBits[i];
        }
        return newBits;
    }

    public void displayByteNum() {
        for (boolean bit : bits)
            System.out.print(bit ? "1" : "0");
    }

    public void displayNum() {
        System.out.print(getInt());
    }

    private int getInt() {
        int sum;
        if (bits[0]) {
            boolean[] negatedBits = negate(bits);
            return -sumBits(negatedBits) - 1;
        }
        return sumBits(bits);
    }

    private int sumBits(boolean[] givenBits) {
        int sum = 0;
        for(int i = 1; i < 8; i++)
            if (givenBits[i])
                sum += bitMask[i];
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
        System.out.println("\n Bits\t\t| Int\n------------------");
        for (int i = lowerBound; i < upperBound; i++) {
            BinNum num = new BinNum(i);
            num.displayByteNum();
            System.out.print("\t| ");
            num.displayNum();
            System.out.println();
        }
    }
}






