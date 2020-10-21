package array;

public class Code162_SearchPeak {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (left == right) {
                return left;
            }
            if (left == right - 1) {
                return nums[left] > nums[right] ? left : right;
            }
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
                continue;
            }
            if (nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
