package array;

public class Code74_SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (matrix[mid][n - 1] == target) {
                return true;
            }
            if (matrix[mid][n - 1] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == m) {
            return false;
        }
        int line = left;
        System.out.println("line is " + line);
        int leftCol = 0;
        int rightCol = n - 1;
        while (leftCol < rightCol) {
            int mid = leftCol + ((rightCol - leftCol) >> 1);
            if (matrix[line][mid] == target) {
                return true;
            }
            if (matrix[line][mid] < target) {
                leftCol = mid + 1;
            } else {
                rightCol = mid - 1;
            }
        }
        System.out.println("leftCol is " + leftCol);
        return matrix[line][leftCol] == target;
    }

    public static void main(String[] args) {
        int[][] array = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 10;
        System.out.println(searchMatrix(array, target));
    }

}
