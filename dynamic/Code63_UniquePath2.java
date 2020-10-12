package dynamic;

public class Code63_UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] steps = new int[m + 1];
        boolean obstacle = false;
        for (int i = m - 1; i >= 0; i--) {
            if (!obstacle) {
                if (obstacleGrid[n - 1][i] == 1) {
                    steps[i] = 0;
                    obstacle = true;
                } else {
                    steps[i] = 1;
                }
            } else {
                steps[i] = 0;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    steps[j] = 0;
                } else {
                    steps[j] += steps[j + 1];
                }
            }
        }
        return steps[0];
    }
}
