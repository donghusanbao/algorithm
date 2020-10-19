package array;

public class Code79_WordExist {
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0
                || word == null || word.length() == 0) {
            return false;
        }
        char[] wordChar = word.toCharArray();
        int wordLenth = wordChar.length;
        int pos = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == wordChar[0]) {
                    if (wordLenth == 1) {
                        return true;
                    } else {
                        boolean find = process(board, i, j, wordChar, 0);
                        if (find) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean process(char[][] board, int row, int col, char[] word, int pos) {
        if (pos == word.length - 1) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        boolean find = false;
        char tmp = board[row][col];
        board[row][col] = '#';
        if ((row + 1 < m) && (board[row + 1][col] == word[pos + 1])) {
            find |= process(board, row + 1, col, word, pos + 1);
        }
        if (find) {
            return true;
        }
        if ((row - 1 >= 0) && (board[row - 1][col] == word[pos + 1])) {
            find |= process(board, row - 1, col, word, pos + 1);
        }
        if (find) {
            return true;
        }
        if ((col + 1 < n) && (board[row][col + 1] == word[pos + 1])) {
            find |= process(board, row, col + 1, word, pos + 1);
        }
        if (find) {
            return true;
        }
        if ((col - 1 >= 0) && (board[row][col - 1] == word[pos + 1])) {
            find |= process(board, row, col - 1, word, pos + 1);
        }
        if (find) {
            return true;
        }
        board[row][col] = tmp;
        return false;
    }
    public static void main(String[] args) {
        char[][] array = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        char[][] array2 = {{'a', 'b'}};
        String word = "ba";
        String word2 = "ABCEFSADEESE";
        System.out.println(exist(array, word2));
    }
}
