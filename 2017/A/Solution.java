import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        for (int i = 1; i <= t; ++i) {
            String[] in = input.nextLine().split(" ");
	    int r = Integer.parseInt(in[1]);
	    String l = in[0];
	    int c = count(l, r);
            System.out.printf("Case #%d: %s%n", i, c == -1 ? "IMPOSSIBLE" : c);
        }
        input.close();
    }

    private static int count(String l, int r) {
        boolean up = l.charAt(0) == '+';
	int lastUp = -1;
        int x = 0;
        for (int i = 1; i < l.length(); ++i) {
            if (l.charAt(i) == '-') {
		boolean changed = false;
		for (int k = i+1; k < i+r; ++k) {
			if (k == l.length()) return -1;

			if (l.charAt(k) == '+') {
				if (!changed) {
					lastUp = k-1;
					changed = true;
				}
			} else {
				if (changed) {
					return -1;
				}
			}
		}
		++x;
		i = lastUp;
            }
        }
        return x;
    }
}
