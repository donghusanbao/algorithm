package dynamic;

public class Code5_PalinDrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] newArray = getNewArray(s);
        int[] half = new int[newArray.length];
        int R = -1;
        int C = -1;
        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < newArray.length; i++) {
            half[i] = R > i ? Math.min(half[2 * C - i], R - i) : 1;
            while (i + half[i] < newArray.length && (i - half[i] >= 0)) {
                if (newArray[i + half[i]] == newArray[i - half[i]]) {
                    half[i]++;
                } else {
                    break;
                }
            }
            if (i + half[i] > R) {
                R = half[i];
                C = i;
            }
            if (half[i] > max) {
                max = half[i];
                maxIndex = i;
            }
        }
        String returnStr = "";
        for (int j = (maxIndex - half[maxIndex] + 1); j < (maxIndex + half[maxIndex]); j++) {
            if (newArray[j] != '#') {
                returnStr += newArray[j];
            }
        }
        return returnStr;
    }

    public char[] getNewArray(String s) {
        char[] str = s.toCharArray();
        char[] result = new char[str.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            if (i % 2 == 1) {
                result[i] = str[index++];
            } else {
                result[i] = '#';
            }
        }
        return result;
    }
}
