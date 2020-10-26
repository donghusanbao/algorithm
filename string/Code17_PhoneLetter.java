package string;

import java.util.ArrayList;
import java.util.List;

public class Code17_PhoneLetter {
    public static class Letter {
        char[] symbols;
        int size;
        public Letter(int size) {
            this.size = size;
            symbols = new char[size];
        }
        public void add(char c, int index) {
            symbols[index] = c;
        }
    }
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        char start = 'a';
        Letter[] letters = new Letter[8];
        for (int i = 2; i <= 9; i++) {
            if (i == 7 || i == 9) {
                letters[i - 2] = new Letter(4);
            } else {
                letters[i - 2] = new Letter(3);
            }
            for (int j = 0; j < letters[i - 2].size; j++) {
                letters[i - 2].add(start++, j);
            }
        }
        List<String> results = new ArrayList<>();
        char[] path = new char[digits.length()];
        process(results, digits, 0, path, letters);
        return results;
    }

    public static void process(List<String> results, String digits, int pos
            , char[] path, Letter[] letters) {
        if (pos == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pos; i++) {
                sb.append(path[i]);
            }
            results.add(sb.toString());
        } else {
            char intVal = digits.charAt(pos);
            Letter letter = letters[intVal - '2'];
            for (int i = 0; i < letter.size; i++) {
                path[pos] = letter.symbols[i];
                process(results, digits, pos + 1, path, letters);
            }
        }
    }


    public static void main(String[] args) {
        List<String> results = letterCombinations("23");
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}
