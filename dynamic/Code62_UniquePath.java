package dynamic;

public class Code62_UniquePath {
    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] num = new int[n + 1][m + 1];
        num[1][m - 1] = 1;
        for (int i = 1; i <=n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == 1 && j == m - 1) {
                    continue;
                }
                num[i][j] = num[i][j + 1] + num[i - 1][j];
            }
        }
        return num[n][0];
    }

    public static int uniquePaths2(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] num = new int[m + 1];
        for (int i = 0;i < num.length - 1; i++) {
            num[i] = 1;
        }
        for (int i = 1; i <n; i++) {
            String s = "";
            for (int j = m - 1; j >= 0; j--) {
                num[j] = num[j + 1] + num[j];
                s += num[j];
            }
            System.out.println(s);
        }
        return num[0];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths2(3, 2));
    }
}
