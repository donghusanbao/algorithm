package array;

public class Code80_RemoveDup2 {
    //97% 95%
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }
        int index = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[index]) {
                if (count != 2) {
                    nums[++index] = nums[i];
                    count++;
                }
            } else {
                nums[++index] = nums[i];
                count = 1;
            }
        }
        return index + 1;
    }
}
