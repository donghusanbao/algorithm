package array;

public class Code11_MaxArea {
    //自己写的方法
    public static int maxArea(int[] height) {
        int max1 = maxAreaSub(height);
        int[] newHeight = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            newHeight[i] = height[height.length - 1 - i];
        }
        int max2 = maxAreaSub(newHeight);
        return Math.max(max1, max2);
    }

    public static int maxAreaSub(int[] height) {
        int right = -1;
        int c = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (i == 0 || right == -1) {
                for (int j = (height.length - 1); j >= (i + 1); j--) {
                    if (height[j] >= height[i]) {
                        right = j;
                        c = i;
                        max = (right - i) * height[i];
                        break;
                    }
                }
            } else {
                if (height[c] > height[i]) {
                    int temp = -1;
                    for (int j = (height.length - 1); j > right; j--) {
                        if (height[j] >= height[i]) {
                            temp = j;
                            break;
                        }
                    }
                    if (temp == -1) {
                        continue;
                    }
                    if ((temp - i) * height[i] > max) {
                        max = (temp - i) * height[i];
                        right = temp;
                        c = i;
                    }
                } else if (height[c] ==  height[i]) {
                    continue;
                } else {
                    int temp = -1;
                    for (int j = right; j > i; j--) {
                        if (height[j] >= height[i]) {
                            temp = j;
                            break;
                        }
                    }
                    if (temp == -1) {
                        continue;
                    } else {
                        int value = (temp - i) * height[i];
                        if (value > max) {
                            max = value;
                            right = temp;
                            c = i;
                        }
                    }
                }
            }
        }
        return max;
    }

    //官方的方法更好

    public static void main(String[] args) {
        int[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(array));
    }
}
