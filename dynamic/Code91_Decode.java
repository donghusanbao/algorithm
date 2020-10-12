package dynamic;

public class Code91_Decode {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int[] results = new int[str.length + 1];
        results[str.length] = 1;
        results[str.length - 1] = str[str.length - 1] == '0' ? 0 : 1;
        for (int i = str.length - 2; i >= 0; i--) {
            if (str[i] == '0') {
                results[i] = 0;
                continue;
            }
            if (str[i] > '2' || (str[i] == '2' && str[i] > '6')) {
                results[i] = results[i + 1];
            } else {
                results[i] = results[i + 1] + results[i + 2];
            }
        }
        for (int a : results) {
            System.out.println(a);
        }
        return results[0];
    }

    public static void main(String[] args) {
        String s = "300";
        Code91_Decode decode = new Code91_Decode();
        System.out.println(decode.numDecodings(s));
    }
}
