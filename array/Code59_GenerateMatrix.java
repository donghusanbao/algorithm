package array;

public class Code59_GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];
        int startRow = 0, startCol = 0, endRow = n - 1, endCol = n - 1;
        int index = 1;
        while (startRow < endRow) {
            for (int j = startCol; j < endCol; j++) {
                array[startRow][j] = index++;
            }
            for (int i = startRow; i < endRow; i++) {
                array[i][endCol] = index++;
            }
            for (int j = endCol; j > startCol; j--) {
                array[endRow][j] = index++;
            }
            for (int i = endRow; i > startRow; i--) {
                array[i][startCol] = index++;
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        if (startRow == endRow) {
            array[startRow][startCol] = index;
        }
        return array;
    }
}
