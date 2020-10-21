package array;

public class Code167_TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{0, 0};
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int pSum = numbers[left] + numbers[right];
            if (pSum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (pSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{0, 0};
    }
}
