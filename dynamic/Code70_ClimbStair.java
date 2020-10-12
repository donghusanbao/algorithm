package dynamic;

public class Code70_ClimbStair {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        int[] steps = new int[n + 1];
        steps[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i + 1 <= n) {
                steps[i] += steps[i + 1];
            }
            if (i + 2 <= n) {
                steps[i] += steps[i + 2];
            }
        }
        return steps[0];
    }
    public int climbStairs2(int n) {
        if (n == 0) {
            return 0;
        }
        int cur = -1;
        int pos = 1;
        int posPos = 0;
        for (int i = n - 1; i >= 0; i--) {
            cur = pos + posPos;
            posPos = pos;
            pos = cur;
        }
        return cur;
    }
}
