import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = input.nextInt();
            System.out.printf("Case #%d: %s%n", i, n == 0 ? "INSOMNIA" : count(n));
        }
        input.close();
    }

    private static int count(int n) {
        int seen = 0;
        int x = 0;
        while (seen != 0x3FF) {
            x += n;
            for (int y = x; y > 0; y /= 10) {
                seen |= (1 << (y % 10));
            }
        }
        return x;
    }
}
