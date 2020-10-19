package array;

public class Code88_Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int end = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[end] = nums1[p1];
                p1--;
            } else {
                nums1[end] = nums2[p2];
                p2--;
            }
            end--;
        }
        if (p1 == -1) {
            for (int i = 0; i <= end; i++) {
                nums1[i] = nums2[i];
            }
        }
    }
}
