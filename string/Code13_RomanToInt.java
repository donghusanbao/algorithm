package string;

public class Code13_RomanToInt {
    //时间复杂度N，99.98%
    public int romanToInt(String s) {
        int result = 0;
        int num = s.length();
        for (int i = 0; i < num; i++) {
            char symbol = s.charAt(i);
            switch(symbol){
                case 'I':
                    if (i + 1 < num && (s.charAt(i + 1) == 'V')) {
                        result += 4;
                        i++;
                    } else if (i + 1 < num && s.charAt(i + 1) == 'X') {
                        result += 9;
                        i++;
                    } else {
                        result += 1;
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if (i + 1 < num && s.charAt(i + 1) == 'L') {
                        result += 40;
                        i++;
                    } else if (i + 1 < num && s.charAt(i + 1) == 'C') {
                        result += 90;
                        i++;
                    } else {
                        result += 10;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if (i + 1 < num && s.charAt(i + 1) == 'D') {
                        result += 400;
                        i++;
                    } else if (i + 1 < num && s.charAt(i + 1) == 'M') {
                        result += 900;
                        i++;
                    } else {
                        result += 100;
                    }
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        return result;
    }

    //方法二 99.98%
    public int romanToInt2(String s) {
        int result = 0;
        int num = s.length();
        for (int i = 0; i < num; i++) {
            char symbol = s.charAt(i);
            int cur = charMapInt(symbol);
            if (i + 1 < num) {
                int next = charMapInt(s.charAt(i + 1));
                if (next > cur) {
                    result -= cur;
                } else {
                    result += cur;
                }
            } else {
                result += cur;
            }
        }
        return result;
    }
    public int charMapInt(char ch) {
        switch(ch) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "IV";
        Code13_RomanToInt romanToInt = new Code13_RomanToInt();
        int result = romanToInt.romanToInt(s);
        System.out.println(result);
    }
}
