import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        for (int i = 1; i <= t; ++i) {
            String l = input.nextLine();
            System.out.printf("Case #%d: %s%n", i, l.isEmpty() ? 0 : count(l));
        }
        input.close();
    }

    private static int count(String l) {
        boolean up = l.charAt(0) == '+';
        int x = 0;
        for (int i = 1; i < l.length(); ++i) {
            if (up ? l.charAt(i) == '-' : l.charAt(i) == '+') {
                ++x;
                up = !up;
            }
        }
        return up ? x : x+1;
    }
}
