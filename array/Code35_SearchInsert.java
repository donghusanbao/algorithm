package array;

public class Code35_SearchInsert {
    public int max;
    public int index;
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        max = Integer.MAX_VALUE;
        index = -1;
        int result = process(nums, 0, nums.length - 1, target);
        //第二次提交错误，忘记考虑末尾
        return result == -1 ? (index == -1 ? nums.length : index) : result;
    }
    public int process(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            //第二次提交错误，忘记考虑最小的。
            if (nums[left] > target) {
                if (nums[left] < max) {
                    max = nums[left];
                    index = left;
                }
            }
            return nums[left] == target ? left : -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            //第一次提交错误
            if (nums[mid] < max) {
                max = nums[mid];
                index = mid;
            }
            return process(nums, left, mid - 1, target);
        } else {
            return process(nums, mid + 1, right, target);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6};
        Code35_SearchInsert searchInsert = new Code35_SearchInsert();
        int result = searchInsert.searchInsert(array, 7);
        System.out.println(result);
    }
}
