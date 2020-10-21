package array;

public class Code153_SearchRevolve3 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (left == right) {
                return nums[left];
            }
            int mid = left + ((right - left) >> 1);
            if (left == right - 1) {
                return nums[left] < nums[right] ? nums[left] : nums[right];
            }
            //至少有三个元素，保证mid - 1和mid + 1不会越界
            if ((nums[left] <= nums[mid - 1]) && (nums[mid + 1] <= nums[right])) {
                return Math.min(nums[left], Math.min(nums[mid], nums[mid + 1]));
            } else if ((nums[left] <= nums[mid - 1]) && (nums[mid + 1] > nums[right])) {
                left = mid + 1;
            } else if ((nums[left] > nums[mid - 1]) && (nums[mid + 1] <= nums[right])) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
