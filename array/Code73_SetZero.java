package array;

import java.util.HashSet;

public class Code73_SetZero {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<Integer> lineSet = new HashSet<Integer>();
        HashSet<Integer> colSet = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    lineSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0 && (lineSet.contains(i) || colSet.contains(j))) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public void setZeroes2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MAX_VALUE - 3;
        //for (int i = 0; i < m; i++) {
        //for (int j = 0; j < n; j++) {
        //if (matrix[i][j] > max) {
        //max = matrix[i][j];
        //}
        //}
        //}
        //max += 1;
        boolean firstZero = matrix[0][0] == 0 ? true : false;
        boolean colZero = false;
        boolean rowZero = false;
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                colZero = true;
                continue;
            }
            for (int i = 1; i < m; i++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = max;
                    break;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                rowZero = true;
                continue;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = max;
                    break;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == max || matrix[0][j] == max || matrix[i][0] == 0 ||
                        matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstZero) {
            for (int i = 1; i < m; i++) {
                matrix[i][0] = 0;
            }
            for (int j = 1; j < n; j++) {
                matrix[0][j] = 0;
            }
        } else {
            for (int i = 0; i < m; i++) {
                if (rowZero || matrix[i][0] == max) {
                    matrix[i][0] = 0;
                }
            }
            for (int j = 0; j < n; j++) {
                if (colZero || matrix[0][j] == max) {
                    matrix[0][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] array = {{0, 1}};
    }
}
