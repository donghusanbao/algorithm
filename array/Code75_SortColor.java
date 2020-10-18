package array;

public class Code75_SortColor {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int red = 0, blue = n - 1;
        int cur = 0;
        while (cur <= blue) {
            if (nums[cur] == 2) {
                int tmp = nums[blue];
                nums[blue] = 2;
                nums[cur] = tmp;
                blue--;
            } else if (nums[cur] == 0) {
                if (nums[red] != 0) {
                    nums[red] = 0;
                    nums[cur] = 1;
                }
                red++;
                cur++;
            } else {
                cur++;
            }
        }
    }
}
