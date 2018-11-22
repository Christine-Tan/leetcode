import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Seven on 07/11/2018.
 */
public class EX200 {
        public int numIslands(char[][] grid) {
            int n = grid.length;
            char[][] grid1 = grid;
            int count=0;
            int m = grid[0].length;
            for(int i = 0;i<n;i++){
                for (int j = 0;j<m;j++){
                    if(grid[i][j]=='1'){
                        count++;
                        bfs(grid,i,j);
                    }
                }
            }
            return count;
        }

        private void bfs(char[][] grid,int i, int j){
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{i,j});
            while(!queue.isEmpty()){
                int[] temp = queue.poll();
                int row = temp[0];
                int column = temp[1];
                if(grid[row][column]=='0'){
                    continue;
                }
                grid[row][column]='0';
                if(row<grid.length-1&&column<grid[row+1].length&&grid[row+1][column]=='1'){
                    queue.offer(new int[]{row+1,column});
                }
                if(row>0&&column<grid[row-1].length&&grid[row-1][column]=='1'){
                    queue.offer(new int[]{row-1,column});
                }
                if(column<grid[row].length-1&&grid[row][column+1]=='1'){
                    queue.offer(new int[]{row,column+1});
                }
                if(column>0&&grid[row][column-1]=='1'){
                    queue.offer(new int[]{row,column-1});
                }

            }
        }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        EX200 ex = new EX200();
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};

        System.out.println(ex.numIslands(grid));

        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "ms");


    }
}


