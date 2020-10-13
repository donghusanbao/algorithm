package dynamic;

public class Code279_NumsSquare {
    //81% 95%
    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        int upper = (int) Math.sqrt(n);
        if (upper * upper == n) {
            return 1;
        }
        int[] results = new int[upper];
        for (int i = 0; i < results.length; i++) {
            results[i] = (i + 1) * (i + 1);
        }
        int[] array = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            array[i] = i;
        }
        for (int i = 1; i < upper; i++) {
            int cur = results[i];
            for (int j = 1; j < n + 1; j++) {
                if (j >= cur) {
                    array[j] = Math.min(array[j], 1 + array[j - cur]);
                }
            }
        }
        return array[n];
    }
}
