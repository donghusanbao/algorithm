package array;

public class Code66_PlustOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        int n = digits.length;
        boolean add = false;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                add = false;
                break;
            } else {
                digits[i] = 0;
                add = true;
            }
        }
        if (add) {
            int[] newDigits = new int[n + 1];
            newDigits[0] = 1;
            return newDigits;
        }
        return digits;
    }
}
