package questions;

public class Offer29_SpiralOrder {
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int [] results = new int[row * col];
        int startR = 0;
        int startC = 0;
        int endR = row - 1;
        int endC = col - 1;
        int index = 0;
        while (startR < endR && startC < endC) {
            for (int i = 0; i < endC - startC; i++) {
                results[index++] = matrix[startR][startC + i];
            }
            for (int i = 0; i < endR - startR; i++) {
                results[index++] = matrix[startR + i][endC];
            }
            for (int i = 0; i < endC - startC; i++) {
                results[index++] = matrix[endR][endC - i];
            }
            for (int i = 0; i < endR - startR; i++) {
                results[index++] = matrix[endR - i][startC];
            }
            startR++;
            startC++;
            endR--;
            endC--;
        }
        if (startR == endR && startC == endC) {
            //一个点
            results[index] = matrix[startR][startC];
        } else if (startR != endR && startC == endC) {
            //一列
            for (int i = startR; i <= endR; i++) {
                results[index++] = matrix[i][startC];
            }
        } else if (startR == endR && startC != endC){
            //一行
            for (int i = startC; i <= endC; i++) {
                results[index++] = matrix[startR][i];
            }
        }
        //对于startR > endR 或 startC > endC的情况都不需要再处理
        return results;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        int[] results = spiralOrder(array);
        for (int a : results) {
            System.out.println(a);
        }
    }
}
