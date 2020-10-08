package array;

public class Code33_SearchRevolve {
    //方法一：11% 11% 先找到旋转的点pos，然后根据pos和mid关系返回值，方法不好
    public static int search(int[] nums, int target) {
        int index = findZeroIndex(nums, 0, nums.length - 1);
        index = index == 0 ? nums.length - 1 : index - 1;
        System.out.println("index is " + index);
        return process(nums, 0, nums.length - 1, target, index);
    }

    public static int process(int[] nums, int left, int right, int target, int pos) {
        if (left > right) {
            return -1;
        }

        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }

        int mid = left + (right - left) / 2;
        System.out.println("mid is " + mid);
        System.out.println("mid value is "+ nums[mid]);
        if (nums[mid] == target) {
            return mid;
        }
        if (mid < pos) {
            if (nums[mid] < target) {
                return process(nums, mid + 1, Math.min(pos, right), target, pos);
            } else {
                int leftResult = process(nums, left, mid - 1, target, pos);
                if (leftResult != -1) {
                    return leftResult;
                }
                if (right > pos) {
                    return process(nums, pos + 1, right, target, pos);
                }
                return -1;
            }
        } else if (mid == pos) {
            if (nums[mid] < target) {
                return -1;
            } else {
                int leftResult = process(nums, mid + 1, right, target, pos);
                if (leftResult != -1) {
                    return leftResult;
                }
                int rightResult = process(nums, left, mid - 1, target, pos);
                return rightResult;
            }
        } else {
            if (nums[mid] < target) {
                int rightResult = process(nums, mid + 1, right, target, pos);
                if (rightResult != -1) {
                    return rightResult;
                }
                if (left <= pos) {
                    System.out.println("left <= pos");
                    return process(nums, left, pos, target, pos);
                }
            } else {
                return process(nums, Math.max(pos + 1, left), mid - 1, target, pos);
            }
        }
        return -1;
    }


    public static int findZeroIndex(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        if (left == (right - 1)) {
            if (nums[left] > nums[right]) {
                return right;
            } else {
                return 0;
            }
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
            int result = findZeroIndex(nums, mid + 1, right);
            if (result != 0) {
                return result;
            }
            result = findZeroIndex(nums, left, mid - 1);
            return result;
        } else {
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else {
                return mid;
            }
        }
    }

    //参考官方的方法 100% 66%
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return process(nums, target, 0, nums.length - 1);
    }

    public int process(int[] nums, int target, int left, int right) {
        if (left == right) {
            return nums[left] == target ? left : -1;
        }
        if (left == (right - 1)) {
            if (nums[left] == target || nums[right] == target) {
                return nums[left] == target ? left : right;
            }
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[left] <= nums[mid - 1]) {
            if (nums[left] <= target && nums[mid - 1] >= target) {
                return process(nums, target, left, mid - 1);
            } else {
                return process(nums, target, mid + 1, right);
            }
        } else {
            if (nums[mid + 1] <= target && target <= nums[right]) {
                return process(nums, target, mid + 1, right);
            } else {
                return process(nums, target, left, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {6,7,1,2,3,4,5};
        int index = search(array, 6);
        System.out.println(index);
    }
}
