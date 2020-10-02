package DSU;

import java.util.LinkedList;
import java.util.Queue;

public class Code130_SurroundArea {
    //方法一：采用并查集 5.18% 88.95%
    public static class UnionFindSet {
        public int[] father;
        public boolean[] edges;
        public int[] size;

        public UnionFindSet(char[][] board){
            int row = board.length;
            int col = board[0].length;
            father = new int[row * col];
            edges = new boolean[row * col];
            size = new int[row * col];
            for(int i = 0;  i < row; i++){
                for(int j = 0; j < col; j++){
                    if(board[i][j] == 'O'){
                        int index = i * col + j;
                        father[index] = index;
                        if(i == 0 || i == (row - 1) || j == 0 || j == (col - 1)){
                            edges[index] = true;
                        }else{
                            edges[index] = false;
                        }
                        size[index] = 1;
                    }
                }
            }
        }

        //方法一：采用并查集
        public int getFather(int index){
            Queue<Integer> queue = new LinkedList<>();
            while(father[index] != index){
                queue.add(index);
                index = father[index];
            }
            while(!queue.isEmpty()){
                int element = queue.poll();
                father[element] = index;
            }
            return index;
        }

        public boolean getFatherEdge(int index){
            int father = getFather(index);
            return edges[father];
        }

        public void union(int index1, int index2){
            int father1 = getFather(index1);
            int father2 = getFather(index2);
            boolean edge = edges[index1] || edges[index2];
            if(father1 != father2){
                if(size[father1] >= size[father2]){
                    father[father2] = father1;
                    size[father1] += size[father2];
                    if(edge || edges[father2]){
                        edges[father1] = true;
                    }
                }else{
                    father[father1] = father2;
                    size[father2] += size[father1];
                    if(edge || edges[father1]){
                        edges[father2] = true;
                    }
                }
            }
        }
    }
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int row = board.length;
        int col = board[0].length;
        UnionFindSet set = new UnionFindSet(board);
        for(int i = 0;  i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O'){
                    int index1 = i * col + j;
                    int index2;
                    if((i - 1) >= 0 && board[i - 1][j] == 'O'){
                        index2 = (i - 1) * col + j;
                        set.union(index1, index2);
                    }
                    if((i + 1) < row && board[i + 1][j] == 'O'){
                        index2 = (i + 1) * col + j;
                        set.union(index1, index2);
                    }
                    if((j - 1) >= 0 && board[i][j - 1] == 'O'){
                        index2 = i * col + j - 1;
                        set.union(index1, index2);
                    }
                    if((j + 1) < col && board[i][j + 1] == 'O'){
                        index2 = i * col + j + 1;
                        set.union(index1, index2);
                    }
                }
            }
        }
        for(int i = 0;  i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O'){
                    int index = i * col + j;
                    boolean edge = set.getFatherEdge(index);
                    if(!edge){
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
}
