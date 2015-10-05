/* Class to store integers between -128 and 127 as
an array of 8 booleans. Two's complement will be used to
deal with negative integers.
*/

public class BinNum {
    private boolean[] bits;
    private static final int[] bitMask = new int[] {128,64,32,16,8,4,2,1};;

    BinNum(String bitString) {
        bits = new boolean[8];

        for(int i = 0; i < 8; i++)
            bits[i] = bitString.charAt(i) == '0' ? false : true;
    }

    BinNum(int n) {
        bits = new boolean[8];

        if (n >= 0)
        {
            for (int i = 1; i < 8; i++) {
                int mask = bitMask[i];
                if (n - mask >= 0){
                    bits[i] = true;
                    n = n - mask;
                }

            }
        } else {
            int positiveN = -n;
            for (int i = 1; i < 8; i++) {
                int mask = bitMask[i];
                if (positiveN - mask >= 0){
                    bits[i] = true;
                    positiveN = positiveN - mask;
                }

            }
            negate();
            bits = add(this, new BinNum(1)).bits;
        }
    }

    public static BinNum add(BinNum a, BinNum b) {
        boolean[] newBits = new boolean[8];
        boolean carryBit = false;

        for (int i = 7; i >= 0; i--) {
            boolean beforeCarry = a.bits[i] ^ b.bits[i];
            boolean afterCarry = beforeCarry ^ carryBit;
            newBits[i] = afterCarry;

            carryBit = (a.bits[i] && b.bits[i] && carryBit);

        }

        return new BinNum(getInt(newBits));

    }

    public void negate() {
        for (int i = 0; i < 8; i++) {
            bits[i] = !bits[i];
        }
    }

    public boolean[] displayByteNum() {
        return bits;
    }

    public int displayNum() {
        return getInt(bits);
    }

    private static int getInt(boolean[] workingBits) {
        int sum = 0;
        for(int i = 0; i < 8; i++)
            if (workingBits[i])
                sum += bitMask[i];
        return sum;
    }

    public static void main(String[] args) {

    }
}






