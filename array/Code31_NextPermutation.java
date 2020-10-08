package array;

public class Code31_NextPermutation {
    //99.74 97.92
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int length = nums.length;
        int start = 0;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int tmp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
                start = i;
                System.out.println("start is " + start);
                break;
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            if (start < i) {
                int tmp = nums[start];
                nums[start] = nums[i];
                nums[i] = tmp;
            }
            start++;
        }
    }
}
