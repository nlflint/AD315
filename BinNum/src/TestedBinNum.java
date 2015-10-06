/* Class to store integers between -128 and 127 as
an array of 8 booleans. Two's complement will be used to
deal with negative integers.
*/

public class TestedBinNum {
    private boolean[] bits;
    private static final int[] bitMask = new int[] {128,64,32,16,8,4,2,1};;

    TestedBinNum(String bitString) {
        bits = new boolean[8];

        for(int i = 0; i < 8; i++)
            bits[i] = bitString.charAt(i) == '0' ? false : true;
    }

    TestedBinNum(boolean[] givenBits) {
        bits = givenBits;
    }

    TestedBinNum(int n) {
        bits = new boolean[8];

        if (n >= 0)
        {
            bits = toBinaryArray(n, bitMask);
        } else {
            bits = negate(toBinaryArray(-n, bitMask));
            bits = add(this, new TestedBinNum(1)).bits;
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

    public static TestedBinNum add(TestedBinNum first, TestedBinNum second) {
        boolean[] newBits = new boolean[8];
        boolean[] firstBits = first.bits;
        boolean[] secondBits = second.bits;
        boolean carryBit = false;

        for (int i = 7; i >= 0; i--) {

            newBits[i] = firstBits[i] ^ secondBits[i] ^ carryBit;
            carryBit = ((firstBits[i] || secondBits[i]) && carryBit)
                    || ((firstBits[i] && secondBits[i]) && !carryBit);
        }
        return new TestedBinNum(newBits);
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

    public boolean[] displayByteNum() {
        return bits;
    }

    public int displayNum() {
        if (bits[0]) {
            return -sumBits(negate(bits)) - 1;
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
    }
}






