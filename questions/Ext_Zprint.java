package questions;

public class Ext_Zprint {
    public static int[] zPrint(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return new int[0];
        }
        int row = array.length;
        int col = array[0].length;
        int[] results = new int[row * col];
        results[0] = array[0][0];
        int index = 1;
        int aR = 0, aC = 0, bR = 0, bC = 0;
        boolean down = true;
        boolean init = true;
        while (init || (aR != bR) || (aC != bC)) {
            init = false;
            if (aC == (col - 1)) {
                aR++;
            } else {
                aC++;
            }

            if (bR == row - 1) {
                bC++;
            } else {
                bR++;
            }

            if (down) {
                int pointR = aR;
                int pointC = aC;
                while(pointR != bR && pointC != bC) {
                    System.out.println(pointR + " " + pointC);
                    results[index++] = array[pointR][pointC];
                    pointR++;
                    pointC--;
                }
                results[index++] = array[bR][bC];
                System.out.println(bR + " " + bC);
            } else {
                int pointR = bR;
                int pointC = bC;
                while (pointR != aR && pointC != aC) {
                    System.out.println(pointR + " " + pointC);
                    results[index++] = array[pointR][pointC];
                    pointR--;
                    pointC++;

                }
                results[index++] = array[aR][aC];
                System.out.println(aR + " " + aC);
            }
            down = down ? false : true;
        }
        return results;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] results = zPrint(array);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
}
