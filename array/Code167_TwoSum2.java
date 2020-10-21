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
    //二分法
    public int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{0, 0};
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (left == right - 1) {
                return sum == target ? (new int[]{left + 1, right + 1}) : (new int[]{0, 0});
            }
            int mid = left + ((right - left) >> 1);
            int leftSum = numbers[mid] + numbers[left];
            int rightSum = numbers[mid] + numbers[right];
            if (leftSum == target) {
                return new int[]{left + 1, mid + 1};
            } else if (leftSum > target) {
                right = mid - 1;
            } else {
                if (rightSum == target) {
                    return new int[]{mid + 1, right +1};
                } else if (rightSum < target) {
                    left = mid + 1;
                } else {
                    if (sum == target) {
                        return new int[]{left + 1, right + 1};
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return new int[]{0, 0};
    }
}
