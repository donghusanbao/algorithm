package array;

public class Code27_RemoveElement {
    //方法一：100% 63.12%
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre = -1;
        int cur = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] ==  val) {
                if (cur == -1) {
                    cur = i;
                    pre = i;
                } else {
                    cur = i;
                }
            } else {
                if (pre != -1) {
                    nums[pre] = nums[i];
                    pre++;
                    cur++;
                }
            }
        }
        if (pre == -1) {
            return nums.length;
        }
        return pre;
    }

    /*
        LeetCode官方方法：
        https://leetcode-cn.com/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode/
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    //考虑如果被删除的元素个数比较少呢？
}
