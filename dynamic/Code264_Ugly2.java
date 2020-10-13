package dynamic;

public class Code264_Ugly2 {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int p2 = 0, p3 = 0, p5 = 0;
        int[] results = new int[1690];
        results[0] = 1;
        for (int i = 1; i < results.length; i++) {
            results[i] = Math.min(Math.min(results[p2] * 2, results[p3] * 3), results[p5] * 5);
            if (results[i] % 2 == 0) p2++;
            if (results[i] % 3 == 0) p3++;
            if (results[i] % 5 == 0) p5++;
        }
        return results[n - 1];
    }
}
