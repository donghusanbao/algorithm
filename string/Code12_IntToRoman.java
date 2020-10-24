package string;

public class Code12_IntToRoman {
    //92.55%
    public String intToRoman(int num) {
        int standard = 1000;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int high = num / standard;
            num -= (high * standard);
            standard /= 10;
            if (high == 0) {
                continue;
            }
            if (high >= 1 && high <= 3) {
                switch(i){
                    case 0 :
                        getValue(result, 'M', high);
                        break;
                    case 1 :
                        getValue(result, 'C', high);
                        break;
                    case 2 :
                        getValue(result, 'X', high);
                        break;
                    case 3 :
                        getValue(result, 'I', high);
                }
                continue;
            }
            if (high >= 5 && high <= 8) {
                switch(i){
                    case 1 :
                        result.append("D");
                        getValue(result, 'C', (high - 5));
                        break;
                    case 2 :
                        result.append("L");
                        getValue(result, 'X', (high - 5));
                        break;
                    case 3 :
                        result.append("V");
                        getValue(result, 'I', (high - 5));
                        break;
                }
                continue;
            }
            if (high == 4) {
                switch(i){
                    case 1 :
                        result.append("CD");
                        break;
                    case 2 :
                        result.append("XL") ;
                        break;
                    case 3 :
                        result.append("IV");
                }
                continue;
            }
            if (high == 9) {
                switch(i){
                    case 1 :
                        result.append("CM");
                        break;
                    case 2 :
                        result.append("XC");
                        break;
                    case 3 :
                        result.append("IX");
                }
            }
        }
        return result.toString();
    }

    public void getValue(StringBuilder sb, char a, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(a);
        }
    }

    //方法二，时间复杂度为1
    public String intToRoman2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        int res = num;
        for (int i = 0; i < values.length && res > 0; i++) {
            while (res >= values[i]) {
                res -= values[i];
                result.append(symbols[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[] value = {3245, 100, 50, 67, 773};
        Code12_IntToRoman intToRoman = new Code12_IntToRoman();
        String[] result = new String[value.length];
        for (int i = 0; i < value.length; i++) {
            result[i] = intToRoman.intToRoman(value[i]);
            System.out.println(result[i]);
        }
    }
}
