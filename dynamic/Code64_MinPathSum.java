package dynamic;

public class Code64_MinPathSum {
    //提交时报错，不能使用Integer.MAX_VALUE
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[] sum = new int[col + 1];
        for (int i = col - 1; i >= 0; i--) {
            sum[i] = sum[i + 1] + grid[row - 1][i];
        }
        sum[col] = Integer.MAX_VALUE;
        for (int i = row - 2; i >= 0; i--) {
            String str = "";
            for (int j = col - 1; j >= 0; j--) {
                sum[j] = grid[i][j] + Math.min(sum[j], sum[j + 1]);
                str += sum[j];
            }
            System.out.println(str);
        }
        return sum[0];
    }

    //87% 43%
    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[] sum = new int[col];
        sum[col - 1] = grid[row - 1][col - 1];
        for (int i = col - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + grid[row - 1][i];
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (j + 1 >= col) {
                    sum[j] += grid[i][j];
                } else {
                    sum[j] = grid[i][j] + Math.min(sum[j], sum[j + 1]);
                }
            }
        }
        return sum[0];
    }

    public static void main(String[] args) {
        int[][] array = {{1,3,1},{1,5,1},{4,2,1}};
        minPathSum(array);
    }
}
