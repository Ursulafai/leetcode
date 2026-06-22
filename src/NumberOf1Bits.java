public class NumberOf1Bits {
    static void main() {
        System.out.println(hammingWeight(2147483645));

    }

    public static int hammingWeight(int n) {
        int counter = 0;

        while (n != 0) {
            counter += n & 1;
            n >>= 1;
        }

        return counter;
    }
}
