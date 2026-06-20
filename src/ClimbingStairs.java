public class ClimbingStairs {
    static void main() {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        if (n <= 2) return n;

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int res = first + second;

            first = second;
            second = res;
        }

        return second;
    }
}
