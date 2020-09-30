package DSU;

import java.util.LinkedList;
import java.util.Queue;

public class Code2000_IsLandNum {
    //方法一变量
    public int count;

    //方法三 并查集结构
    public static class UnionFindSet {
        public int[] father;
        public int[] size;
        public int count;

        public UnionFindSet(char[][] grid, int row, int col){
            count = 0;
            father = new int[row * col];
            size = new int[row * col];
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(grid[i][j] == '1'){
                        int index = i * col + j;
                        father[index] = index;
                        size[index] = 1;
                        count++;
                    }
                }
            }
        }

        public boolean isSameSet(int index1, int index2){
            int father1 = getFather(index1);
            int father2 = getFather(index2);
            return father1 == father2;
        }

        public int getFather(int index){
            Queue<Integer> queue = new LinkedList<>();
            while(father[index] != index){
                queue.add(index);
                index = father[index];
            }
            while(!queue.isEmpty()){
                int sonIndex = queue.poll();
                father[sonIndex] = index;
            }
            return index;
        }

        public int getCount(){
            return count;
        }

        public void union(int index1, int index2){
            int father1 = getFather(index1);
            int father2 = getFather(index2);
            if(father1 != father2){
                if(size[father1] >= size[father2]){
                    father[father2] = father1;
                    size[father1] += size[father2];
                }else{
                    father[father1] = father2;
                    size[father2] += size[father1];
                }
                count--;
            }
        }
    }

    //方法一：深度优先遍历 97.66% 42.22%
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return count;
    }
    //方法一
    public void dfs(char[][] grid, int r, int c, int row, int col){
        if(r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c, row, col);
        dfs(grid, r + 1, c, row, col);
        dfs(grid, r, c - 1, row, col);
        dfs(grid, r, c + 1, row, col);
    }

    //方法二，广度优先遍历 10.13% 91.96%
    public int numIslands2(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    Queue<Integer> queue = new LinkedList<>();
                    int value = i * col + j;
                    queue.add(value);
                    grid[i][j] = '0';
                    while(!queue.isEmpty()){
                        int val = queue.poll();
                        int r = val / col;
                        int c = val % col;
                        if(((r - 1) >= 0) && (grid[r - 1][c] == '1')){
                            queue.add((r - 1) * col + c);
                            grid[r - 1][c] = '0';
                        }
                        if(((r + 1) < row) && (grid[r + 1][c] == '1')){
                            queue.add((r + 1) * col + c);
                            grid[r + 1][c] = '0';
                        }
                        if(((c - 1) >= 0) && (grid[r][c - 1] == '1')){
                            queue.add(r * col + c - 1);
                            grid[r][c - 1] = '0';
                        }
                        if(((c + 1) < col) && (grid[r][c + 1] == '1')){
                            queue.add(r * col + c + 1);
                            grid[r][c + 1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }

    //方法三：并查集 10.13% 33.92%
    public int numIslands3(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        UnionFindSet set = new UnionFindSet(grid, row, col);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    int index1 = i * col + j;
                    if((i - 1) >= 0 && grid[i - 1][j] == '1'){
                        set.union(index1, (i - 1) * col + j);
                    }
                    if((i + 1) < row && grid[i + 1][j] == '1'){
                        set.union(index1, (i + 1) * col + j);
                    }
                    if((j - 1) >= 0 && grid[i][j - 1] == '1'){
                        set.union(index1, i * col + j - 1);
                    }
                    if((j + 1) < col && grid[i][j + 1] == '1'){
                        set.union(index1, i * col + j + 1);
                    }
                }
            }
        }
        return set.getCount();
    }
}
