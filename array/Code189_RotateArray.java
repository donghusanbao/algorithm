package array;

public class Code189_RotateArray {
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) {
            return;
        }
        int n = nums.length;
        int newK = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, newK - 1);
        reverse(nums, newK, n - 1);
    }
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public static void rotate2(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) {
            return;
        }
        int n = nums.length;
        int newK = k % n;
        //第一次提交忘记了
        if (newK == 0) {
            return;
        }
        int count = 0;
        int startPoint = 0;
        int tmp = nums[startPoint];
        int mid = 0;
        while (count < n) {
            int j = 1;
            while ((startPoint + j * newK) % n != startPoint) {
                count++;
                int next = (startPoint + j * newK) % n;
                mid = nums[next];
                nums[next] = tmp;
                tmp = mid;
                j++;
            }
            nums[startPoint] = tmp;
            startPoint++;
            tmp = nums[startPoint];
            count++;
        }
    }

    public static void main(String[] args) {
        int[] array1 = {-1, -100, 3, 99};
        int[] array2 = {1, 2, 3, 4, 5, 6};
        rotate2(array2, 4);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array2.length; i++) {
            sb.append(array2[i]);
        }
        System.out.println(sb.toString());
    }
}
