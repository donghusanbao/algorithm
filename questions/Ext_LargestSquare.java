package questions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Ext_LargestSquare {
    public static int getMaxLength(int[][] array, int n) {
        int[][] down = new int[n][n];
        int[][] right = new int[n][n];
        for (int j = 0; j < n; j++) {
            down[n - 1][j] = array[n - 1][j];
            right[j][n - 1] = array[j][n - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                down[i][j] = array[i][j] == 0 ? 0 : (1 + down[i + 1][j]);
            }
        }
        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < n - 1; i++) {
                right[i][j] = array[i][j] == 0 ? 0 : (1 + right[i][j + 1]);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k <= n; k++) {
                    if ((i + k - 1 >= n) || (j + k - 1 >= n)) {
                        continue;
                    } else {
                        if ((down[i][j] >= k) && (right[i][j] >= k)
                                && (down[i][j + k - 1] >= k) && (right[i + k - 1][j] >= k)) {
                            max = Math.max(max, k);
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(line[j]);
            }
        }
        System.out.println(getMaxLength(array, n));
    }
}
